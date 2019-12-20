package FullTime.OCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    // Given a collection of intervals, merge all overlapping intervals.
    //
    // Input: [[1,3],[2,6],[8,10],[15,18]]
    // Output: [[1,6],[8,10],[15,18]]
    // Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6]
    //
    // Thoughts:
    // 1. sort by start time
    // 2. for loop to merge
    //
    // time: O(NlogN), space: O(N)
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] == b[0]? a[1] - b[1]: a[0] - b[0]));
        for (int i = 0; i < intervals.length; i++) {
            int lo = intervals[i][0], hi = intervals[i][1];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= hi) {
                hi = Math.max(hi, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{lo, hi});
        }
        return list.toArray(new int[list.size()][2]);
    }
}
