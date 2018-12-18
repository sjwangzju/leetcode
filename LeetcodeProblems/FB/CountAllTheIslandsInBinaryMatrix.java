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
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void BFS(char[][] matrix, int i, int j) {
        int col = matrix[0].length;
        int row = matrix.length;
        matrix[i][j] = '0';
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(i * col + j);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int m = cur / col;
            int n = cur % col;

            // up
            if (m > 0 && matrix[m - 1][n] == '1') {
                q.offer((m - 1) * col + n);
                matrix[m - 1][n] = '0';
            }
            // down
            if (m < row - 1 && matrix[m + 1][n] == '1') {
                q.offer((m + 1) * col + n);
                matrix[m + 1][n] = '0';
            }
            // left
            if (n > 0 && matrix[m][n - 1] == '1') {
                q.offer(m * col + (n - 1));
                matrix[m][n - 1] = '0';
            }
            // right
            if (n < col - 1 && matrix[m][n + 1] == '1') {
                q.offer(m * col + (n + 1));
                matrix[m][n + 1] = '0';
            }

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
