package FullTime.Facebook;

public class LongestIncreasingPathInMatrix {

    // Given an integer matrix, find the length of the longest increasing path.
    //
    // Input: nums =
    // [
    //  [9,9,4],
    //  [6,6,8],
    //  [2,1,1]
    // ]
    // Output: 4
    // Explanation: The longest increasing path is [1, 2, 6, 9].
    //
    // dfs + memo
    // time: O(M*N), space: O(M*N)

    int[][] dp;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n, max = 1;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];

        int res = 0;
        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] < matrix[x][y]) {
                res = Math.max(res, dfs(matrix, x, y));
            }
        }
        dp[i][j] = 1 + res;

        return dp[i][j];
    }
}
