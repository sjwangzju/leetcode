package UnionFind;


/**
 * Created by sjwang on 10/09/2018.
 *
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 *
 * Example 1:
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 *
 * Example 2:
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 *
 * Note: you can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (findParent(parent, a) == findParent(parent, b)) {
                return false;
            }
            parent[findParent(parent, b)] = findParent(parent, a);
        }
        return edges.length == n - 1;
    }

    public int findParent(int[] parent, int n) {
        if (parent[n] != n) {
            return findParent(parent, parent[n]);
        }
        return parent[n];
    }

    public static void main(String args[]){
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(new GraphValidTree().validTree(5, edges));
    }
}
