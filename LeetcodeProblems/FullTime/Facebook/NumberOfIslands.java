package FullTime.Facebook;

public class NumberOfIslands {

    // Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    //
    // DFS
    //
    // time: O(M*N), space: worst O(M*N)
    int m, n;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    flood(grid, i, j);
                }
            }
        }
        return res;
    }

    public void flood(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            flood(grid, x, y);
        }
    }

}
