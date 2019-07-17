package FullTime.FB;

/**
 * DFS
 *
 * time: O(max(R,C)^2)
 * space: O(R*C)
 */
public class LC885_SpiralMatrixIII_M {

    int cnt = 0, dir = 0;
    int[][] res;
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    boolean[][] visited;

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        res = new int[R*C][2];
        visited = new boolean[R][C];
        spiral(0, 2, 0, r0, c0, R, C);
        return res;
    }

    public void spiral(int prevL, int curL, int tmp, int i, int j, int R, int C) {
        if (cnt == R * C) return;

        if (i >= 0 && i < R && j >= 0 && j < C && !visited[i][j]) {
            res[cnt][0] = i;
            res[cnt][1] = j;
            visited[i][j] = true;
            cnt++;
        }
        tmp++;
        // change direction
        if (tmp == curL) {
            dir++;
            int nextL = curL;
            nextL += curL == prevL? 1: 0;
            spiral(curL, nextL, 0, i, j, R, C);
        } else {
            // keep same direction
            int[] d = dirs[dir % 4];
            spiral(prevL, curL, tmp, i + d[0], j + d[1], R, C);
        }
    }

    public static void main(String[] args) {
        int[][] res = new LC885_SpiralMatrixIII_M().spiralMatrixIII(5,6,1,4);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
