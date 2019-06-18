package FullTime.FB;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 *
 * time: O(MN)
 * space: O(1)
 */
public class LC286_WallsAndGates_M {

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int row = rooms.length;
        int col = rooms[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }

    public void bfs(int[][] rooms, int i, int j) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int row = rooms.length;
        int col = rooms[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curVal = rooms[cur[0]][cur[1]];

            for (int[] dir: dirs) {
                int nexti = cur[0] + dir[0];
                int nextj = cur[1] + dir[1];
                if (nexti >= 0 && nexti < row && nextj >= 0 && nextj < col) {
                    int nei = rooms[nexti][nextj];
                    if (nei != 0 && nei != -1) {
                        rooms[nexti][nextj] = curVal + 1;
                        q.offer(new int[]{nexti, nextj});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] rooms = {{INF,-1,0,INF},{INF,INF,INF,-1},{INF,-1,INF,-1},{0,-1,INF,INF}};
        new LC286_WallsAndGates_M().wallsAndGates(rooms);

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
}
