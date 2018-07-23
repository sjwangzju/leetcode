package Array;

/**
 * Created by sjwang on 07/23/2018.
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix == null) return;
        int[] Si = new int[matrix.length], Sj = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    Si[i] = 1; Sj[j] = 1;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(Si[i] == 1 || Sj[j] == 1) matrix[i][j] = 0;
            }
        }
    }
    public static void main(String args[]){
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new SetMatrixZeroes().setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
