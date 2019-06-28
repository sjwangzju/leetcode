package FullTime.FB;

/**
 * time: O(M*N)
 * space: O(1)
 */
public class LC200_NumberOfIslands_M {

    char[][] grid;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        this.grid = grid;
        int row = grid.length;
        int col = grid[0].length;
        int cnt = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    flood(i, j);
                }
            }
        }
        return cnt;
    }

    public void flood(int i, int j) {
        grid[i][j] = '0';
        for (int[] d: dirs) {
            int nexti = i + d[0];
            int nextj = j + d[1];
            if (nexti >= 0 && nexti < grid.length
                    && nextj >= 0 && nextj < grid[0].length && grid[nexti][nextj] == '1') {
                flood(nexti, nextj);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new LC200_NumberOfIslands_M().numIslands(grid));
    }
}
