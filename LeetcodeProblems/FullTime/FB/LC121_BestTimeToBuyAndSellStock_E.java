package FullTime.FB;

public class LC121_BestTimeToBuyAndSellStock_E {

    //left[] for min from left & right[] for max from right
    // Max(right[i] - left[i])
    //
    // time: O(N)
    // space: O(N)
    public int maxProfitI(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int l = prices.length;
        int[] left = new int[l];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l; i++) {
            min = Math.min(min, prices[i]);
            left[i] = min;
        }

        int[] right = new int[l];
        int max = Integer.MIN_VALUE;
        for (int i = l - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = max;
        }

        int res = 0;
        for (int i = 0; i < l; i++) {
            res = Math.max(res, right[i] - left[i]);
        }
        return res;
    }

    // time: O(N)
    // space: O(1)
    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int max = 0;

        for (int n: prices) {
            if (n < minPrice) {
                minPrice = n;
            } else if (n - minPrice > max) {
                max = n - minPrice;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new LC121_BestTimeToBuyAndSellStock_E().maxProfitII(prices));
    }
}
