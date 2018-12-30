package Airbnb;

import java.util.*;

public class CheapestFlightWithinKStops_25 {

    public static class Flight{
        int city;
        int cost;
        int stops;
        String path;

        public Flight(int city, int cost, int stops, String path) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
            this.path = path;
        }
    }


    public static int findCheapestPrice(int[][] edges, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> routes = new HashMap<>();

        for (int[] edge: edges) {
            int city1 = edge[0];
            int city2 = edge[1];
            int cost = edge[2];
            Map<Integer, Integer> tmp = routes.getOrDefault(city1, new HashMap<>());
            tmp.put(city2, cost);
            routes.put(city1, tmp);
        }

        PriorityQueue<Flight> pq = new PriorityQueue<>((a,b) -> (a.cost - b.cost));
        pq.offer(new Flight(src, 0, k, "" + src));

        while (!pq.isEmpty()) {
            Flight cur = pq.poll();
            int curCity = cur.city;
            int curCost = cur.cost;
            int curStopsLeft = cur.stops;
            String curPath = cur.path;

            if (curCity == dst) {
                System.out.println(curPath);
                return curCost;
            }

            if (curStopsLeft >= 0) {
                Map<Integer, Integer> adj = routes.getOrDefault(curCity, new HashMap<>());
                for (int key: adj.keySet()) {
                    Flight f = new Flight(key, curCost + adj.get(key),
                            curStopsLeft - 1, curPath + "->" + key);
                    pq.offer(f);
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] edges = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int src = 0;
        int dst = 2;
        int k = 3;
        int res = new CheapestFlightWithinKStops_25().findCheapestPrice(edges, src, dst, k);
        System.out.println(res);
    }
}
