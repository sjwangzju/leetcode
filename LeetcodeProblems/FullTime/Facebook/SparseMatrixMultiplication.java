package FullTime.Facebook;

public class SparseMatrixMultiplication {

    // Given two sparse matrices A and B, return the result of AB
    //
    // Thoughts:
    // 1. int[][] res = new int[rowA][colB]
    // 2. for each A[i][j]:
    //      res[i][n] += A[i][j] * B[j][n]
    // 3. sparse matrix: A[i][j] == 0, return directly
    //
    // time: O(m1*n1*n2), space: O(1)
    public int[][] multiply(int[][] A, int[][] B) {
        int m1 = A.length, n1 = A[0].length;
        int m2 = B.length, n2 = B[0].length;

        // loop through each A[i][j]
        int[][] res = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                calculate(A, B, res, i, j);
            }
        }
        return res;
    }

    public void calculate(int[][] A, int[][] B, int[][] res, int i, int j) {
        // if sparse matrix, return directly
        if (A[i][j] == 0) return;
        for (int n = 0; n < res[0].length; n++) {
            res[i][n] += A[i][j] * B[j][n];
        }
    }
}
