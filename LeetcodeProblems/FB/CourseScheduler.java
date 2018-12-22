package FB;

import java.util.*;

public class CourseScheduler {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 || prerequisites == null) return true;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int[] n: prerequisites) {
            for (int p: n) {
                indegree.put(p, 0);
            }
        }

        for (int[] n: prerequisites) {
            for (int i = 0; i < n.length - 1; i++) {
                int c1 = n[i];
                int c2 = n[i + 1];
                Set<Integer> s = map.getOrDefault(c1, new HashSet<>());
                if (!s.contains(c2)) {
                    s.add(c2);
                    map.put(c1, s);
                    indegree.put(c2, indegree.getOrDefault(c2, 0) + 1);
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
        return cnt == indegree.size();
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println(new CourseScheduler().canFinish(numCourses, prerequisites));
    }
}
