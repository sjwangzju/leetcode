package FullTime.Facebook;

public class RangeSumQuery2DImmutable {

    // Given a 2D matrix matrix, find the sum of the elements inside the rectangle
    // defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
    //
    // Solution1:
    // 1. store the accumulative sum for each row
    //
    // space: O(M*N)
    class NumMatrixI {
        int[][] dp;
        int m, n;

        // time: O(M*N)
        public NumMatrixI(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            m = matrix.length;
            n = matrix[0].length;
            dp = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j + 1] = matrix[i][j] + dp[i][j];
                }
            }
        }

        // time: O(M)
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = 0;
            for (int i = row1; i <= row2; i++) {
                res += dp[i][col2 + 1] - dp[i][col1];
            }
            return res;
        }
    }


    // Solution2:
    // 1. store the left-up(rectangular) sum
    //
    // space: O(M*N)
    class NumMatrixII {
        // space: O(M*N)
        int[][] dp;
        int m, n;

        // time: O(M*N)
        public NumMatrixII(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            m = matrix.length;
            n = matrix[0].length;
            dp = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
                }
            }
        }

        // time: O(1)
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
        }
    }

}
