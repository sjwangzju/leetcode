package FullTime.FB;

/**
 * Solution1: Union Find
 *
 * time: O(E+V)
 * space: O(V)
 *
 */
public class LC785_IsGraphBipartite_M {

    public boolean isBipartite(int[][] graph) {
        int[] parent = new int[100];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) continue;
            int p1 = findParent(parent, i);
            int p2 = findParent(parent, graph[i][0]);

            for (int g: graph[i]) {
                int p = findParent(parent, g);
                if (p == p1) return false;
                parent[p] = p2;
            }
        }
        return true;
    }

    public int findParent(int[] parent, int n) {
        if (parent[n] != n) {
            return findParent(parent, parent[n]);
        }
        return parent[n];
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(new LC785_IsGraphBipartite_M().isBipartite(graph));
    }
}
