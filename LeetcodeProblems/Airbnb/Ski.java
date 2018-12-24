package Airbnb;

import java.util.*;

public class Ski {

    /**
     * Can't use Dijkstra, edges may be negative
     *
     * BFS - time: O(V*E)
     *
     * @param travel
     * @param point
     * @return
     */
    public int getMaxScoreI(String[][] travel, String[][] point) {
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


    /**
     * Topological sort + BFS
     *
     * time: O(V+E)
     *
     * @param travel
     * @param point
     * @return
     */
    public int getMaxScoreII(String[][] travel, String[][] point) {
        Map<String,Map<String,Integer>> routes = new HashMap<>();
        Map<String, Integer> rewards = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, Integer> score = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> pos = new HashSet<>();
        List<String> bestPaths = new LinkedList<>();

        for (String[] s: travel) {
            String start = s[0];
            String end = s[2];
            pos.add(start);
            pos.add(end);
        }

        for (String s: pos) {
            indegree.put(s, 0);
        }

        for (String[] s: travel) {
            String start = s[0];
            String end = s[2];
            int cost = Integer.parseInt(s[1]);
            Map<String, Integer> tmp = routes.getOrDefault(start, new HashMap<>());
            tmp.put(end, cost);
            routes.put(start, tmp);
            indegree.put(end, indegree.get(end) + 1);
        }

        for (String[] s: point) {
            rewards.put(s[0], Integer.parseInt(s[1]));
        }


        Queue<String> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (String s: indegree.keySet()) {
            if (indegree.get(s) == 0) {
                queue.offer(s);
                score.put(s, 0);
                parent.put(s, s);
            }
        }
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int curScore = score.get(cur);

            if (!routes.containsKey(cur)) {
                if (curScore >= max) {
                    if (curScore == max) {
                        bestPaths.add(getPath(parent,cur));
                    } else {
                        bestPaths.clear();
                        bestPaths.add(getPath(parent,cur));
                    }
                    max = curScore;
                }
                continue;
            }

            Map<String, Integer> adj = routes.get(cur);
            for (String k: adj.keySet()) {
                int nextScore = curScore - adj.get(k) + rewards.get(k);
                if (nextScore > score.getOrDefault(k, Integer.MIN_VALUE)) {
                    score.put(k, nextScore);
                    parent.put(k, cur);
                }
                indegree.put(k, indegree.get(k) - 1);
                if (indegree.get(k) == 0) {
                    queue.offer(k);
                }
            }
        }

        for (String s: bestPaths) {
            System.out.println(s);
        }

        return max;
    }

    public String getPath(Map<String, String> parent, String pos) {
        StringBuilder res = new StringBuilder();
        res.append(pos);
        while (!parent.get(pos).equals(pos)) {
            pos = parent.get(pos);
            res.insert(0, pos + " -> ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[][] travel = {{"A","2","B"},{"A","3","C"},{"B","5","D"},{"B","6","E"},{"C","4","E"},
                {"C","4","F"},{"D","7","H"},{"E","6","H"},{"F","3","J"},{"H","1","I"},{"H","2","J"}};
        String[][] point = {{"B","1"},{"C","6"},{"D","2"},{"E","4"},{"F","17"},{"H","7"},{"I","3"},{"J","2"}};
        System.out.println(new Ski().getMaxScoreII(travel, point));
    }
}
