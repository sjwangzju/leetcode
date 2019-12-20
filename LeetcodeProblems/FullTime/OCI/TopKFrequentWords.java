package FullTime.OCI;

import java.util.*;

public class TopKFrequentWords {

    // Given a non-empty list of words, return the k most frequent elements.
    // Your answer should be sorted by frequency from highest to lowest.
    // If two words have the same frequency, then the word with the lower alphabetical order comes first.
    //
    // Solution: HashMap + pq
    // time: O(NlogK), space: O(N)
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq
                = new PriorityQueue<>((a,b) -> (map.get(a).equals(map.get(b)) ? b.compareTo(a): map.get(a) - map.get(b)));

        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String s: map.keySet()) {
            pq.offer(s);
            if (pq.size() > k) pq.poll();
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }
}
