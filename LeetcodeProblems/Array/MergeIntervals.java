package Array;

import Heap.MeetingRoomsII;
import Heap.MergeKSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sjwang on 07/22/2018.
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) return new ArrayList<>();
        PriorityQueue<Interval> p = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Interval> q = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o2.end - o1.end;
            }
        });
        for(int i = 0; i < intervals.size(); i++) p.offer(intervals.get(i));
        q.offer(p.poll());
        while(!p.isEmpty()){
            Interval pp = p.poll(), qq = q.poll();
            if(pp.start <= qq.end) qq.end = Math.max(pp.end, qq.end);
            else q.offer(pp);
            q.offer(qq);
        }
        p.clear();
        while(!q.isEmpty()) p.offer(q.poll());
        List<Interval> L = new ArrayList<>();
        while(!p.isEmpty()){
            L.add(p.poll());
        }
        return L;
    }
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public static void main(String args[]){
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);
        List<Interval> L = new ArrayList<>();
        L.add(i1); L.add(i2); L.add(i3); L.add(i4);
        System.out.println(new MergeIntervals().merge(L));
    }
}
