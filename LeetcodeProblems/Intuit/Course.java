package Intuit;

import java.util.*;

public class Course {

    public void findCommonCourses(String[][] input) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] s: input) {
            String s1 = s[0];
            String s2 = s[1];
            if (!map.containsKey(s1)) {
                map.put(s1, new LinkedList<>());
            }
            map.get(s1).add(s2);
        }
        List<String> students = new LinkedList<>(map.keySet());
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                String s1 = students.get(i);
                String s2 = students.get(j);
                List<String> tmp = map.get(s1);
                tmp.retainAll(map.get(s2));
                System.out.println(s1 + ", " + s2 + tmp);
            }
        }
    }


    public void findMiddle(String[][] input) {
        Set<String> courses = new HashSet<>();
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> children = new HashMap<>();
        List<String> res = new LinkedList<>();

        for (String[] s: input) {
            courses.add(s[0]);
            courses.add(s[1]);
            if (!indegree.containsKey(s[0])) indegree.put(s[0], 0);
            if (!indegree.containsKey(s[1])) indegree.put(s[1], 0);
            indegree.put(s[1], indegree.getOrDefault(s[1], 0) + 1);

            if (!children.containsKey(s[0])) {
                children.put(s[0], new LinkedList<>());
            }
            children.get(s[0]).add(s[1]);
        }

        Queue<String[]> q = new LinkedList<>();
        for (String s: indegree.keySet()) {
            if (indegree.get(s) == 0) {
                q.offer(new String[]{s, s});
            }
        }

        while(!q.isEmpty()) {
            String[] cur = q.poll();
            if (!children.containsKey(cur[0])) {
                res.add(cur[1]);
            } else {
                for (String n: children.get(cur[0])) {
                    String[] tmp = new String[2];
                    tmp[0] = n;
                    tmp[1] = cur[1] + n;
                    q.offer(tmp);
                }
            }
        }
        for (String s: res) {
            System.out.println(s + ", " + s.charAt((s.length() - 1) / 2));
        }

    }

    public static void main(String[] args) {
        String[][] input = {{"A","B"},{"B","C"},{"D","B"},{"B","F"},{"F","G"},{"F","H"},{"G","J"}};
        new Course().findMiddle(input);
    }
}
