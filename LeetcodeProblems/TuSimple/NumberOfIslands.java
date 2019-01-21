package TuSimple;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NumberOfIslands {

    public int numIslands(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        List<List<int[]>> list = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    res++;
                    List<int[]> cur = new LinkedList<>();
                    flood(matrix, i, j, cur, list, 0, 0);
                }
            }
        }

        // get the num of distinct islands
        Set<List<Integer>> set = new HashSet<>();
        for (List<int[]> l: list) {
            List<Integer> tmp = new LinkedList<>();
            for (int[] n: l) {
                if (n[0] == 1 && n[1] == 0) tmp.add(1);
                if (n[0] == -1 && n[1] == 0) tmp.add(2);
                if (n[0] == 0 && n[1] == 1) tmp.add(3);
                if (n[0] == 0 && n[1] == -1) tmp.add(4);
            }
            set.add(tmp);
        }
        return set.size();
    }

    public void flood(char[][] matrix, int i, int j, List<int[]> cur, List<List<int[]>> list, int d1, int d2) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int ii;
        int jj;

        if (matrix[i][j] == '0') {
            list.add(cur);
            return;
        }

        matrix[i][j] = '0';
        cur.add(new int[]{d1, d2});

        for (int[] d: dir) {
            ii = i + d[0];
            jj = j + d[1];
            if (ii >= 0 && ii < row && jj >= 0 && jj < col) {
                flood(matrix, ii, jj, cur, list, d[0], d[1]);
            }
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','0','0','1'},{'0','0','0','1','1'}};
        System.out.println(new NumberOfIslands().numIslands(matrix));
    }
}
