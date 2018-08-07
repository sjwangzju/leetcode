package DynamicProgramming;

/**
 * Created by sjwang on 08/07/2018.
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 || j == n - 1) path[i][j] = 1;
                else path[i][j] = path[i + 1][j] + path[i][j + 1];
            }
        }
        return path[0][0];
    }
    public static void main(String args[]){
        System.out.println(new UniquePaths().uniquePaths(7,3));
    }
}
