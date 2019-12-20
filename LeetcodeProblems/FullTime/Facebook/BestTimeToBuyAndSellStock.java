package FullTime.Facebook;

public class BestTimeToBuyAndSellStock {

    // stock I - at most one transaction
    //
    // Input: [7,1,5,3,6,4]
    // Output: 5
    // Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    //             Not 7-1 = 6, as selling price needs to be larger than buying price.
    //
    //
    // 1. find max profit: one transaction
    // 2. max = prices[i] - min
    //
    // time: O(N), space: O(1)
    public int maxProfitI(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return max;
    }


    // stock II - no limited transactions
    //
    // Input: [7,1,5,3,6,4]
    // Output: 7
    // Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    //             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    //
    // 1. find max profit: multiple transactions
    // 2. sum += prices[i] - prices[i - 1]
    //
    // time: O(N), space: O(1)
    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }


    // stock III - at most 2 transactions
    //
    // Input: [3,3,5,0,0,3,1,4]
    // Output: 6
    // Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
    //             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
    //
    // 1. 2D DP
    //
    // time: O(N^2), space: O(N)
    public int maxProfitIII(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;
        int[][] dp = new int[3][len];

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j < len; j++) {
                // buy stock on day j (profit same as day j - 1)
                dp[i][j] = dp[i][j - 1];

                // sell stock on day j
                for (int m = 0; m < j; m++) {
                    dp[i][j] = Math.max(dp[i][j], prices[j] - prices[m] + dp[i - 1][m]);
                }
            }
        }
        return dp[2][len - 1];
    }


    // stock IV - at most k transactions
    //
    // 1. 2D DP
    //
    // time: O(k*N^2), space: O(k*N)
    public int maxProfitIV(int[] prices, int k) {
        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;

        if (k > len / 2) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
            }
            return res;
        } else {
            int[][] dp = new int[k + 1][len];

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j < len; j++) {
                    // buy stock on day j (profit same as day j - 1)
                    dp[i][j] = dp[i][j - 1];

                    // sell stock on day j
                    for (int m = 0; m < j; m++) {
                        dp[i][j] = Math.max(dp[i][j], prices[j] - prices[m] + dp[i - 1][m]);
                    }
                }
            }
            return dp[k][len - 1];
        }
    }
}
