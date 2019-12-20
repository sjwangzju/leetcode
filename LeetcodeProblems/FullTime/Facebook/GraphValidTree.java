package FullTime.Facebook;

public class GraphValidTree {

    // Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
    // write a function to check whether these edges make up a valid tree.
    //
    // Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
    // Output: true
    //
    // union find
    // time: O(N^2), space: O(N)
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int p1 = findParent(parent, edges[i][0]);
            int p2 = findParent(parent, edges[i][1]);
            if (p1 == p2) return false;
            parent[p1] = p2;
        }
        return edges.length + 1 == n;
    }

    public int findParent(int[] parent, int n) {
        while (parent[n] != n) {
            n = parent[n];
        }
        return n;
    }
}
