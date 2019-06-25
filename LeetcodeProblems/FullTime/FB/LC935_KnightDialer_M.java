package FullTime.FB;

import java.util.Arrays;

/**
 * recursion + dp (memory)
 *
 * time: O(N), fill the dp[][]
 * space: O(N)
 */
public class LC935_KnightDialer_M {

    public int knightDialer(int N) {
        int res = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        int[][] neigh = new int[][]{{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        int[][] dp = new int[N][10];

        for (int[] n: dp) {
            Arrays.fill(n, -1);
        }
        for (int i = 0; i < 10; i++) {
            res += sum(dp, neigh, i, N - 1, mod);
            res %= mod;
        }
        return res;
    }

    public int sum(int[][] dp, int[][] neigh, int num, int N, int mod) {
        if (N == 0) return 1;
        if (dp[N][num] != -1) {
            return dp[N][num];
        }

        int cur = 0;
        for (int n: neigh[num]) {
            cur += sum(dp, neigh, n, N - 1, mod);
            cur %= mod;
        }
        dp[N][num] = cur;
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new LC935_KnightDialer_M().knightDialer(100));
    }
}
