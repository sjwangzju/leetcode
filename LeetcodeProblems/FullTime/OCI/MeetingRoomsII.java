package FullTime.OCI;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    // Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    // find the minimum number of conference rooms required.
    //
    // Input: [[0, 30],[5, 10],[15, 20]]
    // Output: 2
    //
    // Thoughts:
    // 1. sort by start time
    // 2. pq sort by end time
    //
    // time: O(NlogN), space: O(N)
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> (a[0] == b[0]? a[1] - b[1]: a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a-b));

        for (int i = 0; i < intervals.length; i++) {
            if (!pq.isEmpty() && intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}
