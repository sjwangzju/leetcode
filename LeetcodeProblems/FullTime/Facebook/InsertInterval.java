package FullTime.Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

    // Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    // You may assume that the intervals were initially sorted according to their start times.
    //
    // Solution1:
    // 1. add the new interval and sort
    // 2. merge intervals
    //
    // time: O(NlogN), space: O(N)
    public int[][] insertI(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);

        Collections.sort(list, (int[] a, int[] b) -> (a[0] == b[0]? a[1] - b[1]: a[0] - b[0]));

        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i)[0], end = list.get(i)[1];
            while (i + 1 < list.size() && list.get(i + 1)[0] <= end) {
                end = Math.max(end, list.get(i + 1)[1]);
                i++;
            }
            res.add(new int[]{start, end});
        }
        return res.toArray(new int[res.size()][2]);
    }

    // Solution2:
    // 1. linear search
    // time: O(N), space: O(N)
    /*******************************************************************/
    public int[][] insertII(int[][] intervals, int[] newInterval) {
        int i = 0, start = newInterval[0], end = newInterval[1];
        List<int[]> list = new ArrayList<>();

        // add the intervals which ends before the new one starts
        while (i < intervals.length && intervals[i][1] < start) {
            list.add(intervals[i++]);
        }

        // merge the intervals that have overlaps with the new one
        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        list.add(new int[]{start, end});

        // add the intervals which ends after the new one ends
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
