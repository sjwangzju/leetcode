package DynamicProgramming;

/**
 * Created by sjwang on 08/19/2018.
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its
 * upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DImmutable {
    static class NumMatrix {
        int[][] dp;
        boolean isNull = false;
        public NumMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) isNull = true;
            else{
                int row = matrix.length, col = matrix[0].length;
                dp = new int[row][col + 1];
                for(int i = 0; i < row; i++) {
                    for(int j = 1; j <= col; j++) {
                        dp[i][j] = dp[i][j - 1] + matrix[i][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(isNull) return 0;
            int sum = 0;
            for(int i = row1; i <= row2; i++) {
                sum += dp[i][col2 + 1] - dp[i][col1];
            }
            return sum;
        }
    }
    public static void main(String args[]) {
        int[][] matrix = {};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(1, 1, 2, 2));
    }
}
