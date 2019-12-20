package FullTime.LinkedIn;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

    // Write a function that takes an integer n and return all possible combinations of its factors.
    //
    // Input: 12
    // Output:
    // [
    //  [2, 6],
    //  [2, 2, 3],
    //  [3, 4]
    // ]
    //
    // Thoughts:
    // 1. backtracking
    // 2. factors are between [2,sqrt(n)]
    //
    // time: O(logN^logN), space: O(logN)
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {
        dfs(new ArrayList<>(), n, 2, (int)Math.sqrt(n));
        return res;
    }

    // higher bound is sqrt(n)
    // pruning to improve time efficiency
    public void dfs(List<Integer> cur, int n, int prev, int hi) {
        if (n <= 1) {
            if (n == 1 && cur.size() > 1) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int next = prev; next <= n; next++) {
            // pruning -> if next is larger than higher bound, directly jump to n
            if (next > hi) next = n;
            if (n % next == 0) {
                cur.add(next);
                dfs(cur, n/next, next, hi);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
