package FullTime.LinkedIn;

public class PaintHouse {

    /**
     * Paint House I
     *
     * Input: [[17,2,17],[16,16,5],[14,3,19]]
     * Output: 10
     * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
     *              Minimum cost: 2 + 5 + 3 = 10.
     *
     * Thoughts:
     * 1. keep 3 variables
     * 2. record the min cost at each current color
     *
     * time: O(N), space: O(1)
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int red = costs[0][0], blue = costs[0][1], green = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            int n1 = Math.min(blue, green) + costs[i][0];
            int n2 = Math.min(red, green) + costs[i][1];
            int n3 = Math.min(red, blue) + costs[i][2];
            red = n1;
            blue = n2;
            green = n3;
        }
        return Math.min(red, Math.min(green, blue));
    }


    /**
     * Paint House II
     *
     * There are a row of n houses, each house can be painted with one of the k colors.
     *
     * Thoughts:
     * 1. keep 2 variables
     * 2. record the index of first and second min cost
     *
     * time: O(nk), space: O(1)
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int min1 = -1, min2 = -1;

        for (int i = 0; i < costs.length; i++) {
            int prev1 = min1, prev2 = min2;
            min1 = -1; min2 = -1;

            for (int j = 0; j < costs[0].length; j++) {
                if (j == prev1) {
                    costs[i][j] += prev2 < 0? 0: costs[i - 1][prev2];
                } else {
                    costs[i][j] += prev1 < 0? 0: costs[i - 1][prev1];
                }
                if (min1 == -1 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 == -1 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        return costs[costs.length - 1][min1];
    }
}
