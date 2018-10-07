package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 10/07/2018.
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> L = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return L;
        }
        backtracking(L, cur, s, 0);
        return L;
    }

    public void backtracking(List<List<String>> L, List<String> cur, String s, int l) {
        if (l >= s.length()) {
            L.add(new ArrayList<>(cur));
            return;
        }
        for (int i = l; i < s.length(); i++) {
            if (isPalindrome(s.substring(l, i + 1))) {
                cur.add(s.substring(l, i + 1));
                backtracking(L, cur, s, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String s = "abbab";
        List<List<String>> L = new PalindromePartitioning().partition(s);
        for (int i = 0; i < L.size(); i++) {
            System.out.println(L.get(i));
        }
    }

}
