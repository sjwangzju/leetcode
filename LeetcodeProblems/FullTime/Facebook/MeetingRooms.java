package FullTime.Facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {

    // Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    // determine if a person could attend all meetings.
    //
    // Input: [[0,30],[5,10],[15,20]]
    // Output: false
    //
    // time: O(NlogN), space: O(1)
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] == b[0]? a[1] - b[1]: a[0] - b[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }


    // Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    // find the minimum number of conference rooms required.
    //
    // Input: [[0, 30],[5, 10],[15, 20]]
    // Output: 2
    //
    // time: O(NlogN), space: O(N)
    public int minMeetingRoomsII(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if (pq.isEmpty()) {
                pq.offer(end);
            } else {
                if (start >= pq.peek()) {
                    pq.poll();
                }
                pq.offer(end);
            }
        }
        return pq.size();
    }
}
