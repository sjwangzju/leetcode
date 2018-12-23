package Airbnb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SocialNetworkGraph {

    /**
     * Print nodes indegree == 0
     * time: O(N), N is the number of users in the graph; space: O(V + E)
     *
     * @param map
     */
    public void graph(Map<String, String> map) {
        Set<String> set = new HashSet<>();
        Map<String, Set<String>> relationship = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for (String k: map.keySet()) {
            set.add(k);
        }
        for (String s: set) {
            indegree.put(s, 0);
        }
        for (String k: map.keySet()) {
            Set<String> s = relationship.getOrDefault(k, new HashSet<>());
            s.add(map.get(k));
            relationship.put(k, s);
            indegree.put(map.get(k), indegree.getOrDefault(map.get(k), 0) + 1);
        }
        int cnt = 0;
        for (String k: indegree.keySet()) {
            if (indegree.get(k) == 0) {
                cnt++;
                System.out.println(k);
            }
        }
        if (cnt == 0) {
            for (String k: map.keySet()) {
                System.out.println(k);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A","B");
        map.put("C","B");
        map.put("D","C");
        map.put("B","A");
        new SocialNetworkGraph().graph(map);
    }
}
