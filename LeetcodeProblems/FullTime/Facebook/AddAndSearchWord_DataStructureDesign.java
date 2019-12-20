package FullTime.Facebook;

public class AddAndSearchWord_DataStructureDesign {

    //e.g.
    // addWord("bad")
    // addWord("dad")
    // addWord("mad")
    // search("pad") -> false
    // search("bad") -> true
    // search(".ad") -> true
    // search("b..") -> true
    //
    // Trie
    public class WordDictionary {

        public class Node {
            Node[] next;
            boolean isEnd;

            Node() {
                this.next = new Node[26];
                this.isEnd = false;
            }
        }

        Node head;

        /** Initialize your data structure here. */
        public WordDictionary() {
            this.head = new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node cur = head;
            for (char c: word.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Node();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isEnd = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return isValid(head, word, 0);
        }

        // recursion
        public boolean isValid(Node cur, String word, int i) {
            if (i == word.length()) return cur.isEnd;
            char c = word.charAt(i);
            if (c == '.') {
                for (Node n: cur.next) {
                    if (n == null) continue;
                    if (isValid(n, word, i + 1)) return true;
                }
                return false;
            } else {
                if (cur.next[c - 'a'] == null) return false;
                return isValid(cur.next[c - 'a'], word, i + 1);
            }
        }
    }

}
