package Airbnb;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

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

        for (int[] flight: flights) {
            Map<Integer, Integer> map = prices.getOrDefault(flight[0], new HashMap<>());
            map.put(flight[1], flight[2]);
            prices.put(flight[0], map);
        }

        // int[] a -> a[0] accumulated price, a[1] current city, a[2] parent of curCity, a[3] remain stops
        Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        q.offer(new int[] {0, src, src, K + 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curPrice = cur[0];
            int curCity = cur[1];
            int par = cur[2];
            int curStopsLeft = cur[3];
            parent.put(curCity, par);
            if (curCity == dst) {
                outputRoute(curCity, parent);
                return curPrice;
            }
            if (curStopsLeft > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(curCity, new HashMap<>());
                for (int k: adj.keySet()) {
                    int price = curPrice + adj.get(k);
                    q.offer(new int[] {price, k, curCity, curStopsLeft - 1});
                }
            }
        }
        return -1;
    }

    // output the optimal route
    public void outputRoute(int city, Map<Integer, Integer> parent) {
        StringBuilder sb = new StringBuilder();
        while (city != parent.get(city)) {
            sb.insert(0, "->" + city);
            city = parent.get(city);
        }
        sb.insert(0, "the optimal flight route: " + city);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[][] flights = {{0,1,100}, {1,2,100}, {0,2,500}};
        int cheap = new CheapestFlightWithinKStops_25().findCheapestPrice(3, flights, 0, 2, 0);
        System.out.println("cheapest cost: " + cheap);
    }
}
