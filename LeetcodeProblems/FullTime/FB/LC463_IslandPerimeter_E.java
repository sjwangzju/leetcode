package FullTime.FB;

import java.util.LinkedList;
import java.util.List;

/**
 * time: O(MN)
 * space: O(MN)
 */
public class LC463_IslandPerimeter_E {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(i, j, grid);
                }
            }
        }
        return perimeter;
    }

    public int dfs(int i, int j, int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] adj = {{0,1},{0,-1},{1,0},{-1,0}};
        if (i < 0 || i >= row || j < 0 || j >= col) return 1;

        if (grid[i][j] == 0) return 1;
        if (grid[i][j] == -1) return 0;

        int res = 0;
        grid[i][j] = -1;

        for (int[] d: adj) {
            res += dfs(i + d[0], j + d[1], grid);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(new LC463_IslandPerimeter_E().islandPerimeter(grid));
    }
}
