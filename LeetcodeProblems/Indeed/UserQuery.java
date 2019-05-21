package Indeed;

import java.util.*;

public class UserQuery {

//    Map<String, Set<String>> userSearch;
//    Map<String, Set<String>> words;
//    Map<String, Map<String, Integer>> graph;
//
//    public UserQuery() {
//        this.userSearch = new HashMap<>();
//        this.graph = new HashMap<>();
//        this.words = new HashMap<>();
//    }
//
//    public List<String> search(String user, String word) {
//
//        if (!userSearch.containsKey(user)) {
//            userSearch.put(user, new HashSet<>());
//        }
//        Set<String> list = userSearch.get(user);
//        for (String s: list) {
//            if (!s.equals(word)) {
//                update(graph, s, word);
//                update(graph, word, s);
//            }
//        }
//        userSearch.get(user).add(word);
//
//
//        Map<String, Integer> map = graph.getOrDefault(word, new HashMap<>());
//        List<String> res = new LinkedList<>();
//        for (String key: map.keySet()) {
//            res.add(key);
//        }
//        return res;
//    }
//
//    public void update(Map<String, Map<String, Integer>> graph, String s, String word) {
//        if (!graph.containsKey(s)) {
//            graph.put(s, new HashMap<>());
//        }
//        Map<String, Integer> tmp = graph.get(s);
//        tmp.put(word, tmp.getOrDefault(word, 0) + 1);
//    }


    public Map<String, Set<String>> words = new HashMap<>();
    public Map<String, Set<String>> users = new HashMap<>();

    public List<String> search(String user, String word) {
        if (!users.containsKey(user)) {
            users.put(user, new HashSet<>());
        }
        users.get(user).add(word);

        if (!words.containsKey(word)) {
            words.put(word, new HashSet<>());
        }
        words.get(word).add(user);

        Set<String> otherUsers = words.get(word);
        Map<String, Integer> freq = new HashMap<>();
        for (String s: otherUsers) {
            if (!s.equals(user)) {
                Set<String> otherWords = users.get(s);
                for (String ss: otherWords) {
                    if (!ss.equals(word)) {
                        freq.put(ss, freq.getOrDefault(ss, 0) + 1);
                    }
                }
            }
        }

        List<String> res = new LinkedList<>();
        for (String key: freq.keySet()) {
            res.add(key + ": " + freq.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        UserQuery userQuery = new UserQuery();
        System.out.println(userQuery.search("A", "python"));
        System.out.println(userQuery.search("B", "java"));

        System.out.println(userQuery.search("A", "java"));
        System.out.println(userQuery.search("B", "php"));

        System.out.println(userQuery.search("C", "python"));
        System.out.println(userQuery.search("C", "java"));

        System.out.println(userQuery.search("D", "java"));

    }
}
