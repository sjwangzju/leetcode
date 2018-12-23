package Airbnb;

import java.util.*;

public class CheapestFlightWithinKStops_25 {

    /**
     * find the cheapest price
     *
     * Dijkstra --  continually search the next node with the lowest cost
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // key: src, value: dst, price
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> cost = new HashMap<>();
        Set<Integer> cities = new HashSet<>();

        for (int[] flight: flights) {
            Map<Integer, Integer> map = prices.getOrDefault(flight[0], new HashMap<>());
            map.put(flight[1], flight[2]);
            cities.add(flight[0]);
            cities.add(flight[1]);
            prices.put(flight[0], map);
        }

        for (int i: cities) {
            if (i == src) {
                cost.put(i, 0);
            } else {
                cost.put(i, Integer.MAX_VALUE);
            }
        }

        // int[] a -> a[0] accumulated price, a[1] current city, a[2] parent of curCity, a[3] remain stops
        Queue<int[]> q = new PriorityQueue<>((a, b) -> cost.get(a[0]) - cost.get(b[0]));
        q.offer(new int[]{src, K});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curCity = cur[0];
            int curStopsLeft = cur[1];

            if (curCity == dst) {
                outputRoute(curCity, src, parent);
                return cost.get(curCity);
            }
            if (curStopsLeft > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(curCity, new HashMap<>());
                for (int k: adj.keySet()) {
                    int last = cost.getOrDefault(k, Integer.MAX_VALUE);
                    if (cost.get(curCity) + adj.get(k) < last) {
                        parent.put(k, curCity);
                        q.offer(new int[]{k, curStopsLeft - 1});
                        cost.put(k, cost.get(curCity) + adj.get(k));
                    }
                }
            }
        }
        return -1;
    }

    // output the optimal route
    public void outputRoute(int city, int src, Map<Integer, Integer> parent) {
        StringBuilder sb = new StringBuilder();
        while (city != src) {
            sb.insert(0, "->" + city);
            city = parent.get(city);
        }
        sb.insert(0, "the optimal flight route: " + city);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[][] flights = {{0,1,100}, {1,2,100}, {0,2,500}};
        int cheap = new CheapestFlightWithinKStops_25().findCheapestPrice(3, flights, 0, 2, 3);
        System.out.println("cheapest cost: " + cheap);
    }
}
