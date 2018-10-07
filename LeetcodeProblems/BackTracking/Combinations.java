package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 10/07/2018.
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> L = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (k > n) {
            return L;
        }
        backtracking(L, cur, n, 1, k, 0);
        return L;
    }

    public void backtracking(List<List<Integer>> L, List<Integer> cur, int n, int pos, int k, int count) {
        if (pos > n + 1) {
            return;
        }
        if (count == k) {
            L.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (cur.size() > 0 && i > cur.get(cur.size() - 1) || cur.size() == 0) {
                cur.add(i);
                backtracking(L, cur, n, pos + 1, k, count + 1);
                cur.remove(cur.get(cur.size() - 1));
            }
        }
    }

    public static void main(String args[]) {
        int n = 4;
        int k = 3;
        List<List<Integer>> L = new Combinations().combine(n, k);
        for (int i = 0; i < L.size(); i++) {
            System.out.println(L.get(i));
        }
    }
}
