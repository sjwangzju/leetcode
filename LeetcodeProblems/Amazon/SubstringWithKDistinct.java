package Amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringWithKDistinct {

    /**
     * sliding window of fixed size k
     *
     * time: O(N), space: O(N)
     *
     */
    public List<List<Character>> findSubstringI(String s, int k) {
        List<List<Character>> res = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();

        int l = 0;
        int r = 0;

        while (l <= r && r < chs.length) {
            if (map.containsKey(chs[r])) {
                int last = map.get(chs[r]);
                map.put(chs[r], r);
                if (r - last < k) {
                    l = last + 1;
                    r++;
                    continue;
                }
            }
            map.put(chs[r], r);
            if (r - l == k - 1) {
                List<Character> tmp = new LinkedList<>();
                for (int i = l; i <= r; i++) {
                    tmp.add(chs[i]);
                }
                res.add(tmp);
                l++;
            }
            r++;
        }
        return res;
    }


    /**
     * find all substring with k distinct characters
     *
     * time: O(n^2), space: O(n)
     *
     * @param s
     * @param num
     * @return
     */
    public int findSubstringII(String s, int num) {
        char[] chs = s.toCharArray();
        int cnt = 0;

        for (int i = 0; i < chs.length; i++) {
            int[] dict = new int[26];
            int tmp = 0;
            for (int j = i; j < chs.length; j++) {
                char ch = chs[j];
                if (dict[ch - 'a'] == 0) {
                    tmp++;
                }
                dict[ch - 'a']++;
                if (tmp == num) cnt++;
                if (tmp > num) break;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        String s = "abcdefg";
        int num = 2;
        System.out.print(new SubstringWithKDistinct().findSubstringII(s, num));
    }
}
