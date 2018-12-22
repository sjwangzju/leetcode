package FB;

import java.util.*;

public class CourseScheduler {

    /**
     * topological sort
     * time: O(V+E), space: O(V+E)
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] ret = new int[numCourses];

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
        }

        for (int[] n: prerequisites) {
            for (int i = 0; i < n.length - 1; i++) {
                int c1 = n[i];
                int c2 = n[i + 1];
                Set<Integer> s = map.getOrDefault(c2, new HashSet<>());
                if (!s.contains(c1)) {
                    s.add(c1);
                    map.put(c2, s);
                    indegree.put(c1, indegree.getOrDefault(c1, 0) + 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int k: indegree.keySet()) {
            if (indegree.get(k) == 0) {
                queue.offer(k);
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            ret[cnt] = tmp;
            cnt++;
            if (map.containsKey(tmp)) {
                for (int n: map.get(tmp)) {
                    indegree.put(n, indegree.get(n) - 1);
                    if (indegree.get(n) == 0) {
                        queue.offer(n);
                    }
                }
            }
        }
        if (cnt == numCourses) {
            return ret;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{1,0},{0,1}};
//        System.out.println(new CourseScheduler().canFinish(numCourses, prerequisites));
        int[] res = new CourseScheduler().findOrder(numCourses, prerequisites);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
