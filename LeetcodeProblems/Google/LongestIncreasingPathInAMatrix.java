package Google;

public class LongestIncreasingPathInAMatrix {
    /**
     * DFS + DP
     * int[i][j] cache -> save the last longest path -> reduce computation
     *
     * time: O(M*N), space: O(M*N)
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) return 0;
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] cache = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, findLongest(visited, matrix, i, j, dir, cache));
            }
        }
        return max;
    }

    public int findLongest(boolean[][] visited, int[][] matrix, int i, int j, int[][] dir, int[][] cache) {
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int max = 0;
        for (int[] d: dir) {
            int ii = i + d[0];
            int jj = j + d[1];
            if (ii >= 0 && ii < matrix.length
                    && jj >= 0 && jj < matrix[0].length && matrix[ii][jj] > matrix[i][j]) {
                int cur;
                if (cache[ii][jj] > 0) {
                    cur = cache[ii][jj];
                } else {
                    cur = findLongest(visited, matrix, ii, jj, dir, cache);
                    cache[ii][jj] = cur;
                }
                max = Math.max(max, cur);
            }
        }
        visited[i][j] = false;
        return max + 1;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(new LongestIncreasingPathInAMatrix().longestIncreasingPath(matrix));
    }
}
