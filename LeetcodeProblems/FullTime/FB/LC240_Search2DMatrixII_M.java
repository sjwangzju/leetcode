package FullTime.FB;

/**
 * Search from top right
 *
 * time: O(M+N)
 * space: O(1)
 */
public class LC240_Search2DMatrixII_M {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (target == matrix[i][j]) return true;
            if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 25;
        System.out.println(new LC240_Search2DMatrixII_M().searchMatrix(matrix, target));
    }
}
