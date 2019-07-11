package FullTime.FB;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Greedy + Heap
 *
 * time: O(N)
 * space: O(1)
 */
public class LC767_ReorganizeString_M {

    public String reorganizeString(String S) {
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: S.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue((a,b) -> (map.get(b) - map.get(a)));
        for (char ch: map.keySet()) {
            pq.offer(ch);
        }

        while (pq.size() >= 2) {
            char c1 = pq.poll();
            char c2 = pq.poll();

            res.append(c1).append(c2);
            map.put(c1, map.get(c1) - 1);
            map.put(c2, map.get(c2) - 1);
            if (map.get(c1) > 0) {
                pq.offer(c1);
            }
            if (map.get(c2) > 0) {
                pq.offer(c2);
            }
        }
        if (!pq.isEmpty()) {
            if (map.get(pq.peek()) > 1) return "";
            res.append(pq.poll());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String S = "aaab";
        System.out.println(new LC767_ReorganizeString_M().reorganizeString(S));
    }
}
