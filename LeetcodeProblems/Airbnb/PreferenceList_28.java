package Airbnb;

import java.util.*;

public class PreferenceList_28 {

    /**
     * lc 269 Alien Dictionary -- topological sort -- BFS
     *
     * e.g.
     *
     * s1 = "wrt"
     * s2 = "wrff"
     * "er"
     * "ett"
     * "rftt"
     *
     *
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // initialize indegree = 0
        for (String s: words) {
            for (char ch: s.toCharArray()) {
                indegree.put(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {
                char ch1 = s1.charAt(j);
                char ch2 = s2.charAt(j);
                if (ch1 != ch2) {
                    // add ch2 to ch1's set in the map
                    Set<Character> cur = map.getOrDefault(ch1, new HashSet<>());
                    if (!cur.contains(ch2)) {
                        cur.add(ch2);
                        map.put(ch1, cur);
                        // increase indegree
                        indegree.put(ch2, indegree.get(ch2) + 1);
                    }
                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (Character ch: indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                q.offer(ch);
            }
        }

        while (!q.isEmpty()) {
            Character tmp = q.poll();
            res.append(tmp);
            if (map.containsKey(tmp)) {
                for (Character ch: map.get(tmp)) {
                    indegree.put(ch, indegree.get(ch) - 1);
                    if (indegree.get(ch) == 0) {
                        q.offer(ch);
                    }
                }
            }
        }

        // no valid output
        if (res.length() != indegree.size()) {
            return "";
        }

        return res.toString();
    }


    /**
     * AB_28
     * @param input
     * @return
     */
    public List<Integer> PreferenceList(List<List<Integer>> input) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (List<Integer> list: input) {
            for (int n : list) {
                indegree.put(n, 0);
            }
        }

        for (List<Integer> list: input) {
            for (int i = 0; i < list.size() - 1; i++) {
                int n1 = list.get(i);
                int n2 = list.get(i + 1);
                Set<Integer> cur = map.getOrDefault(n1, new HashSet<>());
                if (!cur.contains(n2)) {
                    cur.add(n2);
                    map.put(n1, cur);
                    indegree.put(n2, indegree.get(n2) + 1);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int n: indegree.keySet()) {
            if (indegree.get(n) == 0) {
                q.offer(n);
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            if (map.containsKey(cur)) {
                for (int i: map.get(cur)) {
                    indegree.put(i, indegree.get(i) - 1);
                    if (indegree.get(i) == 0) {
                        q.offer(i);
                    }
                }
            }
        }

        if (res.size() != indegree.size()) {
            return new LinkedList<>();
        }
        return res;
    }

    public static void main(String[] args) {
//        String[] words = {"wrt", "wrt"};
//        String res = new PreferenceList_28().alienOrder(words);
//        System.out.println(res);
        List<Integer> l1 = Arrays.asList(8,7);
        List<Integer> l2 = Arrays.asList(8,5,3,4);
        List<Integer> l3 = Arrays.asList(7,6,4);
        List<List<Integer>> L = new ArrayList<>();
        L.add(l1); L.add(l2); L.add(l3);
        List<Integer> res = new PreferenceList_28().PreferenceList(L);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
