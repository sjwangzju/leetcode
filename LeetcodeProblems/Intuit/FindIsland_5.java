package Intuit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindIsland_5 {

    /*************************************************************************************/

    // find all rectangular islands

    // time: O(M * N)
    // space: O(M * N)
    public List<int[]> findIsland(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> list = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

//        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int[] res = {-1,-1,-1,-1};
                    res[0] = i;
                    res[1] = j;

//                    StringBuilder sb = new StringBuilder();
                    int[] tmp = new int[]{i,j};
                    dfs(matrix, visited, tmp, i, j);
//                    getShape(matrix, visited, tmp, i, j,0, 0, sb);
                    res[2] = tmp[0];
                    res[3] = tmp[1];
                    list.add(res);

//                    shapes.add(sb.toString());
                }
            }
        }

//        for(String s: shapes) {
//            System.out.println(s);
//        }
        return list;
    }

    public void dfs(int[][] matrix, boolean[][] visited, int[] tmp, int i, int j) {
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int row = matrix.length;
        int col = matrix[0].length;
        visited[i][j] = true;
        matrix[i][j] = 1;

        if (i > tmp[0] || j > tmp[1]) {
            tmp[0] = i;
            tmp[1] = j;
        }

        for (int[] d: dir) {
            int nexti = i + d[0];
            int nextj = j + d[1];
            if (nexti >=0 && nexti < row && nextj >= 0 && nextj < col
                    && matrix[nexti][nextj] == 0 && !visited[nexti][nextj]) {
                dfs(matrix, visited, tmp, nexti, nextj);
            }
        }
    }

    /*************************************************************************************/

    // get shapes of different islands

    public void getShape(int[][] matrix, boolean[][] visited, int[] tmp, int i, int j, int x, int y, StringBuilder sb) {
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int row = matrix.length;
        int col = matrix[0].length;
        visited[i][j] = true;
        matrix[i][j] = 1;

        sb.append(x).append(y);

        if (i > tmp[0] || j > tmp[1]) {
            tmp[0] = i;
            tmp[1] = j;
        }

        for (int[] d: dir) {
            int nexti = i + d[0];
            int nextj = j + d[1];
            if (nexti >=0 && nexti < row && nextj >= 0 && nextj < col
                    && matrix[nexti][nextj] == 0 && !visited[nexti][nextj]) {
                getShape(matrix, visited, tmp, nexti, nextj, x + d[0], y + d[1], sb);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,1,0,0},{0,0,1,0,1,1},{0,0,1,0,1,0},{1,1,1,0,1,0},{1,0,0,1,1,1}};
        List<int[]> list = new FindIsland_5().findIsland(matrix);
        for (int[] r: list) {
            System.out.println(r[0] + ", " + r[1] + ", " + r[2] + ", " + r[3]);
        }
    }
}
