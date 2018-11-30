package Airbnb;

import java.util.*;

public class MeetingTime_17 {
    /**
     * lc252
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }

    /**
     * lc253
     * @param intervals
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int min = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                if (intervals[i].start < pq.peek()) {
                    min++;
                } else {
                    pq.poll();
                }
            } else {
                pq.remove(intervals[i - 1].end);
            }
            pq.offer(intervals[i].end);
        }
        return min;
    }

    /**
     * Airbnb_17
     * @param intervals
     * @return
     */
    public List<List<Integer>> availableIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        pq.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start > pq.peek()) {
                List<Integer> cur = new ArrayList<>(Arrays.asList(pq.peek(), intervals[i].start));
                res.add(cur);
            }
            pq.offer(intervals[i].end);
        }
        return res;
    }

    public static class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {start = s; end = e;}
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[5];
        intervals[0] = new Interval(1,3);
        intervals[1] = new Interval(6,7);
        intervals[2] = new Interval(2,4);
        intervals[3] = new Interval(2,3);
        intervals[4] = new Interval(9,12);
//        boolean res = new MeetingTime_17().canAttendMeetings(intervals);
//        System.out.println(res);
//        int min = new MeetingTime_17().minMeetingRooms(intervals);
//        System.out.println(min);

        List<List<Integer>> res = new MeetingTime_17().availableIntervals(intervals);
        for (List<Integer> list: res) {
            System.out.println(list.get(0) + " -- " + list.get(1));
        }
    }
}
