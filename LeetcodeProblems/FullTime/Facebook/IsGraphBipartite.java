package FullTime.Facebook;

public class IsGraphBipartite {

    // Given an undirected graph, return true if and only if it is bipartite.
    // every edge in the graph has one node in A and another node in B
    //
    //  Example 1:
    //  Input: [[1,3], [0,2], [1,3], [0,2]]
    //  Output: true
    //  Explanation:
    //  The graph looks like this:
    //  0----1
    //  |    |
    //  |    |
    //  3----2
    //  We can divide the vertices into two groups: {0, 2} and {1, 3}.
    //
    // Solution1:
    // 1. DFS
    // 2. color the graph with 2 colors
    // -> If it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes (DFS).
    // -> If it has been colored, check if the current color is the same as the color that is going to be used to color it.
    //
    // time: O(N), space: O(N)
    /*************************************************************/
    public boolean isBipartiteI(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            // is visited
            if (colors[i] != 0) continue;
            if (!isValid(graph, colors, 1, i)) return false;
        }
        return true;
    }

    public boolean isValid(int[][] graph, int[] colors, int color, int i) {
        if (colors[i] != 0) return color == colors[i];

        colors[i] = color;
        for (int n: graph[i]) {
            if (!isValid(graph, colors, -color, n)) return false;
        }
        return true;
    }


    // Solution2:
    // 1. union find
    //
    // time: O(N^2), space: O(N)
    public boolean isBipartiteII(int[][] graph) {
        int n = graph.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            if (graph[i].length == 0) continue;
            int p1 = findParent(parent, i);
            int p2 = findParent(parent, graph[i][0]);

            for (int j = 1; j < graph[i].length; j++) {
                int p = findParent(parent, graph[i][j]);
                if (p == p1) return false;
                parent[p] = p2;
            }
        }
        return true;
    }

    public int findParent(int[] parent, int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

}
