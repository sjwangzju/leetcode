package FullTime.FB;

import java.util.*;

/**
 * BFS from buildings, sum up the distance
 *
 * time: O(M*N)
 * space: O(M*N)
 */
public class LC317_ShortestDistanceFromAllBuildings_H {

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int min = Integer.MAX_VALUE;
        int[][] reach = new int[row][col];
        int[][] sum = new int[row][col];
        List<Integer> buildings = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildings.add(i * col + j);
                }
            }
        }

        for (int l = 0; l < buildings.size(); l++) {
            int level = 1;
            List<Integer> visited = new LinkedList<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(buildings.get(l));

            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    int n = queue.poll();
                    int lasti = n / col;
                    int lastj = n % col;

                    for (int[] dir: dirs) {
                        int nexti = lasti + dir[0];
                        int nextj = lastj + dir[1];
                        int next = nexti * col + nextj;
                        if (nexti >= 0 && nexti < row && nextj >= 0 && nextj < col
                                && grid[nexti][nextj] == 0
                                && !visited.contains(next)) {
                            sum[nexti][nextj] += level;
                            reach[nexti][nextj]++;
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
                level++;
            }

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildings.size()) {
                    min = Math.min(min, sum[i][j]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1: min;
    }

    public static void main(String[] args) {
//        int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
//        int[][] grid = {{0,2,1},{1,0,2},{0,1,0}};
        int[][] grid = {{1,0,0},{0,2,0},{1,0,0}};
        System.out.println(new LC317_ShortestDistanceFromAllBuildings_H().shortestDistance(grid));
    }
}
