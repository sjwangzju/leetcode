package FB;


public class LC785BipartiteGraph {

    /**
     * union find
     *
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int[] parent = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < graph.length; i++) {
            int[] tmp = graph[i];
            if (tmp.length == 0 || tmp == null) continue;
            int p1 = findParent(parent, i);
            int pp = findParent(parent, tmp[0]);

            for (int t: tmp) {
                int p2 = findParent(parent, t);
                if (p1 == p2) return false;
                parent[p2] = pp;
            }
        }
        return true;
    }

    public int findParent(int[] parent, int n) {
        while (n != parent[n]) {
            n = parent[n];
        }
        return n;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,4},{0,2},{1},{4},{0,3}};
        System.out.println(new LC785BipartiteGraph().isBipartite(graph));
    }
}
