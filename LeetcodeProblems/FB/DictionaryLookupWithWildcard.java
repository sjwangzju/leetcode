package FB;

import java.util.*;

public class DictionaryLookupWithWildcard {

    public Map<Integer, List<String>> dict = new HashMap<>();

    public Trie trie = new Trie();

    public class Trie {

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

        public void insert(String word){
            Node current = root;
            for (int i=0; i < word.length(); i++){
                char c = word.charAt(i);
                Node node = current.children.get(c);
                if(node == null){
                    node = new Node();
                    current.children.put(c, node);
                }
                current = node;
            }
            // Set end to true
            current.end = true;
        }

        public boolean search(String word){
            Node current = root;
            for(int i =0; i < word.length(); i++){
                char c = word.charAt(i);
                Node node = current.children.get(c);
                if(node == null)
                    return false;
                current = node;
            }
            return current.end;
        }
    }

    public void setup2(List<String> input) {
        for (String s: input) {
            trie.insert(s);
        }
    }

    public boolean isMember2(String str) {
        return trie.search(str);
    }

//    public void setup1(List<String> input) {
//        for (String s: input) {
//            int len = s.length();
//            List<String> tmp = dict.getOrDefault(len, new LinkedList<>());
//            tmp.add(s);
//            dict.put(len, tmp);
//        }
//    }
//
//    public boolean isMember1(String str) {
//        int len = str.length();
//        if (!dict.containsKey(len)) {
//            return false;
//        }
//        List<String> list = dict.get(len);
//
//        for(String s: list) {
//            int cnt = 0;
//            for(int i = 0; i < len; i++) {
//                if (s.charAt(i) == str.charAt(i) || str.charAt(i) == '.') {
//                    cnt++;
//                }
//            }
//            if (cnt == len) {
//                return true;
//            }
//        }
//        return false;
//    }


    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList("foo", "bar", "baz"));
        DictionaryLookupWithWildcard LookUp = new DictionaryLookupWithWildcard();
//        LookUp.setup1(input);
//        System.out.println(LookUp.isMember1("foo"));
//        System.out.println(LookUp.isMember1("f.o"));
//        System.out.println(LookUp.isMember1("..d"));

        LookUp.setup2(input);
        System.out.println(LookUp.isMember2("foo"));
//        System.out.println(LookUp.isMember2("f.o"));
//        System.out.println(LookUp.isMember2("..d"));
    }
}
