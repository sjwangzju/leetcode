package FullTime.FB;

import java.util.*;

/**
 * Topological sort
 *
 * time: O(V+E)
 * space: O(V+E)
 *
 */
public class LC269_AlienDictionary {

    public String alienOrder(String[] words) {
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, List<Character>> adj = new HashMap<>();

        // initialize indegree for each character
        for (String word: words) {
            for (Character ch: word.toCharArray()) {
                if (!indegree.containsKey(ch)) {
                    indegree.put(ch, 0);
                }
            }
        }

        // topological sort
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if (ch1 == ch2) continue;

                List<Character> neigh = adj.getOrDefault(ch1, new LinkedList<>());
                if (!neigh.contains(ch2)) {
                    neigh.add(ch2);
                    adj.put(ch1, neigh);
                    indegree.put(ch2, indegree.get(ch2) + 1);
                }
                break;
            }
        }

        // add nodes with indegree == 0 to the queue
        Queue<Character> queue = new LinkedList<>();
        for (Character ch: indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            res.append(c);

            // get all neighbours
            List<Character> list = adj.getOrDefault(c, new LinkedList<>());
            for (char n: list) {
                indegree.put(n, indegree.get(n) - 1);
                if (indegree.get(n) == 0) {
                    queue.offer(n);
                }
            }
        }

        // check invalid
        if (res.length() != indegree.size()) return "";

        return res.toString();
    }

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(new LC269_AlienDictionary().alienOrder(words));
    }
}
