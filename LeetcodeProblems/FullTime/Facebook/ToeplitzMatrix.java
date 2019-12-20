package FullTime.Facebook;

import java.util.HashMap;
import java.util.Map;

public class ToeplitzMatrix {

    // A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
    //
    // Input:
    // matrix = [
    //  [1,2,3,4],
    //  [5,1,2,3],
    //  [9,5,1,2]
    // ]
    // Output: True
    //
    // Solution 1:
    // 1. HashMap
    //      key: i - j
    //      val: matrix[i][j]
    //
    // time: O(M*N), space: O(M+N)
    public boolean isToeplitzMatrixI(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int tmp = i - j;
                if (!map.containsKey(tmp)) {
                    map.put(tmp, matrix[i][j]);
                } else if (map.get(tmp) != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Solution 2:
    // 1. Compare with top left element
    //
    // time: O(M*N), space: O(1)
    public boolean isToeplitzMatrixII(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j > 0 && matrix[i][j] != matrix[i - 1][j - 1]){
                    return false;
                }
            }
        }
        return true;
    }

    // Follow up:
    //
    //  1. What if the matrix is stored on disk, and the memory is limited such that you can only
    //      load at most one row of the matrix into the memory at once?

    //  2. What if the matrix is so large that you can only load up a partial row into the memory at once?
    //
    //  As for the follow ups, we only need to add counters to track which row and column an element is. Then map the values into a file.
    //  Eventually, we can check if the values in the same file are equal.
}
