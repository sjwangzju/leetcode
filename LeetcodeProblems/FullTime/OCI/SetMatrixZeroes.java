package FullTime.OCI;

public class SetMatrixZeroes {

    // Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
    //
    // Example 1:
    // Input:
    // [
    //  [1,1,1],
    //  [1,0,1],
    //  [1,1,1]
    // ]
    // Output:
    // [
    //  [1,0,1],
    //  [0,0,0],
    //  [1,0,1]
    // ]
    //
    // time: O(M*N), space: O(1)
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        boolean setRow = false, setCol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) setRow = true;
                    if (j == 0) setCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (setRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (setCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
