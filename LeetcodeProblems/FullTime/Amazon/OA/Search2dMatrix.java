package FullTime.Amazon.OA;

public class Search2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;

        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (target == matrix[i][j]) return true;
            if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
