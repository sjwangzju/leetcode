package Intuit;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MeetingRooms_2 {

    // find if the new meeting can be arranged
    // time: O(N), N is the num of meetings
    // space: O(1)
    /*************************************************************************************/
    public boolean isAvailable(int[][] meetings, int[] newMeeting) {
        for (int[] meeting : meetings) {
            int start = newMeeting[0];
            int end = newMeeting[1];
            if (end <= meeting[0] || start >= meeting[1]) continue;
            return false;
        }
        return true;
    }

    // Follow up 1: merge intervals
    // time: O(NlogN), N is the num of meetings
    // space: O(N)
    /*************************************************************************************/
    public List<int[]> mergeIntervals(int[][] meetings) {
        List<int[]> res = new LinkedList<>();
        List<int[]> free = new LinkedList<>();
        List<int[]> list = new LinkedList<>(Arrays.asList(meetings));

        list.sort((a, b) -> (a[0] - b[0]));

        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i)[0], end = list.get(i)[1];
            while (i + 1 < meetings.length && list.get(i + 1)[0] <= end) {
                end = Math.max(end, list.get(i + 1)[1]);
                i++;
            }
            res.add(new int[]{start, end});
        }

        // get all free intervals
        // add [0, start]
        if (res.get(0)[0] != 0) {
            free.add(new int[]{0, res.get(0)[0]});
        }
        for (int i = 1; i < res.size(); i++) {
            free.add(new int[]{res.get(i - 1)[1], res.get(i)[0]});
        }
        return free;
    }


    /*************************************************************************************/
    public static void main(String[] args) {
//        int[][] meetings = {{1300,1500},{930,1200},{830,845}};
//        int[] newMeeting = {1500,1600};
//        System.out.println(new MeetingRooms_2().isAvailable(meetings, newMeeting));

        int[][] meetings = {{1230,1300},{845,900},{1300,1500},{930,1200},{1600,2359},{845,915},{1515,1545}};
        List<int[]> list = new MeetingRooms_2().mergeIntervals(meetings);
        for (int[] n: list) {
            System.out.println(n[0] + " " + n[1]);
        }
    }
}
