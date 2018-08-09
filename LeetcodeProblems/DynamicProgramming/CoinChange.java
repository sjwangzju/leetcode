package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by sjwang on 08/09/2018.
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null) return -1;
        long[] dp = new long[amount + 1];
        for(int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;
        for(int coin : coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] <= amount ? (int)dp[amount] : -1;
    }
    public static void main(String args[]){
        int[] coins = {186,419,83,408};
        System.out.println(new CoinChange().coinChange(coins, 6249));
    }
}
