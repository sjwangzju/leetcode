package FB;

import java.util.*;

public class LC791CustomSortString {

    /**
     * time: O(MlogM), space: O(M), M - len of T
     *
     * @param S
     * @param T
     * @return
     */
    public String customSortStringI(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < T.length(); i++) {
            if (!map.containsKey(T.charAt(i))) {
                map.put(T.charAt(i), S.length());
            }
            list.add(T.charAt(i));
        }
        Collections.sort(list, (a,b) -> map.get(a) - map.get(b));
        String res = "";
        for (Character ch: list) res += ch;
        return res;
    }

    /**
     * time: O(N + M), space: O(1)
     * @param S
     * @param T
     * @return
     */
    public String customSortStringII(String S, String T) {
        int[] freq = new int[26];

        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            freq[ch - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            while (freq[ch - 'a'] > 0) {
                res.append(ch);
                freq[ch - 'a']--;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                res.append((char)('a' + i));
                freq[i]--;
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String S = "cba";
        String T = "abcd";
        System.out.println(new LC791CustomSortString().customSortStringII(S, T));
    }
}
