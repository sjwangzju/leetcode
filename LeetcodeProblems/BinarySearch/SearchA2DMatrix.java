package BinarySearch;

/**
 * Created by sjwang on 10/08/2018.
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 * Example 2:
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int wid = matrix[0].length;
        int hei = matrix.length;
        int i = hei - 1, j = wid - 1;
        while (i >= 0 && j >= 0) {
            if (i > 0 && target <= matrix[i - 1][j]) {
                i--;
            }
            if (i == 0 || i > 0 && target > matrix[i - 1][j]) {
                return binarySearch(matrix, target, i);
            }
        }
        return false;
    }

    public boolean binarySearch(int[][] matrix, int target, int i) {
        int[] tmp = matrix[i];
        int lo = 0, hi = tmp.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (tmp[mid] == target) {
                return true;
            } else if (tmp[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    public static void main(String args[]){
        int[][] matrix = {{1}};
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, 2));
    }
}
