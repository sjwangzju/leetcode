package FullTime.FB;

/**
 * count freq and write -> int[26]
 *
 * time: O(M + N), M is len of S, N is len of T
 * space: O(1)
 */
public class LC791_CustomSortString_M {

    public String customSortString(String S, String T) {
        int[] freq = new int[26];
        for (char c: T.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        // append chars appear in S
        for (char c: S.toCharArray()) {
            while (freq[c - 'a'] > 0) {
                res.append(c);
                freq[c - 'a']--;
            }
        }

        // append chars not appear in S
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                res.append((char) (i + 'a'));
                freq[i]--;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String S = "cba";
        String T = "abcda";
        System.out.println(new LC791_CustomSortString_M().customSortString(S, T));
    }
}
