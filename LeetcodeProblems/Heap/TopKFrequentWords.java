package Heap;

import java.util.*;

/**
 * Created by sjwang on 07/15/2018.
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        if(words.length == 0) return null;
        Map<String, Integer> m = new HashMap<>();
        List<String> L = new ArrayList<>();
        for(String s : words){
            if(!m.containsKey(s)) m.put(s, 1);
            else m.put(s, m.get(s) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
                (a,b) -> m.get(a).equals(m.get(b)) ? a.compareTo(b) : m.get(b) - m.get(a));
        for(String s : m.keySet()) pq.offer(s);
        while(!pq.isEmpty()){
            if(k <= 0) break;
            String s = pq.poll();
            L.add(s);
            k--;
        }
        return L;
    }
    public static void main(String args[]){
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(new TopKFrequentWords().topKFrequent(words, k));
    }
}
