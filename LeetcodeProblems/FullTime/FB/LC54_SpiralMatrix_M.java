package FullTime.FB;

import java.util.LinkedList;
import java.util.List;

/**
 * DFS - Keep changing directions
 *
 * time: O(M*N)
 * space: O(M*N)
 */
public class LC54_SpiralMatrix_M {

    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    boolean[][] visited;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return res;

        visited = new boolean[matrix.length][matrix[0].length];
        spiral(matrix, res, 0, 0, 0);
        return res;
    }

    public void spiral(int[][] matrix, List<Integer> res, int i, int j, int cur) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
            return;
        }
        res.add(matrix[i][j]);
        visited[i][j] = true;

        for (int k = 0; k < dirs.length; k++) {
            int[] dir = dirs[(cur + k)%4];
            spiral(matrix, res, i + dir[0], j + dir[1], cur + k);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = new LC54_SpiralMatrix_M().spiralOrder(matrix);
        for (int n: res) {
            System.out.print(n + " ");
        }
    }
}
