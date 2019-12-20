package FullTime.Walmart;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {

    // graph traversal
    // time: O(V+E), space: O(V+E)
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) return res;

        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, list, 0);
        return res;
    }

    // DFS traversal
    public void dfs(int[][] graph, List<Integer> list, int cur) {
        if (cur == graph.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int next: graph[cur]) {
            list.add(next);
            dfs(graph, list, next);
            list.remove(list.size() - 1);
        }
    }
}
