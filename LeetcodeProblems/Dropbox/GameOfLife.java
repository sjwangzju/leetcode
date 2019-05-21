package Dropbox;

public class GameOfLife {

    /****************************************************************************************/
    // time: O(M*N), space: O(M*N)
    public void gameOfLifeI(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        // save the num of live neighbours in tmp
        int[][] tmp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = board[i][j];
                int num = numOfLiveNeighs(board, i, j);
                int next;

                if (cur == 1) {
                    next = num < 2 || num > 3 ? 0: 1;
                } else {
                    next = num == 3 ? 1: 0;
                }
                tmp[i][j] = next;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = tmp[i][j];
            }
        }
    }

    /****************************************************************************************/
    // count the number of live neighbours
    public int numOfLiveNeighs(int[][] board, int i, int j) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{1,1},{-1,1},{-1,-1}};
        int res = 0;
        int row = board.length;
        int col = board[0].length;

        for (int[] dir: dirs) {
            int nexti = i + dir[0];
            int nextj = j + dir[1];
            if (nexti >= 0 && nexti < row && nextj >=0 && nextj < col) {
                int curState = board[nexti][nextj] & 1;
                res += curState;
            }
        }
        return res;
    }


    // FOLLOWUP 1
    /****************************************************************************************/
    // in-place
    // time: O(M*N), space: O(1)

    // [next, current]
    // 00 dead -> dead
    // 10 dead -> live
    // 01 live -> dead
    // 11 live -> live

    // get current state  =>  board[i][j] & 1
    // get next state     =>  board[i][j] >>= 1

    public int[][] gameOfLifeII(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = board[i][j];
                int num = numOfLiveNeighs(board, i, j);

                if (cur == 1 && (num == 2 || num == 3)) {
                    board[i][j] = 3;
                }
                if (cur == 0 && num == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }

        return board;
    }


    // FOLLOWUP 2
    /****************************************************************************************/
    // very large file, 1M lines, data is stored on the disk
    // API: int[] readLine(), void writeLine(int[] arr)

    // solution: read 3 lines each time, keep updating the board
    public void gameOfLifeIII() {
        int[] prev = null, cur = null, next = null, tmp = null;

        while ((tmp = readLine()) != null) {
            if (cur == null) {
                cur = tmp;
                continue;
            }
            next = tmp;

            // the first line
            if (prev == null) {
                int[][] curBoard = new int[2][];
                curBoard[0] = cur.clone();
                curBoard[1] = next.clone();
                int[][] nextBoard = gameOfLifeII(curBoard);
                writeLine(nextBoard[0]);
            } else {
                int[][] curBoard = new int[3][];
                curBoard[0] = prev.clone();
                curBoard[1] = cur.clone();
                curBoard[2] = next.clone();
                int[][] nextBoard = gameOfLifeII(curBoard);
                writeLine(nextBoard[1]);
            }

            // update lines
            prev = cur;
            cur = next;
            next = null;
        }

        // the last line
        int[][] curBoard = new int[2][];
        curBoard[0] = prev.clone();
        curBoard[1] = cur.clone();
        int[][] nextBoard = gameOfLifeII(curBoard);
        writeLine(nextBoard[1]);
    }


    // API
    public int[] readLine() {
        return null;
    }

    public void writeLine(int[] arr) {
        return;
    }



    /****************************************************************************************/
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new GameOfLife().gameOfLifeI(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.println(board[i][j]);
            }
        }
    }

}
