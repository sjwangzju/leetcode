package FullTime.Walmart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestFibonacciSubsequence {

    // Solution 1: HashSet
    // time: O(N^2logM), M is max num in A
    // space: O(N)
    public int lenLongestFibSubseqI(int[] A) {
        if (A == null || A.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int n: A) set.add(n);

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int len = 2, a = A[i], b = A[j];
                while (set.contains(a + b)) {
                    len++;
                    int tmp = a;
                    a = b;
                    b = tmp + b;
                }
                res = Math.max(res, len);
            }
        }
        return res >= 3? res: 0;
    }

    // Solution 2: 2D DP
    // time: O(N^2), space: O(N^2)
    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0) return 0;

        int n = A.length, res = 0;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            index.put(A[i], i);
        }

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    dp[j][k] = (Math.max(dp[i][j], 2)) + 1;
                    res = Math.max(res, dp[j][k]);
                }
            }
        }
        return res >= 3? res: 0;
    }
}
