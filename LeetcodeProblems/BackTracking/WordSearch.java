package BackTracking;

/**
 * Created by sjwang on 09/18/2018.
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

    public static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        if (word == null || word.length() == 0) return false;
        char ch = word.charAt(0);
        boolean res = false, temp;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ch) {
                    temp = findPath(i, j, 0, word, board);
                    res = res || temp;
                }
            }
        }
        return res;
    }

    public boolean findPath(int m, int n, int index, String word, char[][] board) {
        if (index == word.length()) {
            return true;
        }
        if (m >= board.length || m < 0 || n >= board[0].length || n < 0 || word.charAt(index) != board[m][n] || visited[m][n]) {
            return false;
        }
        visited[m][n] = true;
        boolean res = findPath(m, n - 1, index + 1, word, board) || findPath(m, n + 1, index + 1, word, board) ||
                findPath(m - 1, n, index + 1, word, board) || findPath(m + 1, n, index + 1, word, board);
        if (!res) {
            visited[m][n] = false;
        }
        return res;
    }

    public static void main(String args[]) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new WordSearch().exist(board, "SEE"));
    }

}
