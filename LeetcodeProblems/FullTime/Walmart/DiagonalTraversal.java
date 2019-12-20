package FullTime.Walmart;

public class DiagonalTraversal {

    // time: O(M*N), space: O(1)
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int m = matrix.length, n = matrix[0].length, r = 0, c = 0;
        int[] res = new int[m * n];

        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            // moving up
            if ((r + c) % 2 == 0) {
                if (c == n - 1) r++;
                else if (r == 0) c++;
                else {
                    r--;
                    c++;
                }
            }
            // moving down
            else {
                if (r == m - 1) c++;
                else if (c == 0) r++;
                else {
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
