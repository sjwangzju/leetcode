package Google;

import java.util.HashMap;
import java.util.Map;

public class LC562LongestLineOfConsecutiveOneInMatrix {

    /**
     * dp
     *
     * time: O(M*N), space: O(M*N)
     *
     * @param M
     * @return
     */
    public int longestLine(int[][] M) {
        Map<Integer, int[]> map = new HashMap<>();
        int[] max = new int[1];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    search(M, i, j, map, max);
                }
            }
        }
        return max[0];
    }

    public void search(int[][] M, int i, int j, Map<Integer, int[]> map, int[] max) {
        int row = M.length;
        int col = M[0].length;
        int tmp = i * col + j;

        map.put(tmp, new int[]{1,1,1,1});
        max[0] = Math.max(max[0], 1);
        int[] cur = map.get(tmp);

        int[][] dir = {{0,-1},{-1,0},{-1,-1},{-1,1}};

        for (int k = 0; k < dir.length; k++) {
            int nexti = i + dir[k][0];
            int nextj = j + dir[k][1];
            int nexttmp = nexti * col + nextj;

            if (nexti >= 0 && nexti < row && nextj >= 0 && nextj < col && M[nexti][nextj] == 1) {
                cur[k] = map.get(nexttmp)[k] + 1;
                max[0] = Math.max(max[0], cur[k]);
            }
        }
        map.put(tmp, cur);
    }


    public static void main(String[] args) {
        int[][] M = {{1,1,1,1},{0,1,1,0},{0,0,0,1}};
        System.out.println(new LC562LongestLineOfConsecutiveOneInMatrix().longestLine(M));
    }
}
