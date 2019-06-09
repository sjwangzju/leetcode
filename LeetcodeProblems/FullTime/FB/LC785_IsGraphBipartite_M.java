package FullTime.FB;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Solution1: Union Find
 * time: O(E+V)
 * space: O(V)
 *
 * Solution2: DFS (stack)
 * time: O(E+V)
 * space: O(V)
 *
 */
public class LC785_IsGraphBipartite_M {

    // DFS (stack)
    public boolean isBipartiteI(int[][] graph) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!map.containsKey(i)) {
                stack.push(i);
                map.put(i, 1);
            }

            while (!stack.isEmpty()) {
                int cur = stack.pop();
                int tmp = map.get(cur);
                for (int nei: graph[cur]) {
                    if (!map.containsKey(nei)) {
                        map.put(nei, -tmp);
                        stack.push(nei);
                    } else if (map.get(nei) == tmp) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Union Find
    public boolean isBipartiteII(int[][] graph) {
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
        System.out.println(new LC785_IsGraphBipartite_M().isBipartiteI(graph));
    }
}
