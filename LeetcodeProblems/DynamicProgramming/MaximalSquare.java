package DynamicProgramming;

/**
 * Created by sjwang on 08/19/2018.
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length, max = 0;
        int[][] dp = new int[row + 1][col + 1];
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
    public static void main(String args[]) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }
}
