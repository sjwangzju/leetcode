package Airbnb;

import java.util.*;

public class FindMinRoutes {

    /**
     * MST - prim's algorithm
     *
     * time: O(ElogV), space: O(V)
     *
     * @param input
     * @return
     */
    public int findRoutesI(String[][] input) {
        Map<String, Map<String, Integer>> islands = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> cost = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> (cost.get(a) - cost.get(b)));
        List<String[]> res = new ArrayList<>();

        for (String[] s: input) {
            String start = s[0];
            String end = s[1];
            int c = Integer.parseInt(s[2]);
            Map<String, Integer> tmp = islands.getOrDefault(start, new HashMap<>());
            tmp.put(end, c);
            islands.put(start, tmp);

            Map<String, Integer> tmp2 = islands.getOrDefault(end, new HashMap<>());
            tmp2.put(start, c);
            islands.put(end, tmp2);
        }

        for (String s: islands.keySet()) {
            cost.put(s, Integer.MAX_VALUE);
        }

        int islandNum = islands.size();
        for (String k: islands.keySet()) {
            pq.offer(k);
            cost.put(k, 0);
            parent.put(k,k);
            break;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            String cur = pq.poll();
            visited.add(cur);
            sum += cost.get(cur);
            if (!cur.equals(parent.get(cur))) {
                res.add(new String[]{cur,parent.get(cur)});
            }

            if (visited.size() == islandNum) {
                break;
            }
            Map<String, Integer> adj = islands.get(cur);
            for (String s: adj.keySet()) {
                if (!visited.contains(s) && adj.get(s) < cost.get(s)) {
                    if (cost.get(s) < Integer.MAX_VALUE) {
                        pq.remove(s);
                    }
                    cost.put(s, adj.get(s));
                    parent.put(s, cur);
                    pq.offer(s);
                }
            }
        }

        for (String[] s: res) {
            System.out.println(s[1] + " - " + s[0]);
        }

        return sum;
    }


    /**
     * MST - Kruskal Algorithm
     *
     * time: O(ElogE), space: O(E+V)
     *
     * @param input
     * @return
     */
    public int findRoutesII(String[][] input) {
        Map<String,Integer> cost = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> (cost.get(a) - cost.get(b)));
        List<String> res = new ArrayList<>();
        Set<String> islands = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for (String[] s: input) {
            islands.add(s[0]);
            islands.add(s[1]);
            String tmp = s[0] + "-" + s[1];
            int curCost = Integer.parseInt(s[2]);
            cost.put(tmp, curCost);
            pq.offer(tmp);
        }

        for (String island: islands) {
            parent.put(island, island);
        }

        int numIslands = islands.size();
        int sumCost = 0;

        while (!pq.isEmpty()) {
            String tmp = pq.poll();
            String i1= tmp.split("-")[0];
            String i2 = tmp.split("-")[1];

            if (!findParent(parent, i1).equals(findParent(parent, i2))) {
                res.add(tmp);
                sumCost += cost.get(tmp);
                if (!visited.contains(i2) && !visited.contains(i1)) {
                    parent.put(i2, i1);
                    visited.add(i2);
                    visited.add(i1);
                } else if (!visited.contains(i2)) {
                    parent.put(i2, i1);
                    visited.add(i2);
                } else {
                    parent.put(i1, i2);
                    visited.add(i1);
                }
                if (res.size() == numIslands - 1) break;
            }
        }
        for (String s: res) {
            System.out.println(s);
        }
        return sumCost;
    }

    public String findParent(Map<String, String> parent, String s) {
        while (!parent.get(s).equals(s)) {
            s = parent.get(s);
        }
        return s;
    }


    public static void main(String[] args) {
        String[][] input = {{"A","B","2"},{"A","C","1"},{"B","C","5"},{"B","E","3"},{"C","E","1"},
                {"B","D","11"},{"D","E","2"},{"E","F","4"},{"C","F","15"},{"F","G","1"},{"D","G","1"},{"E","G","3"}};
        System.out.println("min cost: " + new FindMinRoutes().findRoutesII(input));
    }
}
