package FullTime.FB;

import java.util.Arrays;

/**
 * Sort
 *
 * time: O(NlogN)
 * space: O(1)
 */
public class LC252_MeetingRooms_E {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] - b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(new LC252_MeetingRooms_E().canAttendMeetings(intervals));
    }
}
