package Dropbox;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {


    public static class Trie {

        public class Node {
            public Map<Character, Node> children;
            boolean isEnd;

            public Node() {
                this.children = new HashMap<>();
                this.isEnd = false;
            }
        }

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

        public boolean hasPrefix(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!cur.children.containsKey(ch)) {
                    return false;
                }
                cur = cur.children.get(ch);
            }
            return true;
        }
    }

    public String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static Set<String> dict = new HashSet<>();
    public static Trie trie = new Trie();

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(res, digits, "", 0);
        return res;
    }

    public void dfs(List<String> res, String digits, String s, int curIndex) {
        if (curIndex == digits.length()) {
            List<String> words = wordBreak(s, new LinkedList<>(dict));
            for (String word: words) {
                res.add(word);
            }
            return;
        }
        String str = map[digits.charAt(curIndex) - '0'];
        for (int i = 0; i < str.length(); i++) {
            if (s.length() == 3 && !trie.hasPrefix(s)) break;
            dfs(res, digits, s + str.charAt(i), curIndex + 1);
        }
    }

    public boolean isWord(String word) {
        return dict.contains(word);
    }


    // dfs + memorization (hashmap)
    public List<String> wordBreak(String s, List<String> dict) {
        Map<Integer, List<String>> map = new HashMap<>();
        return helper(s, dict, map, 0);
    }

    public List<String> helper(String s, List<String> dict, Map<Integer, List<String>> map, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String cur = s.substring(start, end);
            if (dict.contains(cur)) {
                List<String> list = helper(s, dict, map, end);
                for (String str: list) {
                    res.add(cur + (str.length() == 0 ? "": " " + str));
                }
            }
        }
        map.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        String digits = "3767269";
        dict.add("drop");
        dict.add("box");
        dict.add("dropbox");

        for (String word: dict) {
            trie.insert(word);
        }
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations(digits));

//        String s = "dropbox";
//        System.out.println(new LetterCombinationsOfPhoneNumber().wordBreak(s, new LinkedList<>(dict)));
    }
}
