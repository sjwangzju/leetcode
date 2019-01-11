package FB;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC253MeetingRooms {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    /**
     * time: O(N), space: O(1)
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((interval1, interval2) -> interval1.start - interval2.start);
        for (Interval in: intervals) {
            pq.offer(in);
        }
        int end = 0;
        while(!pq.isEmpty()) {
            Interval cur = pq.poll();
            if (cur.start < end) {
                return false;
            }
            end = cur.end;
        }
        return true;
    }

    /**
     * time: O(NlogN), space: O(N)
     * @param intervals
     * @return
     */
    public int minMeetingRoom(Interval[] intervals) {
        if (intervals.length == 0 || intervals == null) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int cnt = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= pq.peek()){
                pq.poll();
            } else {
                cnt++;
            }
            pq.offer(intervals[i].end);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0,5);
        intervals[1] = new Interval(4,10);
        intervals[2] = new Interval(15,20);
        System.out.println(new LC253MeetingRooms().canAttendMeetings(intervals));
        System.out.println(new LC253MeetingRooms().minMeetingRoom(intervals));
    }
}
