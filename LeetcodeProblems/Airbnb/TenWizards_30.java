package Airbnb;

import java.util.*;

public class TenWizards_30 {

    /**
     * Dijkstra, similar to No.25
     *
     * time: O(ElogV)
     *
     */
    public static int findMinCost(List<List<Integer>> input, int src, int dst, int n) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> cost = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int neigh: input.get(i)) {
                List<Integer> cur = adj.getOrDefault(i, new LinkedList<>());
                cur.add(neigh);
                adj.put(i, cur);
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == src) cost.put(src, src);
            else cost.put(i, Integer.MAX_VALUE);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (cost.get(a) - cost.get(b)));
        pq.offer(src);

        while (!pq.isEmpty()) {
            int curWizard = pq.poll();
            int curCost = cost.get(curWizard);
            visited.add(curWizard);

            if (curWizard == dst) {
                printPath(parent, curWizard);
                return curCost;
            }
            List<Integer> neighbor = adj.getOrDefault(curWizard, new LinkedList<>());
            for (int nei: neighbor) {
                int nextCost = curCost + (nei - curWizard) * (nei - curWizard);
                if (nextCost < cost.get(nei) && !visited.contains(nei)) {
                    cost.put(nei, nextCost);
                    parent.put(nei, curWizard);
                    pq.offer(nei);
                }
            }
        }

        return -1;
    }

    public static void printPath(Map<Integer, Integer> parent, int cur) {
        StringBuilder res = new StringBuilder();
        res.append(cur);
        while (cur != 0) {
            cur = parent.get(cur);
            res.insert(0, cur + " ");
        }
        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        List<List<Integer>> wizards = new ArrayList<>();
        wizards.add(Arrays.asList(1,3,4,5));
        wizards.add(Arrays.asList(1));
        wizards.add(Arrays.asList(2));
        wizards.add(Arrays.asList(9));
        wizards.add(Arrays.asList(9));
        wizards.add(Arrays.asList(9));
        wizards.add(Arrays.asList(6));
        wizards.add(Arrays.asList(7));
        wizards.add(Arrays.asList(8));
        wizards.add(Arrays.asList(9));
        System.out.println(new TenWizards_30().findMinCost(wizards, 0, 9, 10));
    }
}
