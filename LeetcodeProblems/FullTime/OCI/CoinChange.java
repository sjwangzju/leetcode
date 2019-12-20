package FullTime.OCI;

public class CoinChange {

    // You are given coins of different denominations and a total amount of money amount.
    // Write a function to compute the fewest number of coins that you need to make up that amount.
    // If that amount of money cannot be made up by any combination of the coins, return -1.
    //
    // Input: coins = [1, 2, 5], amount = 11
    // Output: 3
    // Explanation: 11 = 5 + 5 + 1
    //
    // Solution: recursion + memo (1D dp)
    //
    // time: O(M*N), M is amount, N is type of coins
    // space: O(M)
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
