package FullTime.FB;

import java.util.*;

/**
 * BFS + backtracking
 *
 * time: O(N*L*26), N is size of wordlist, L is len of word
 * space: O(N)
 */
public class LC126_WordLadderII_H {

    Map<String, List<String>> adj;
    Map<String, Integer> level;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        adj = new HashMap<>();
        level = new HashMap<>();

        for (String word: wordList) {
            level.put(word, Integer.MAX_VALUE);
        }
        level.put(beginWord, 0);

        int min = Integer.MAX_VALUE;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        // BFS - construct directed graph
        while (!q.isEmpty()) {
            String prev = q.poll();
            int nextL = level.get(prev) + 1;
            if (nextL > min) break;

            // try all one edit distance words
            for (int i = 0; i < prev.length(); i++) {
                StringBuilder s = new StringBuilder(prev);
                for (char c = 'a'; c <= 'z'; c++) {
                    s.setCharAt(i, c);
                    String cur = s.toString();

                    if (level.containsKey(cur)) {
                        // cur has been visited before
                        if (nextL > level.get(cur)) {
                            continue;
                        } else if (nextL < level.get(cur)) {
                            level.put(cur, nextL);
                            q.offer(cur);
                        }

                        // nextL <= level.get(cur)
                        if (!adj.containsKey(prev)) {
                            adj.put(prev, new LinkedList<>());
                        }
                        adj.get(prev).add(cur);

                        if (cur.equals(endWord)) {
                            min = nextL;
                        }
                    }
                }
            }
        }

        List<List<String>> res = new LinkedList<>();
        List<String> list = new LinkedList<>();
        list.add(beginWord);
        backtracking(list, res, min, beginWord, endWord);

        return res;
    }

    // backtracking
    public void backtracking(List<String> list, List<List<String>> res, int min, String cur, String endWord) {
        if (level.get(cur) > min) return;

        if (cur.equals(endWord)) {
            res.add(new LinkedList<>(list));
            return;
        }

        List<String> nei = adj.getOrDefault(cur, new LinkedList<>());
        for (String s: nei) {
            list.add(s);
            backtracking(list, res, min, s, endWord);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        List<List<String>> res = new LC126_WordLadderII_H().findLadders(beginWord, endWord, wordList);
        for (List<String> list: res) {
            for (String s: list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
