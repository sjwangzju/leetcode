package FullTime.Walmart;

public class CoinChange {

    // recursion + memo
    // time: O(M*N), space: O(M), M is amount, N is num of coin types
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 1) return 0;
        return getMin(coins, new int[amount], amount);
    }

    public int getMin(int[] coins, int[] dp, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (dp[amount - 1] != 0) return dp[amount - 1];

        int res = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (amount >= coin) {
                int tmp = getMin(coins, dp, amount - coin);
                if (tmp >= 0) {
                    res = Math.min(res, tmp + 1);
                }
            }
        }
        dp[amount - 1] = res == Integer.MAX_VALUE? -1: res;
        return dp[amount - 1];
    }
}
