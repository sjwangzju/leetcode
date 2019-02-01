package Google;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindLongestSequence {

    public static class Node {
        Node[] children;

        public Node() {
            this.children = new Node[26];
        }
    }

    public static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new Node();
                }
                cur = cur.children[ch - 'a'];
            }
        }

        public boolean hasPerfix(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (cur.children[ch - 'a'] == null) {
                    return false;
                }
                cur = cur.children[ch - 'a'];
            }
            return true;
        }
    }


    /**
     * find the longest sequence in a trie
     *
     * time: O(nlogn), space: O(n)
     *
     * @param input
     * @return
     */
    public int findLongest(List<String> input) {
        Collections.sort(input, (a, b) -> (a.length() - b.length()));
        int max = 0;

        Trie trie = new Trie();
        for (String s: input) {
            if (trie.hasPerfix(s.substring(0, s.length() - 1))) {
                trie.insert(s);
                max = Math.max(s.length(), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c","ab","abd","abcd","abc");
        System.out.println(new FindLongestSequence().findLongest(list));
    }
}
