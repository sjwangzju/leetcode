package FullTime.OCI;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // Given a matrix of m x n elements (m rows, n columns),
    // return all elements of the matrix in spiral order.
    //
    // Input:
    // [
    //  [ 1, 2, 3 ],
    //  [ 4, 5, 6 ],
    //  [ 7, 8, 9 ]
    // ]
    // Output: [1,2,3,6,9,8,7,4,5]
    //
    // time: O(M*N), space: O(M*N)
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    List<Integer> res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return res;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        dfs(matrix, visited, 0, 0, 0);
        return res;
    }

    public void dfs(int[][] matrix, boolean[][] visited, int i, int j, int k) {
        if (i < 0 || i >= matrix.length
                || j < 0 || j >= matrix[0].length || visited[i][j]) return;

        res.add(matrix[i][j]);
        visited[i][j] = true;
        for (int p = 0; p < 4; p++) {
            int tmp = (k + p) % 4;
            int x = i + dirs[tmp][0];
            int y = j + dirs[tmp][1];
            dfs(matrix, visited, x, y, tmp);
        }
    }

}
