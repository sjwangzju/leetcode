package DynamicProgramming;

/**
 * Created by sjwang on 08/07/2018.
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid == null) return 0;
        for(int i = grid.length - 1; i >= 0; i--) {
            for(int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1) {
                    if(j < grid[0].length - 1) grid[i][j] += grid[i][j + 1];
                }
                else if(j == grid[0].length - 1) {
                    if(i < grid.length - 1) grid[i][j] += grid[i + 1][j];
                }
                else grid[i][j] += Math.min(grid[i][j + 1], grid[i + 1][j]);
            }
        }
        return grid[0][0];
    }
    public static void main(String args[]){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }
}
