package TuSimple;

public class PaintHouse {

    /**
     * dp[][]
     * time: O(nk^2), space: O(nk)
     *
     * @param costs
     * @return
     */
    public int minCostI(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int row = costs.length;
        int col = costs[0].length;
        int[][] dp = new int[row][col];

        for (int j = 0; j < col; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = getMin(dp, i, j) + costs[i][j];
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            res = Math.min(res, dp[row - 1][j]);
        }
        return res;
    }

    public int getMin(int[][] dp, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int n = 0; n < dp[0].length; n++) {
            if (n == j) continue;
            min = Math.min(min, dp[i - 1][n]);
        }
        return min;
    }


    /**
     * time: O(nk), space: O(1)
     *
     * @param costs
     * @return
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int row = costs.length;
        int col = costs[0].length;

        int prevMin = 0;
        int prevSecondMin = 0;
        int prevColor = 0;

        for (int i = 0; i < row; i++) {
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            int color = -1;

            for (int j = 0; j < col; j++) {
                int cur = costs[i][j];
                if (j == prevColor) {
                    cur += prevSecondMin;
                } else {
                    cur += prevMin;
                }

                if(color == -1) {
                    color = j;
                    min = cur;
                } else if (cur < min) {
                    secondMin = min;
                    min = cur;
                    color = j;
                } else if (cur < secondMin) {
                    secondMin = cur;
                }
            }

            prevMin = min;
            prevSecondMin = secondMin;
            prevColor = color;
        }

        return prevMin;
    }

    public static void main(String[] args) {
        int[][] costs = {{1,5,3},{2,9,4}};
        System.out.println(new PaintHouse().minCostII(costs));
    }
}
