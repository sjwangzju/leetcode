package Amazon;

import java.util.*;

public class CourseScheduleII {

    /**
     * topological sort
     *
     * time: O(ElogV), space: O(E + V)
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
        }
        for (int[] n: prerequisites) {
            int n1 = n[0];
            int n2 = n[1];
            if (!adj.containsKey(n2)) {
                adj.put(n2, new LinkedList<>());
            }
            adj.get(n2).add(n1);
            indegree.put(n1, indegree.get(n1) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int k: indegree.keySet()) {
            if (indegree.get(k) == 0) {
                q.offer(k);
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[i++] = cur;
            if (adj.containsKey(cur)) {
                for (int n: adj.get(cur)) {
                    indegree.put(n, indegree.get(n) - 1);
                    if (indegree.get(n) == 0) {
                        q.offer(n);
                    }
                }
            }
        }

        if (i == numCourses) {
            return res;
        }
        return new int[0];
    }
}
