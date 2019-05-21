package Intuit;

import java.util.LinkedList;
import java.util.List;

public class MeetingRooms_2 {

    /*************************************************************************************/

    // find if the new meeting can be arranged

    // time: O(N), N is the num of meetings
    // space: O(1)
    public boolean isAvailable(int[][] meetings, int[] newMeeting) {
//        List<int[]> list = new LinkedList<>();
//
//        for (int[] meeting: meetings) {
//            list.add(meeting);
//        }
//        list.sort((a,b) -> (a[0] - b[0]));
//
//        int t1 = newMeeting[0];
//        int t2 = newMeeting[1];
//
//        // earlier than the first meeting
//        if (t1 < list.get(0)[0]) {
//            if (t2 > list.get(0)[0]) return false;
//            return true;
//        }
//
//        // later than the last meeting
//        if (t1 >= list.get(list.size() - 1)[0]) {
//            if (t1 >= list.get(list.size() - 1)[1]) return true;
//            return false;
//        }
//
//        // find the position of the new meeting with binary search
//        int pos = findPos(list, t1);
//        return t1 >= list.get(pos - 1)[1] && t2 <= list.get(pos)[0];

        for (int[] meeting: meetings) {
            int n1 = newMeeting[0];
            int n2 = newMeeting[1];

            if (n2 <= meeting[0] || n1 >= meeting[1]) continue;
            return false;
        }
        return true;
    }

//    // find position with binary search
//    public int findPos(List<int[]> list, int start) {
//        int lo = 0;
//        int hi = list.size() - 1;
//
//        while (lo < hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (start < list.get(mid)[0]) {
//                if (start > list.get(mid - 1)[0]) {
//                    return mid;
//                }
//                hi = mid;
//            } else {
//                lo = mid + 1;
//            }
//        }
//        return lo;
//    }



    /*************************************************************************************/

    // merge intervals

    // time: O(NlogN), N is the num of meetings
    // space: O(N)
    public List<int[]> mergeIntervals(int[][] meetings) {
        List<int[]> list = new LinkedList<>();
        List<int[]> res = new LinkedList<>();
        List<int[]> free = new LinkedList<>();

        for (int[] meeting: meetings) {
            list.add(meeting);
        }
        list.sort((a,b) -> (a[0] - b[0]));

        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            int t1 = list.get(i)[0];
            int t2 = list.get(i)[1];
            if (t1 <= end) {
                end = Math.max(end, t2);
            } else {
                res.add(new int[]{start, end});
                start = t1;
                end = t2;
            }
        }
        res.add(new int[]{start, end});

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
