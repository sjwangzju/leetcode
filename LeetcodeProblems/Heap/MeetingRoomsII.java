package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sjwang on 07/18/2018.
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        PriorityQueue<Interval> p = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Interval> q = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        for(int i = 0; i < intervals.length; i ++){
            p.offer(intervals[i]);
        }
        q.offer(p.poll());
        while(!p.isEmpty()){
            Interval pp = p.poll();
            Interval qq = q.peek();
            if(pp.start >= qq.end){
                qq.end = pp.end;
                q.poll();
                q.offer(qq);
            }
            else{
                q.offer(pp);
            }
        }
        return q.size();
    }
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public static void main(String args[]){
        Interval[] intervals = new Interval[2];
        intervals[0] = new Interval(7,10);
        intervals[1] = new Interval(2,4);
        System.out.println(new MeetingRoomsII().minMeetingRooms(intervals));
    }
}
