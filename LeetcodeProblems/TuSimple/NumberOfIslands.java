package TuSimple;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {

    public int numIslands(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    StringBuilder sb = new StringBuilder();
                    flood(matrix, i, j, sb, 0, 0);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public void flood(char[][] matrix, int i, int j, StringBuilder sb, int d1, int d2) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
        int ii;
        int jj;

        matrix[i][j] = '0';
        sb.append(d1 + "" + d2);

        for (int[] d: dir) {
            ii = i + d[0];
            jj = j + d[1];
            if (ii >= 0 && ii < row && jj >= 0 && jj < col && matrix[ii][jj] == '1') {
                flood(matrix, ii, jj, sb, d1 + d[0], d2 + d[1]);
            }
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','1','0','1','1'},{'1','0','0','0','0'},{'0','0','0','0','1'},{'1','1','0','1','1'}};
        System.out.println(new NumberOfIslands().numIslands(matrix));
    }
}
