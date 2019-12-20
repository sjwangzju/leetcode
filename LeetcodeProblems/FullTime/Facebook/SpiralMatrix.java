package FullTime.Facebook;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * Spiral Matrix I
     *
     * Given a matrix of m x n elements (m rows, n columns),
     * return all elements of the matrix in spiral order.
     *
     * Input:
     * [
     *  [1, 2, 3, 4],
     *  [5, 6, 7, 8],
     *  [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * time: O(M*N), space: O(M*N)
     *
     */
    int m, n;
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    List<Integer> res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        dfs(matrix, visited, 0, 0, 0);
        return res;
    }

    public void dfs(int[][] matrix, boolean[][] visited, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;

        res.add(matrix[i][j]);
        visited[i][j] = true;
        for (int l = 0; l < 4; l++) {
            int tmp = (l + k) % 4;
            dfs(matrix, visited, i + dirs[tmp][0], j + dirs[tmp][1], tmp);
        }
    }


    /**
     * Spiral Matrix II
     *
     * time: O(N^2), space: O(N^2)
     */
    int[][] dirs2 = {{0,1},{1,0},{0,-1},{-1,0}};
    int num = 1;

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        fill(visited, res, n, 0, 0, 0);
        return res;
    }

    public void fill(boolean[][] visited, int[][] res, int n, int i, int j, int k) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j]) return;

        res[i][j] = num++;
        visited[i][j] = true;
        for (int l = 0; l < 4; l++) {
            int tmp = (k + l) % 4;
            fill(visited, res, n, i + dirs[tmp][0], j + dirs[tmp][1], tmp);
        }
    }

    /**
     * Spiral Matrix III
     *
     * Thoughts:
     * 1. len starts from 2, repeat 2 times, then increase 1
     *
     * time: O(max(R,C)^2), space: O(R*C)
     */
    int[][] dirs3 = {{0,1},{1,0},{0,-1},{-1,0}};
    int cnt = 0, len = 0, d = 0;

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        boolean[][] visited = new boolean[R][C];
        dfs(res, visited, 0, 2, r0, c0, R, C);
        return res;
    }

    public void dfs(int[][] res, boolean[][] visited, int prevL, int curL, int i, int j, int R, int C) {
        if (cnt == R*C) return;

        // add the positions inside the grid
        if (i >= 0 && i < R && j >= 0 && j < C && !visited[i][j]) {
            res[cnt++] = new int[]{i, j};
            visited[i][j] = true;
        }
        len++;
        // change direction
        if (len == curL) {
            d = (d + 1) % 4;
            len = 0;
            int nextL = curL == prevL? curL + 1: curL;
            dfs(res, visited, curL, nextL, i, j, R, C);
        }
        // keep same direction
        else {
            dfs(res, visited, prevL, curL, i + dirs[d][0], j + dirs[d][1], R, C);
        }
    }
}
