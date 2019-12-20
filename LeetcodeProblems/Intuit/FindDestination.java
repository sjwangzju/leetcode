package Intuit;

import java.util.*;

public class FindDestination {

    HashMap<String, Integer> indegree;
    HashMap<String, List<String>> adj;
    HashMap<String, Set<String>> res;

    public void findDest(String[] strs) {
        indegree = new HashMap<>();
        adj = new HashMap<>();
        res = new HashMap<>();

        for (String s: strs) {
            String s1 = s.split(" ")[0];
            String s2 = s.split(" ")[1];
            if (!indegree.containsKey(s1)) indegree.put(s1, 0);
            if (!indegree.containsKey(s2)) indegree.put(s2, 0);
        }

        for (String s: strs) {
            String s1 = s.split(" ")[0];
            String s2 = s.split(" ")[1];
            if (!adj.containsKey(s1)) {
                adj.put(s1, new LinkedList<>());
            }
            adj.get(s1).add(s2);
            indegree.put(s2, indegree.get(s2) + 1);
        }

        List<String> start = new ArrayList<>();
        for (String s: indegree.keySet()) {
            if (indegree.get(s) == 0) {
                start.add(s);
            }
        }

        for (String s: start) {
            Set<String> tmp = new HashSet<>();
//                find(s, adj, tmp);
            getEnds(s, tmp);
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
    }

    public void getEnds(String s, Set<String> set) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);

        while (!q.isEmpty()) {
            String cur = q.poll();
            visited.add(cur);

            List<String> neigh = adj.getOrDefault(cur, new ArrayList<>());
            if (neigh.size() == 0) {
                set.add(cur);
                continue;
            }
            for (String n : neigh) {
                indegree.put(n, indegree.get(n) - 1);
                if (indegree.get(n) == 0 && !visited.contains(n)) {
                    q.offer(n);
                }
            }
        }
    }

    // dfs
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
