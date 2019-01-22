package FB;

import java.util.HashMap;
import java.util.Map;

public class LC211AddAndSearchWord {

    public static class WordDictionary {
        Node root;
        public class Node {
            Map<Character, Node> children;
            boolean isEnd;
            Node() {
                this.children = new HashMap<>();
                this.isEnd = false;
            }
        }

        public WordDictionary() {
            this.root = new Node();
        }

        public void addWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!cur.children.containsKey(ch)) {
                    cur.children.put(ch, new Node());
                }
                cur = cur.children.get(ch);
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            return dfs(word, root);
        }

        public boolean dfs(String word, Node cur) {
            if (word.length() == 0) return cur.isEnd;
            char ch = word.charAt(0);
            if (ch == '.') {
                for (char c: cur.children.keySet()) {
                    if (dfs(word.substring(1), cur.children.get(c))) {
                        return true;
                    }
                }
                return false;
            }
            if (!cur.children.containsKey(ch)) return false;
            return dfs(word.substring(1), cur.children.get(ch));
        }
    }

    public static void main(String[] args) {
        WordDictionary wd = new LC211AddAndSearchWord.WordDictionary();
        wd.addWord("a");
        wd.addWord("ab");
        System.out.println(wd.search("a"));
        System.out.println(wd.search("a."));
        System.out.println(wd.search(".b"));
        System.out.println(wd.search(".."));
    }
}
