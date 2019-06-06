package FullTime.FB;

/**
 * Trie + DFS
 *
 * addWord time: O(N), N - len of word
 *
 * search time: worst O(M), M - total characters in the trie
 *
 */
public class LC211_AddAndSearchWord_DataStructureDesign_M {

    static class WordDictionary {

        public static class Node {
            boolean isEnd;
            Node[] children;
            Node() {
                this.isEnd = false;
                this.children = new Node[26];
            }
        }

        public Node root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node cur = root;
            for (char ch: word.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new Node();
                }
                cur = cur.children[ch - 'a'];
            }
            cur.isEnd = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return dfs(root, word);
        }

        public boolean dfs(Node cur, String word) {
            if (word.length() == 0) return cur.isEnd;

            char ch = word.charAt(0);
            if (ch == '.') {
                for (int i = 0; i < 26; i++) {
                    if (cur.children[i] != null) {
                        if (dfs(cur.children[i], word.substring(1))) {
                            return true;
                        }
                    }
                }
                return false;
            }
            if (cur.children[ch - 'a'] == null) return false;
            return dfs(cur.children[ch - 'a'], word.substring(1));
        }
    }
}
