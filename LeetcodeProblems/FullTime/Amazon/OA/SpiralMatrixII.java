package FullTime.Amazon.OA;

import java.util.Arrays;

public class SpiralMatrixII {

    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int[][] res;

    public int[][] generateMatrix(int n) {
        res = new int[n][n];
        for (int[] row: res) {
            Arrays.fill(row, -1);
        }
        fill(n, 0, 0, 1, 0);
        return res;
    }

    public void fill(int n, int i, int j, int num, int index) {
        if (i < 0 || i >= n || j < 0 || j >= n || res[i][j] != -1) {
            return;
        }
        res[i][j] = num;
        for (int k = 0; k < 4; k++) {
            int next = (index + k) % 4;
            int[] dir = dirs[next];
            fill(n, i + dir[0], j + dir[1], num + 1, next);
        }
    }
}
