package Airbnb;

import java.util.*;

public class Ski {

    /**
     * Dijkstra, time: O(V*E), space: O(V+E)
     * @param travel
     * @param point
     * @return
     */
    public int getMaxScore(String[][] travel, String[][] point) {
        Map<String, Map<String, Integer>> route = new HashMap<>();
        Map<String, Integer> reward = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        int maxScore = Integer.MIN_VALUE;
        String optimalPath = "";

        for (String[] s: travel) {
            String src = s[0];
            String cost = s[1];
            String dest = s[2];
            Map<String, Integer> map = route.getOrDefault(src, new HashMap<>());
            map.put(dest, Integer.parseInt(cost));
            route.put(src, map);
        }

        for (String[] s: point) {
            String pos = s[0];
            String tmp = s[1];
            reward.put(pos, Integer.parseInt(tmp));
        }
        // int[] -> int[0], sumScore; int[1], curPos; int[2], parent
        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> (Integer.parseInt(b[0]) - Integer.parseInt(a[0])));
        String[] tmp = new String[]{"0", "start", "start"};
        pq.offer(tmp);
        while (!pq.isEmpty()) {
            String[] cur = pq.poll();
            String curScore = cur[0];
            String curPos = cur[1];
            String curPar = cur[2];
            parent.put(curPos, curPar);

            if (curPos.length() >= 3 && curPos.substring(0, 3).equals("END")) {
                if (Integer.parseInt(curScore) > maxScore) {
                    maxScore = Integer.parseInt(curScore);
                    optimalPath = printRoute(parent, curPos);
                }
            }
            Map<String,Integer> map = route.getOrDefault(curPos, new HashMap<>());
            for (String k: map.keySet()) {
                int re = reward.get(k);
                int cost = map.get(k);
                int nextCost = Integer.parseInt(curScore) - cost + re;
                String[] s = new String[]{String.valueOf(nextCost), k, curPos};
                pq.offer(s);
            }
        }

        if (optimalPath.length() > 0) {
            System.out.println(optimalPath);
            return maxScore;
        }

        return -1;
    }

    public String printRoute(Map<String, String> parent, String pos) {
        StringBuilder res = new StringBuilder();
        res.append(pos);
        while (!pos.equals("start")) {
            pos = parent.get(pos);
            res.insert(0, pos + " -> ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[][] travel = {{"start","1","A"},{"start","1","B"},{"A","2","C"},{"B","3","G"},{"G","1","C"},
                {"C","4","D"},{"D","5","E"},{"E","1","END1"},{"D","5","F"},{"F","1","END2"}};
        String[][] point = {{"A","6"},{"B","8"},{"C","5"},{"D","2"},{"E","1"},{"F","5"},{"G","4"},{"END1","10"},{"END2","1"}};
        System.out.println(new Ski().getMaxScore(travel, point));
    }
}
