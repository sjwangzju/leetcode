package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sjwang on 10/07/2018.
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<String> L = new ArrayList<>();
        backtracking(L, "", n, n, new HashSet<>(), k);
        return L.get(k - 1);
    }

    public void backtracking(List<String> L, String cur, int n, int len, Set<Integer> s, int k) {
        if (len == 0) {
            if (L.size() < k) {
                L.add(cur);
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (s.contains(i)) {
                continue;
            }
            cur += String.valueOf(i);
            s.add(i);
            backtracking(L, cur, n, len - 1, s, k);
            cur = cur.substring(0, cur.length() - 1);
            s.remove(i);
        }
    }

    public static void main(String args[]) {
        int n = 4;
        int k = 9;
        String s = new PermutationSequence().getPermutation(n, k);
        System.out.println(s);
    }
}
