package Array;

/**
 * Created by sjwang on 12/05/2018.
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 *
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 * Example 1:
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: True
 * Explanation:
 * 1234
 * 5123
 * 9512
 *
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]",
 * and in each diagonal all elements are the same, so the answer is True.
 *
 * Example 2:
 * Input: matrix = [[1,2],[2,2]]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * Note:
 *
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 */

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix[0].length - 1; i ++){
            int row = 0, column = i, temp = matrix[row][column];
            while(row < matrix.length && column < matrix[0].length){
                if(matrix[row][column] != temp) return false;
                row ++; column ++;
            }
        }

        for(int i = 1; i < matrix.length; i ++){
            int row = i, column = 0, temp = matrix[row][column];
            while(row < matrix.length && column < matrix[0].length){
                if(matrix[row][column] != temp) return false;
                row ++; column ++;
            }
        }
        return true;
    }

    public static void main(String args[]){
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(new ToeplitzMatrix().isToeplitzMatrix(matrix));
    }
}
