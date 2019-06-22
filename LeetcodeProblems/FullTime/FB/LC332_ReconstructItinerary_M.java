package FullTime.FB;

import java.util.*;

/**
 * Graph + DFS + backtracking
 *
 * time: O(ElogE), E is the num of edges
 * space: O(V+E)
 */
public class LC332_ReconstructItinerary_M {

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new LinkedList<>();
        Map<String, List<String>> neigh = new HashMap<>();

        // build the graph
        for (List<String> ticket: tickets) {
            String s1 = ticket.get(0);
            String s2 = ticket.get(1);

            if (!neigh.containsKey(s1)) {
                neigh.put(s1, new LinkedList<>());
            }
            neigh.get(s1).add(s2);
        }
        for (String s: neigh.keySet()) {
            Collections.sort(neigh.get(s));
        }

        res.add("JFK");
        dfs(neigh, res, "JFK", tickets.size());
        return res;
    }

    public boolean dfs(Map<String, List<String>> neigh, List<String> curList, String curCity, int n) {

        if (neigh.get(curCity) == null || neigh.get(curCity).size() == 0) {
            if (curList.size() - 1 == n) {
                return true;
            }
            return false;
        }

        List<String> list = neigh.get(curCity);
        for (int i = 0; i < list.size(); i++) {
            String s = list.remove(i);
            curList.add(s);
            if (dfs(neigh, curList, s, n)) {
                return true;
            }
            curList.remove(curList.size() - 1);
            list.add(i, s);
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("MUC","LHR");
        List<String> l2 = Arrays.asList("JFK","MUC");
        List<String> l3 = Arrays.asList("SFO","SJC");
        List<String> l4 = Arrays.asList("LHR","SFO");
        List<List<String>> l = new LinkedList<>();
        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);
        List<String> res = new LC332_ReconstructItinerary_M().findItinerary(l);

        for (String s: res) {
            System.out.println(s);
        }
    }
}
