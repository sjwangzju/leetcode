package Amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringWithKDistinct {

    /**
     * sliding window
     *
     * time: O(N), space: O(N)
     *
     * @param chs
     * @param k
     * @return
     */
    public List<List<Character>> findSubstring(char[] chs, int k) {
        List<List<Character>> res = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();

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

    public static void main(String[] args) {
        char[] chs = {'a','a','a','a','b','c','d','e'};
        int k = 3;
        List<List<Character>> res = new SubstringWithKDistinct().findSubstring(chs, k);
        for (List<Character> list: res) {
            for (char ch: list) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
