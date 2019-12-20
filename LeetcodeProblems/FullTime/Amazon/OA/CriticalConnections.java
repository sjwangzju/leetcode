package FullTime.Amazon.OA;

import java.util.*;

public class CriticalConnections {

    int time = 0;
    List<Integer>[] graph;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n], low = new int[n];
        graph = new ArrayList[n];
        Arrays.fill(disc, -1);
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // build graph
        for (List<Integer> connection : connections) {
            int v1 = connection.get(0), v2 = connection.get(1);
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, low, disc, i);
            }
        }
        return res;
    }

    private void dfs(int u, int[] low, int[] disc, int parent) {
        disc[u] = time;
        low[u] = time++;
        for (int j = 0; j < graph[u].size(); j++) {
            int v = graph[u].get(j);
            if (v == parent) {
                continue;
            }
            // v hasn't been discovered
            if (disc[v] == -1) {
                dfs(v, low, disc, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
