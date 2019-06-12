package FullTime.FB;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * time: O(NlogN)
 * space: O(1)
 */
public class LC55_MergeIntervals_M {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] - b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new LinkedList<>();

        int i = 0;
        while (i < intervals.length) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{4,5}};
        int[][] res = new LC55_MergeIntervals_M().merge(intervals);

        for (int[] n: res) {
            System.out.println(n[0] + " " + n[1]);
        }
    }
}
