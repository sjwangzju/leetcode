package Intuit;

import java.util.*;

public class Course_1 {

    /*************************************************************************************/

    // find common courses

    // time: O(N^2), space: O(N)
    // use retainAll to find common elements of two lists
    public void findCommonCourses(String[][] input) {

        // save the courses for each student
        // time: O(N), space: O(N)
        Map<String, List<String>> map = new HashMap<>();
        for (String[] s: input) {
            String s1 = s[0];
            String s2 = s[1];
            if (!map.containsKey(s1)) {
                map.put(s1, new LinkedList<>());
            }
            map.get(s1).add(s2);
        }

        // find common courses
        // time: O(N^2)

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

    /*************************************************************************************/
    // only one path to finish all courses

    // time: O(N), space: O(N)
    public void findMiddleI(String[][] input) {

        List<String> res = new LinkedList<>();
        Map<String, String> child = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for (String[] s: input) {
            String s1 = s[0];
            String s2 = s[1];
            child.put(s1, s2);
            indegree.put(s2, indegree.getOrDefault(s2, 0) + 1);
            if (!indegree.containsKey(s1)) indegree.put(s1, 0);
        }

        Queue<String> q = new LinkedList<>();
        for (String s: indegree.keySet()) {
            if (indegree.get(s) == 0) {
                q.offer(s);
            }
        }
        while (!q.isEmpty()) {
            String cur = q.poll();
            res.add(cur);
            if (child.containsKey(cur)) {
                q.offer(child.get(cur));
            }
        }

        System.out.println(res.get((res.size() - 1) / 2));
    }


    /*************************************************************************************/
    // multiple paths to finish all courses

    // topological sort

    // time: O(V+E), space: O(V)
    public void findMiddleII(String[][] input) {
        Set<String> courses = new HashSet<>();
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> children = new HashMap<>();
        List<String> res = new LinkedList<>();

        for (String[] s: input) {
            courses.add(s[0]);
            courses.add(s[1]);
            if (!indegree.containsKey(s[0])) indegree.put(s[0], 0);
            if (!indegree.containsKey(s[1])) indegree.put(s[1], 0);
            indegree.put(s[1], indegree.get(s[1]) + 1);

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

//        String[][] input = {{"58","A"},{"94","B"},{"17","A"},{"58","B"},{"17","B"},{"58","C"}};
//        new Course_1().findCommonCourses(input);

//        String[][] input = {{"A","B"},{"C","D"},{"B","C"},{"E","F"},{"D","E"},{"F","G"}};
//        new Course_1().findMiddleI(input);

        String[][] input = {{"A","B"},{"B","C"},{"D","B"},{"B","F"},{"F","G"},{"F","H"},{"G","J"}};
        new Course_1().findMiddleII(input);
    }
}
