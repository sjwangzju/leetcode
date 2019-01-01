package Airbnb;

import java.util.*;

public class MinimumVerticesToTraverseDirectedGraph_29 {

    /**
     * Do DFS for each node that's not visited, in each DFS stops when there is a cycle
     *
     * time: O(V*E)
     * @param edges
     * @param n
     * @return
     */
    public List<Integer> getMin(int[][] edges, int n) {
//        Map<Integer, Set<Integer>> adj = new HashMap<>();
//        Set<Integer> visited = new HashSet<>();
//        List<Integer> res = new ArrayList<>();
//
//        for (int[] edge: edges) {
//            Set<Integer> tmp = adj.getOrDefault(edge[0], new HashSet<>());
//            tmp.add(edge[1]);
//            adj.put(edge[0], tmp);
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (!visited.contains(i)) {
//                res.add(i);
//                dfs(adj, res, visited, new HashSet<>(), i, i);
//            }
//        }
//        return res;

        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> vertices = new HashSet<>();
        List<Integer> res = new LinkedList<>();

        for (int[] edge: edges) {
            Set<Integer> tmp = adj.getOrDefault(edge[0], new HashSet<>());
            tmp.add(edge[1]);
            adj.put(edge[0], tmp);
            vertices.add(edge[0]);
            vertices.add(edge[1]);
        }

        for (int vertice: vertices) {
            if (!visited.contains(vertice)) {
                res.add(vertice);
                dfs(adj, res, visited, new HashSet<>(), vertice, vertice);
            }
        }
        return res;
    }

    public void dfs(Map<Integer, Set<Integer>> adj, List<Integer> res, Set<Integer> visited, Set<Integer> curVisited, int start, int curNode) {
        visited.add(curNode);
        curVisited.add(curNode);
        for (int n: adj.getOrDefault(curNode, new HashSet<>())) {
            if (res.contains(n) && n != start) {
                res.remove(n);
            }
            if (!curVisited.contains(n)) {
                dfs(adj, res, visited, curVisited, start, n);
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,0},{2,3},{3,4},{4,5},{5,3}};
        List<Integer> res = new MinimumVerticesToTraverseDirectedGraph_29().getMin(edges, 4);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
