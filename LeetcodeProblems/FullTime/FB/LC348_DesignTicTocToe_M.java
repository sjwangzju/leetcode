package FullTime.FB;

/**
 * row[] col[] diag antiDiag
 *
 * time: O(1)
 * space: O(N2)
 */
public class LC348_DesignTicTocToe_M {

    static class TicTacToe {

        int[][] rowCnt;
        int[][] colCnt;
        int[] diag;
        int[] antiDiag;
        int size;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            rowCnt = new int[n][2];
            colCnt = new int[n][2];
            diag = new int[2];
            antiDiag = new int[2];
            size = n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            rowCnt[row][player - 1]++;
            colCnt[col][player - 1]++;

            if (row + col == size - 1) {
                antiDiag[player - 1]++;
            }
            if (row == col) {
                diag[player - 1]++;
            }
            if (rowCnt[row][player - 1] == size || colCnt[col][player - 1] == size
                    || diag[player - 1] == size || antiDiag[player - 1] == size) {
                return player;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        System.out.println(ticTacToe.move(0,0,1));
        System.out.println(ticTacToe.move(0,2,2));
        System.out.println(ticTacToe.move(2,2,1));
        System.out.println(ticTacToe.move(1,1,2));
        System.out.println(ticTacToe.move(2,0,1));
        System.out.println(ticTacToe.move(1,0,2));
        System.out.println(ticTacToe.move(2,1,1));
    }
}
