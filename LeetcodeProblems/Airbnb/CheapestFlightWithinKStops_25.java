package Airbnb;

import java.util.*;

public class CheapestFlightWithinKStops_25 {

    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        Map<Integer, Map<Integer,Integer>> routes = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> cost = new HashMap<>();

        for(int[] edge: edges) {
            Map<Integer,Integer> route = routes.getOrDefault(edge[0], new HashMap<>());
            route.put(edge[1], edge[2]);
            routes.put(edge[0], route);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        int[] cur = new int[]{0, src, k + 1};
        pq.offer(cur);

        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int curCost = tmp[0];
            int curCity = tmp[1];
            int stopsLeft = tmp[2];

            if (curCity == dst) {
                 printPath(parent, curCity, src);
                return curCost;
            }

            if (stopsLeft > 0) {
                Map<Integer,Integer> adj = routes.getOrDefault(curCity, new HashMap<>());
                for (int next: adj.keySet()) {
                    int nextCost = curCost + adj.get(next);

                    pq.offer(new int[]{nextCost, next, stopsLeft - 1});
                    parent.put(next, curCity);
                    cost.put(next, nextCost);

                }
            }
        }

        return -1;
    }

    public static void printPath(Map<Integer, Integer> parent, int city, int src) {
        int tmp = city;
        StringBuilder sb = new StringBuilder();
        sb.append(tmp);
        while(tmp != src) {
            tmp = parent.get(tmp);
            sb.insert(0, tmp + "->");
        }
        System.out.println(sb.toString());
        return;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int n = 5;
        int src = 0;
        int dst = 2;
        int k = 2;

        int res = new CheapestFlightWithinKStops_25().findCheapestPrice(n, edges, src, dst, k);
        System.out.println(res);
    }
}
