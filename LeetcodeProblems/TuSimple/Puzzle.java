package TuSimple;

import java.util.*;

public class Puzzle {
    /**
     * m * n puzzle
     *
     * @param board
     * @return
     */
    public int puzzle(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        Set<String> visited = new HashSet<>();

        String target = "";
        for (int i = 1; i < row * col; i++) {
            target += i;
        }
        target += 0;

        Queue<int[][]> q = new LinkedList<>();
        q.offer(board);
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[][] tmp = q.poll();

                if (arrayToString(tmp).equals(target)) {
                    return cnt;
                }
                List<int[][]> neigh = findNeigh(tmp);
                for (int[][] n: neigh) {
                    if (!visited.contains(arrayToString(n))) {
                        q.offer(n);
                        visited.add(arrayToString(n));
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public List<int[][]> findNeigh(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        List<int[][]> res = new LinkedList<>();
        int zeroX = 0;
        int zeroY = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0) {
                    zeroX = i;
                    zeroY = j;
                    break;
                }
            }
        }
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        for (int[] d: dir) {
            int nextX = zeroX + d[0];
            int nextY = zeroY + d[1];
            if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                res.add(getNeigh(board, zeroX, zeroY, nextX, nextY));
            }
        }
        return res;
    }

    public int[][] getNeigh(int[][] board, int x1, int y1, int x2, int y2) {
        int row = board.length;
        int col = board[0].length;

        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = board[i][j];
            }
        }

        int tmp = res[x1][y1];
        res[x1][y1] = res[x2][y2];
        res[x2][y2] = tmp;
        return res;
    }

    public String arrayToString(int[][] board) {
        String cur = "";
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cur += board[i][j];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int[][] board = {{1,2,3,4},{5,0,7,8},{9,6,10,11}};
        System.out.println(new Puzzle().puzzle(board));
    }
}
