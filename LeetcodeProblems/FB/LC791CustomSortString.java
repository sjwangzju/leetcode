package FB;

import java.util.*;

public class LC791CustomSortString {

    /**
     * time: O(nlogn), space: O(n)
     *
     * @param S
     * @param T
     * @return
     */
    public String customSortString(String S, String T) {
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

    public static void main(String[] args) {
        String S = "cba";
        String T = "abcd";
        System.out.println(new LC791CustomSortString().customSortString(S, T));
    }
}
