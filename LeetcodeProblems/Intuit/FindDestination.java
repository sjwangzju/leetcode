package Intuit;

import java.util.*;

public class FindDestination {

    public void findDest(String[] strs) {
        Set<String> loc = new HashSet<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        HashMap<String, List<String>> adj = new HashMap<>();
        HashMap<String, Set<String>> res = new HashMap<>();

        for (String s: strs) {
            String s1 = s.split(" ")[0];
            String s2 = s.split(" ")[1];
            loc.add(s1);
            loc.add(s2);
        }

        for (String s: strs) {
            String s1 = s.split(" ")[0];
            String s2 = s.split(" ")[1];
            if (!adj.containsKey(s1)) {
                adj.put(s1, new LinkedList<>());
            }
            adj.get(s1).add(s2);
            if (!indegree.containsKey(s1)) indegree.put(s1, 0);
            indegree.put(s2, indegree.getOrDefault(s2, 0) + 1);
        }

        List<String> start = new LinkedList<>();
        for (String s: indegree.keySet()) {
            if (indegree.get(s) == 0) {
                start.add(s);
            }
        }

        for (String s: start) {
            Set<String> tmp = new HashSet<>();
            find(s, adj, tmp);
            res.put(s, tmp);
        }

        // print
        for (String k: res.keySet()) {
            System.out.print(k + ": ");
            for (String s: res.get(k)) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        return;
    }

    public void find(String cur, HashMap<String, List<String>> adj, Set<String> set) {
        if (!adj.containsKey(cur)) {
            set.add(cur);
            return;
        }
        List<String> list = adj.get(cur);
        for (String l: list) {
            find(l, adj, set);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"A B","A C","B K","C K","E L","F G","J M","E F","G H","G I","K Y","K Z","H P"};
        new FindDestination().findDest(strs);
    }
}
