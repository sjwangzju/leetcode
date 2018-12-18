package FB;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountAllTheIslandsInBinaryMatrix {
    public int findIslands(char[][] matrix) {
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    BFS(matrix, i, j);
//                    DFS(matrix, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void DFS(char[][] matrix, int i, int j) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] == '1') {
            matrix[i][j] = '0';
            DFS(matrix, i - 1, j);
            DFS(matrix, i + 1, j);
            DFS(matrix, i, j - 1);
            DFS(matrix, i, j + 1);
        }
        return;
    }

    public void BFS(char[][] matrix, int i, int j) {
        int col = matrix[0].length;
        matrix[i][j] = '0';
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(i * col + j);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int m = cur / col;
            int n = cur % col;
            // up
            BFSHelper(matrix, q, m - 1, n);
            // down
            BFSHelper(matrix, q, m + 1, n);
            // left
            BFSHelper(matrix, q, m, n - 1);
            // right
            BFSHelper(matrix, q, m, n + 1);
        }
    }

    public void BFSHelper(char[][] matrix, Queue<Integer> q, int i, int j) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] == '1') {
            q.offer(i * matrix[0].length + j);
            matrix[i][j] = '0';
        }
    }

    public static void main(String[] args) {
        char[][] matrix1 = {{'1', '1', '0', '0', '0'}, {'0', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1'}, {'0', '0', '0', '0', '0'}, {'1', '0', '1', '0', '1'}};
//        int[][] matrix2 = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
//        int[][] matrix3 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
//        int n = new CountAllTheIslandsInBinaryMatrix().findIslands(matrix1);
        int n = new CountAllTheIslandsInBinaryMatrix().findIslands(matrix1);
        System.out.println(n);
    }
}
