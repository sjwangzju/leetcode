package Airbnb;

import java.util.*;

public class CheapestFlightWithinKStops_25 {

    public static int findCheapestPrice(int[][] edges, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> routes = new HashMap<>();
        Map<Integer, Integer> cityCost = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> cities = new HashSet<>();

        for (int[] edge: edges) {
            int city1 = edge[0];
            int city2 = edge[1];
            int cost = edge[2];
            Map<Integer, Integer> tmp = routes.getOrDefault(city1, new HashMap<>());
            tmp.put(city2, cost);
            routes.put(city1, tmp);
            cities.add(city1);
            cities.add(city2);
        }

        for (int c: cities) {
            if (c == src) {
                cityCost.put(c, 0);
            } else {
                cityCost.put(c, Integer.MAX_VALUE);
            }
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b) -> (cityCost.get(a[0]) - cityCost.get(b[0])));
        pq.offer(new int[]{src, k + 1});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curCity = cur[0];
            int curCost = cityCost.get(curCity);
            int curStopsLeft = cur[1];

            if (curCity == dst) {
                printPath(parent, curCity, src);
                return curCost;
            }

            if (curStopsLeft > 0) {
                Map<Integer, Integer> adj = routes.getOrDefault(curCity, new HashMap<>());
                for (int key: adj.keySet()) {
                    if (curCost + adj.get(key) < cityCost.get(key)) {
                        cityCost.put(key, curCost + adj.get(key));
                        pq.offer(new int[]{key, curStopsLeft - 1, curCity});
                        parent.put(key, curCity);
                    }
                }
            }
        }
        return -1;
    }

    // follow up
    public static void printPath(Map<Integer, Integer> parent, int curCity, int src) {
        StringBuilder res = new StringBuilder();
        res.append(curCity);
        while (curCity != src) {
            curCity = parent.get(curCity);
            res.insert(0, curCity + "->");
        }
        System.out.println(res.toString());
    }


    public static void main(String[] args) {
        int[][] edges = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int n = 5;
        int src = 0;
        int dst = 2;
        int k = 2;

        int res = new CheapestFlightWithinKStops_25().findCheapestPrice(edges, src, dst, k);
        System.out.println(res);
    }
}
