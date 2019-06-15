package FullTime.FB;

/**
 * res[i][n] = A[i][j] * B[j][n]
 *
 * sparse matrix -> skip when A[i][j] = 0
 *
 */
public class LC311_SparseMatrixMultiplication_M {

    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colA = A[0].length;
        int colB = B[0].length;
        int[][] res = new int[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colA; j++) {
                multiply(res, A, B, i, j);
            }
        }
        return res;
    }

    // res[i][n] = A[i][j] * B[j][n]
    public void multiply(int[][] res, int[][] A, int[][] B, int i, int j) {
        int len = B[0].length;
        if (A[i][j] == 0) return;
        for (int n = 0; n < len; n++) {
            res[i][n] += A[i][j] * B[j][n];
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1,0,0}, {-1,0,3}};
        int[][] B = {{7,0,0}, {0,0,0}, {0,0,1}};

        int[][] res = new LC311_SparseMatrixMultiplication_M().multiply(A, B);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
