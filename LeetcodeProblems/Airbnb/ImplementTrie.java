package Airbnb;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

    public static class Node {
        boolean isEnd;
        Node[] children;
        Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }
    }

    public static class Trie {
        /**
         * Initialize your data structure here.
         */
        public Node root;
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node tmp = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (tmp.children[ch - 'a'] == null) {
                    tmp.children[ch - 'a'] = new Node();
                }
                tmp = tmp.children[ch - 'a'];
            }
            tmp.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node tmp = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (tmp.children[ch - 'a'] == null) return false;
                tmp = tmp.children[ch - 'a'];
            }
            return tmp.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node tmp = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (tmp.children[ch - 'a'] == null) return false;
                tmp = tmp.children[ch - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        String w1 = "apple";
        String w2 = "appze";

        obj.insert(w1);
        obj.insert(w2);

        System.out.println(obj.search(w1));
        System.out.println(obj.search(w2));
        System.out.println(obj.search("iuioe"));

        System.out.println(obj.startsWith("applee"));
    }

}
