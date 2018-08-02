package DepthFirstSearch;

/**
 * Created by sjwang on 08/02/2018.
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 *
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null) return 0;
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, countArea(i, j, grid));
                }
            }
        }
        return max;
    }
    public int countArea(int i, int j, int[][] grid) {
        int[][] adj = {{-1,0},{1,0},{0,-1},{0,1}};
        grid[i][j] = 0;
        int sum = 1;
        for(int n = 0; n < adj.length; n++) {
            int a = i + adj[n][0], b = j + adj[n][1];
            if(a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && grid[a][b] == 1) {
                sum += countArea(a, b, grid);
            }
            else continue;
        }
        return sum;
    }

    public static void main(String args[]){
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }
}
