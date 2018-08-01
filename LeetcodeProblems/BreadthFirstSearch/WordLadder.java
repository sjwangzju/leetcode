package BreadthFirstSearch;

import java.util.*;

/**
 * Created by sjwang on 08/01/2018.
 * Given two words (beginWord and endWord), and a dictionary's word list, f
 * ind the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> s = new HashSet<>(wordList);
        if(s.contains(beginWord)) s.remove(beginWord);
        Queue<String> Q = new LinkedList<>();
        Q.offer(beginWord);
        int step = 1, curN = 1, nextN = 0;
        while(!Q.isEmpty()) {
            curN--;
            String cur = Q.poll();
            for(int i = 0; i < cur.length(); i++) {
                char[] chs = cur.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    chs[i] = ch;
                    String str = String.valueOf(chs);
                    if(s.contains(str)) {
                        if(str.equals(endWord)) return step + 1;
                        Q.offer(str);
                        s.remove(str);
                        nextN++;
                    }
                }
            }
            if(curN == 0) {
                curN = nextN;
                nextN = 0;
                step++;
            }
        }
        return 0;
    }
    public static void main(String args[]){
        String beginWord = "hit", endWord = "cog";
        List<String> L = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, L));
    }
}
