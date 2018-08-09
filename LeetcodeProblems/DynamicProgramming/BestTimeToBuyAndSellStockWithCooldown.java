package DynamicProgramming;

/**
 * Created by sjwang on 08/09/2018.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if(prices == null) return 0;
        int rest = 0, sold = 0, hold = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            int last_rest = rest;
            rest = Math.max(rest, sold);
            sold = hold + prices[i];
            hold = Math.max(last_rest - prices[i], hold);
        }
        return Math.max(rest, sold);
    }
    public static void main(String args[]){
        int[] prices = {1,2,3,0,2};
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(prices));
    }
}
