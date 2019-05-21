package Indeed;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AutoComplete {

    public static class Node {
        Map<Character, Node> children;
        boolean isEnd;

        public Node() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }


    public static class Trie {
        public Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
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

        public boolean hasPrefix(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (!cur.children.containsKey(ch)) {
                    return false;
                }
                cur = cur.children.get(ch);
            }
            return true;
        }
    }


    public static class Auto {
        Trie trie;
        List<String> dict;

        public Auto (List<String> dict) {
            this.dict = dict;
            this.trie = new Trie();

            for (String word: dict) {
                trie.insert(word);
            }
        }

        public List<String> find(String prefix) {
            List<String> res = new LinkedList<>();
            if (!trie.hasPrefix(prefix)) return res;

            Node cur = trie.root;
            for (int i = 0; i < prefix.length(); i++) {
                cur = cur.children.get(prefix.charAt(i));
            }
            dfs(res, cur, "", prefix);
            return res;
        }

        public void dfs(List<String> res, Node cur, String s, String prefix) {
            if (cur.isEnd) {
                res.add(prefix + s);
            }
            Map<Character, Node> children = cur.children;
            for (Character c: children.keySet()) {
                dfs(res, children.get(c), s + c, prefix);
            }
        }
    }

    public static void main(String[] args) {
        List<String> dict = new LinkedList<>();
        dict.add("amazing");
        dict.add("amount");
        dict.add("apple");
        dict.add("among");
        dict.add("back");
        Auto auto = new Auto(dict);
        System.out.println(auto.find("a"));
    }
}
