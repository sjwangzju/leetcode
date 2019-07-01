package FullTime.FB;

/**
 * DFS - backtracking
 *
 * time: O(M*N)
 * space: O(M*N)
 */
public class LC79_WordSearch_M {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char ch = board[i][j];
                if (ch == word.charAt(0)) {
                    if (dfs(board, i, j, visited, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int cur) {
        if (cur == word.length()) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;

        if (i >= row || i < 0 || j >= col || j < 0 || visited[i][j] || word.charAt(cur) != board[i][j]) {
            return false;
        }

        visited[i][j] = true;
        for (int[] d: dirs) {
            int nexti = i + d[0];
            int nextj = j + d[1];
            if (dfs(board, nexti, nextj, visited, word, cur + 1)) {
                return true;
            }
        }
        // *important*
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a'},{'a'}};
        String word = "aaa";
        System.out.println(new LC79_WordSearch_M().exist(board, word));
    }
}
