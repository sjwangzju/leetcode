package BinarySearch;

/**
 * Created by sjwang on 07/24/2018.
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example:
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null) return false;
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            int cur = matrix[i][j];
            if(target == cur) return true;
            if(target < cur) j--;
            else i++;
        }
        return false;
    }
    public static void main(String args[]){
        int[][] M = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(new SearchA2DMatrixII().searchMatrix(M, 20));
    }
}
