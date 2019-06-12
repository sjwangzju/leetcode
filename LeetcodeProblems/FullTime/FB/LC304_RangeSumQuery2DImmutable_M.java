package FullTime.FB;

/**
 * save cumulative sums in a matrix (2D dp)
 *
 * time: O(1)
 * space: O(MN)
 *
 */
public class LC304_RangeSumQuery2DImmutable_M {

    static class NumMatrix {

        int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            int row = matrix.length;
            int col = matrix[0].length;

            dp = new int[row + 1][col + 1];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2,1,4,3));
        System.out.println(obj.sumRegion(1,1,2,2));
    }

}
