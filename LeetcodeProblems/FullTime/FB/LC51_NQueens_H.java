package FullTime.FB;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Permutation
 *
 * time: O(N!)
 * space: O(N)
 */
public class LC51_NQueens_H {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        int[] dp = new int[n];
        dfs(0, dp, res);
        return res;
    }

    public void dfs(int row, int[] dp, List<List<String>> res) {
        int n = dp.length;
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, dp)) {
                dp[row] = col;
                if (row < n - 1) {
                    dfs(row + 1, dp, res);
                } else {
                    List<String> list = new LinkedList<>();
                    char[] tmp = new char[n];

                    for (int i = 0; i < n; i++) {
                        Arrays.fill(tmp, '.');
                        tmp[dp[i]] = 'Q';
                        list.add(new String(tmp));
                    }
                    res.add(list);
                }
            }
        }
    }

    public boolean isValid(int row, int col, int[] dp) {
        for (int i = 0; i < row; i++) {
            int j = dp[i];
            // on the same column or +-45
            if (j == col || i + j == row + col || i - j == row - col) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new LC51_NQueens_H().solveNQueens(4);
        for (List<String> list: res) {
            for (String s: list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
