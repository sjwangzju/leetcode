package FullTime.FB;

import java.util.LinkedList;
import java.util.List;

/**
 * time: O(M+N)
 * space: O(M+N)
 */
public class LC986_IntervalListIntersections_M {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> list = new LinkedList<>();

        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) {
                list.add(new int[]{lo, hi});
            }
            if (A[i][1] <= B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        int[][] res = new LC986_IntervalListIntersections_M().intervalIntersection(A, B);
        for (int[] n: res) {
            System.out.println(n[0] + " " + n[1]);
        }
    }
}
