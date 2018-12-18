package FB;

import java.util.*;

public class DictionaryLookupWithWildcard {

    /**
     * runtime: O(N)
     */
    public static class Trie {

        private class Node{
            private Map<Character, Node> children;
            boolean end;
            public Node(){
                children = new HashMap<>();
                end = false;
            }
        }

        private Node root;

        public Trie(){
            root = new Node();
        }

        public void setup(List<String> input) {
            for (String s: input) {
                Node current = root;
                for (int i = 0; i < s.length(); i++){
                    char c = s.charAt(i);
                    Node node = current.children.get(c);
                    if(node == null){
                        node = new Node();
                        current.children.put(c, node);
                    }
                    current = node;
                }
                current.end = true;
            }
        }

        public boolean isMember(String word, Node root){

            if (word.length() == 0) {
                return root.end;
            }

            char ch = word.charAt(0);
            if (ch != '.') {
                if (root.children.get(ch) != null) {
                    return isMember(word.substring(1), root.children.get(ch));
                }
                return false;
            }
            Map<Character, Node> map = root.children;
            for (Character c: map.keySet()) {
                if (isMember(word.substring(1), map.get(c))) {
                    return true;
                }
            }
            return false;
        }
    }


    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList("fo", "foo", "bar", "baz"));
        Trie trie = new Trie();
        trie.setup(input);
        System.out.println(trie.isMember("foo", trie.root));
    }
}
