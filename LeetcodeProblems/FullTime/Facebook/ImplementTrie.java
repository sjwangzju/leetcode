package FullTime.Facebook;

public class ImplementTrie {

    class Trie {

        class Node {
            Node[] children;
            boolean isEnd;

            Node() {
                this.children = new Node[26];
                this.isEnd = false;
            }
        }

        Node head;

        /** Initialize your data structure here. */
        public Trie() {
            this.head = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = head;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node cur = head;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
            return cur.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node cur = head;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }
}
