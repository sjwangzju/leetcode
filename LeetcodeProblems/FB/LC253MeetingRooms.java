package FB;

import java.text.SimpleDateFormat;
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
     * lc252
     * time: O(N), space: O(1)
     *
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
     * lc253
     * time: O(NlogN), space: O(N)
     *
     */
    public int minMeetingRoom(String[] times) throws Exception {
        if (times.length == 0 || times == null) {
            return 0;
        }
        Interval[] intervals = new Interval[times.length];
        for (int i = 0; i < times.length; i++) {
            intervals[i] = getInterval(times[i]);
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

    // input is in string format, should use SimpleDateFormat to parse it
    public Interval getInterval(String time) throws Exception {
        String[] strs = time.split("-");

        SimpleDateFormat f1 = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat f2 = new SimpleDateFormat("hh a");
        SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm");

        String start;
        String end;
        if (strs[0].length() <= 6) {
            start = date24Format.format(f2.parse(strs[0]));
        } else {
            start = date24Format.format(f1.parse(strs[0]));
        }

        if (strs[1].length() <= 6) {
            end = date24Format.format(f2.parse(strs[1]));
        } else {
            end = date24Format.format(f1.parse(strs[1]));
        }

        int startTime = Integer.parseInt(start.substring(0, 2) + start.substring(3));
        int endTime = Integer.parseInt(end.substring(0, 2) + end.substring(3));
        return new Interval(startTime, endTime);
    }

    public static void main(String[] args) throws Exception{
//        Interval[] intervals = new Interval[3];
//        intervals[0] = new Interval(0,5);
//        intervals[1] = new Interval(4,10);
//        intervals[2] = new Interval(15,20);
//        System.out.println(new LC253MeetingRooms().canAttendMeetings(intervals));
//        System.out.println(new LC253MeetingRooms().minMeetingRoom(intervals));

        String[] times = {"12 AM - 5:00 AM", "4 AM - 10 AM", "3 PM - 8 PM"};
        System.out.println(new LC253MeetingRooms().minMeetingRoom(times));
    }
}
