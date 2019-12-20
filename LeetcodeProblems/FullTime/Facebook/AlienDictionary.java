package FullTime.Facebook;

import java.util.*;

public class AlienDictionary {

    // Input:
    // [
    //  "wrt",
    //  "wrf",
    //  "er",
    //  "ett",
    //  "rftt"
    // ]
    //
    // Output: "wertf"
    //
    // Thoughts:
    // 1. topological sort
    // 2. two maps: indegree & adj

    // time: O(V+E), space: O(V+E)
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word: words) {
            for (char c: word.toCharArray()) {
                // initialize indegree map
                if (!indegree.containsKey(c)) indegree.put(c, 0);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String s1 = words[i - 1], s2 = words[i];

            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                char c1 = s1.charAt(j), c2 = s2.charAt(j);
                if (c1 == c2) continue;

                // update the adj map
                if (!adj.containsKey(c1)) {
                    adj.put(c1, new ArrayList<>());
                }
                adj.get(c1).add(c2);
                indegree.put(c2, indegree.get(c2) + 1);
                break;
            }
        }

        Queue<Character> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for (char c: indegree.keySet()) {
            if (indegree.get(c) == 0) q.offer(c);
        }
        while (!q.isEmpty()) {
            char cur = q.poll();
            res.append(cur);
            List<Character> list = adj.getOrDefault(cur, new ArrayList<>());
            for (char c: list) {
                indegree.put(c, indegree.get(c) - 1);
                if (indegree.get(c) == 0) {
                    q.offer(c);
                }
            }
        }
        // check if invalid return ""
        return res.length() == indegree.size()? res.toString(): "";
    }

    public static void main(String[] args) {
        String[] words = {"ab","acde"};
        System.out.println(new AlienDictionary().alienOrder(words));
    }
}
