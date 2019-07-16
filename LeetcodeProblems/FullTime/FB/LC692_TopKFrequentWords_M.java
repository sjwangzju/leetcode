package FullTime.FB;

import java.util.*;

/**
 * Priority Queue
 *
 * time: O(NlogK)
 * space: O(N)
 */
public class LC692_TopKFrequentWords_M {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> (map.get(a).equals(map.get(b))? b.compareTo(a): map.get(a) - map.get(b)));
        for (String s: map.keySet()) {
            pq.offer(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> res = new LC692_TopKFrequentWords_M().topKFrequent(words, k);
        for (String s: res) {
            System.out.println(s);
        }
    }
}
