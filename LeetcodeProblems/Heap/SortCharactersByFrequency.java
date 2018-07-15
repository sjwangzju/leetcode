package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by sjwang on 07/15/2018.
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 */

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if(s.length() <= 2) return s;
        Map<Character, Integer> m = new HashMap<>();
        char[] chs = s.toCharArray();
        for(char ch: chs){
            if(!m.containsKey(ch)) m.put(ch, 1);
            else
                m.put(ch, m.get(ch) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(s.length(), new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return m.get(o2) - m.get(o1);
            }
        });
        for(char ch : m.keySet()) pq.offer(ch);
        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            for(int i = 0; i < m.get(ch); i ++) sb.append(ch);
        }
        return sb.toString();
    }
    public static void main(String args[]){
        String s = "tree";
        System.out.println(new SortCharactersByFrequency().frequencySort(s));
    }
}
