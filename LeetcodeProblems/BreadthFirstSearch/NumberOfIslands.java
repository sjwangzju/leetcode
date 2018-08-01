package BreadthFirstSearch;

import java.util.*;

/**
 * Created by sjwang on 08/01/2018.
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 *
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    BFS(grid, i, j);
                }
            }
        }
        return count;
    }
    public void BFS(char[][] grid, int i, int j) {
        Queue<List<Integer>> Q = new LinkedList<>();
        Q.offer(new ArrayList<>(Arrays.asList(i, j)));
        int[][] adj = {{0,-1},{-1,0},{0,1},{1,0}};
        while(!Q.isEmpty()) {
            List<Integer> cur = Q.poll();
            int a = cur.get(0), b = cur.get(1);
            grid[a][b] = '0';
            for(int k = 0; k < adj.length; k++) {
                a = cur.get(0) + adj[k][0]; b = cur.get(1) + adj[k][1];
                if(a >= 0 && b >= 0 && a < grid.length && b < grid[0].length && grid[a][b] == '1') {
                    ArrayList<Integer> l = new ArrayList<>(Arrays.asList(a, b));
                    if(!Q.contains(l)) Q.offer(l);
                    grid[a][b] = '0';
                }
            }
        }
    }
    public static void main(String args[]){
        char[][] grid = {{'1','1','1','0','0'}, {'1','1','0','1','0'}, {'1','1','0','0','1'}, {'0','0','0','0','0'}};
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}