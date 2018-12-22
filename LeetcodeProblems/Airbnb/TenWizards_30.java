package Airbnb;

import java.util.*;

public class TenWizards_30 {

    /**
     * Dijkstra, similar to No.25
     *
     * time: O(ElogV)
     *
     * @param wizard
     * @param src
     * @param dest
     * @param cnt
     */
    public void findMinCost(List<List<Integer>> wizard, int src, int dest, int cnt) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        for (int i = 0; i < wizard.size(); i++) {
            List<Integer> list = wizard.get(i);
            for (int n: list) {
                Map<Integer, Integer> tmp = map.getOrDefault(i, new HashMap<>());
                tmp.put(n, (int)Math.pow(n - i, 2));
                map.put(i, tmp);
            }
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int[] cur = new int[]{0, src, src, cnt};
        queue.offer(cur);

        while (!queue.isEmpty()) {
            int[] n = queue.poll();
            int sumCost = n[0];
            int curWizard = n[1];
            int parWizard = n[2];
            int curCnt = n[3];
            parent.put(curWizard, parWizard);
            if (curWizard == dest) {
                printPath(src, parent, curWizard);
                System.out.println("cost: " + sumCost);
            }
            if (curCnt > 0) {
                Map<Integer, Integer> adj = map.getOrDefault(curWizard, new HashMap<>());
                for (int k: adj.keySet()) {
                    int cost = adj.get(k) + sumCost;
                    int[] tmp = new int[]{cost, k, curWizard, curCnt - 1};
                    queue.offer(tmp);
                }
            }
        }
    }

    public void printPath(int src, Map<Integer, Integer> map, int wizard) {
        StringBuilder res = new StringBuilder();
        int cur = wizard;
        res.append(cur);
        while (cur != src) {
            res.insert(0, map.get(cur) + " -> ");
            cur = map.get(cur);
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
        new TenWizards_30().findMinCost(wizards, 0, 9, 10);
    }
}
