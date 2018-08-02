package BreadthFirstSearch;

import java.util.*;

/**
 * Created by sjwang on 08/01/2018.
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Explanation:
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board != null && board.length != 0 && board[0].length != 0) {
            int rowN = board.length, colN = board[0].length;
            int[][] flag = new int[rowN][colN];
            for(int i = 0; i < rowN; i++) {
                for(int j = 0; j < colN; j++) {
                    if(board[i][j] == 'O') {
                        flag[i][j] = 1;
                    }
                }
            }
            for(int i = 1; i < rowN - 1; i++) {
                for(int j = 1; j < colN - 1; j++) {
                    if(flag[i][j] == 1) {
                        capture(flag, board, i, j);
                    }
                }
            }
        }
    }

    public void capture(int[][] flag, char[][] board, int i, int j) {
        int rowN = board.length, colN = board[0].length;
        int[][] adj = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<List<Integer>> Q = new LinkedList<>();
        Q.offer(new ArrayList<>(Arrays.asList(i, j)));
        boolean valid = true;
        List<List<Integer>> temp = new ArrayList<>();
        while(!Q.isEmpty()) {
            List<Integer> l = Q.poll();
            int a = l.get(0), b = l.get(1);
            flag[a][b] = 0;
            temp.add(new ArrayList<>(Arrays.asList(a, b)));
            for(int n = 0; n < adj.length; n++) {
                a = l.get(0) + adj[n][0];
                b = l.get(1) + adj[n][1];
                if(a >= 0 && a < rowN && b >= 0 && b < colN && flag[a][b] == 1) {
                    if(a == 0 || a == rowN - 1 || b == 0 || b == colN - 1) {
                        valid = false;
                    }
                    Q.offer(new ArrayList<>(Arrays.asList(a, b)));
                    temp.add(new ArrayList<>(Arrays.asList(a, b)));
                    flag[a][b] = 0;
                }
            }
        }
        if(valid) {
            for(List<Integer> l : temp) {
                board[l.get(0)][l.get(1)] = 'X';
            }
        }
    }

    public static void main(String args[]){
        char[][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','O','O','X'}, {'X','O','X','X'}};
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        new SurroundedRegions().solve(board);
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
