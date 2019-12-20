package FullTime.OCI;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    // Solution1: DFS
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


    // Solution2: BFS
    // time: O(M*N), space: O(M*N)
    public int numIslandsII(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int res = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '0';
                    // BFS
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int[] dir: dirs) {
                            int x = cur[0] + dir[0];
                            int y = cur[1] + dir[1];
                            if (x >= 0 && x < grid.length
                                    && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
