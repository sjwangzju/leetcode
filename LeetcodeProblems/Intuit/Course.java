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

    public String findMiddle(String[][] input) {
        Set<String> courses = new HashSet<>();
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, String> children = new HashMap<>();

        for (String[] s: input) {
            courses.add(s[0]);
            courses.add(s[1]);
            if (!indegree.containsKey(s[0])) indegree.put(s[0], 0);
            if (!indegree.containsKey(s[1])) indegree.put(s[1], 0);
            indegree.put(s[1], indegree.getOrDefault(s[1], 0) + 1);
            children.put(s[0], s[1]);
        }

        Queue<String> q = new LinkedList<>();
        for (String s: indegree.keySet()) {
            if (indegree.get(s) == 0) {
                q.offer(s);
            }
        }

        int cnt = 0;
        int mid = (courses.size() + 1) / 2;
        while (!q.isEmpty()) {
            String cur = q.poll();
            q.offer(children.get(cur));
            cnt++;
            if (cnt == mid) return cur;
        }
        return "";
    }

    public static void main(String[] args) {
//        String[][] input = {{"58","A"},{"94","B"},{"17","A"},{"58","B"},{"17","B"},{"58","C"}};
//        new Course().findCommonCourses(input);
        String[][] input = {{"A","B"},{"C","D"},{"B","C"},{"E","F"},{"D","E"},{"F","G"}};
        System.out.println(new Course().findMiddle(input));
    }
}
