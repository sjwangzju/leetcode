package FullTime.LinkedIn;

public class GraphValidTree {

    // Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
    // write a function to check whether these edges make up a valid tree.
    //
    // Example 1:
    // Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
    // Output: true
    //
    // union find
    // time: O(N*K), K is num of edges
    // space: O(N)
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge: edges) {
            int p1 = findParent(parent, edge[0]);
            int p2 = findParent(parent, edge[1]);
            // contains cycle
            if (p1 == p2) return false;
            parent[p1] = p2;
        }
        return edges.length + 1 == n;
    }

    public int findParent(int[] parent, int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }
}
