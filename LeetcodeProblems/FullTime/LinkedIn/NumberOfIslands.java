package FullTime.LinkedIn;

public class NumberOfIslands {

    // Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    //
    // Example 1:
    // Input:
    // 11110
    // 11010
    // 11000
    // 00000
    //
    // Output: 1
    //
    // DFS
    // time: O(M*N), space: O(M*N)
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    flood(grid, i, j);
                }
            }
        }
        return res;
    }

    public void flood(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d: dirs) {
            flood(grid, i + d[0], j + d[1]);
        }
    }
}
