package FullTime.Facebook;

import java.util.*;

public class WordLadder {

    /**
     * Word Ladder I (return length of the shortest path)
     *
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output: 5
     *
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     *
     * Thoughts:
     * 1. BFS - traverse by level
     *
     * time: O(N*L), space: O(N)
     *
     */
    public int ladderLengthI(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                // find end word, return level
                if (s.equals(endWord)) {
                    return level;
                }
                List<String> adj = getAdj(wordSet, s);
                for (String str: adj) {
                    q.offer(str);
                    wordSet.remove(str);
                }
            }
            level++;
        }
        return 0;
    }

    // get the list of transformed words at next level
    public List<String> getAdj(Set<String> wordSet, String s) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char[] chs = s.toCharArray();

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == chs[i]) continue;

                chs[i] = c;
                String tmp = new String(chs);
                if (wordSet.contains(tmp)) {
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    /**
     * Word Ladder I (return one shortest path (String))
     *
     * Thoughts:
     * 1. add parent map
     * 2. search from end word to begin word
     *
     * time: O(N*L), space: O(N)
     */
    public List<String> findLaddersI(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Map<String, String> parent = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(endWord)) {
                    // get one path
                    return getPathI(parent, beginWord, endWord);
                }
                List<String> adj = getAdj(wordSet, s);
                for (String str: adj) {
                    q.offer(str);
                    wordSet.remove(str);
                    parent.put(str, s);
                }
            }
        }
        return new ArrayList<>();
    }

    // from end word to begin word
    public List<String> getPathI(Map<String, String> parent, String beginWord, String endWord) {
        List<String> res = new ArrayList<>();
        res.add(endWord);

        String cur = endWord;
        while (!cur.equals(beginWord)) {
            cur = parent.get(cur);
            res.add(0, cur);
        }
        return res;
    }


    /**
     * Word Ladder II (return all shortest paths (List<String>))
     *
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output:
     * [
     *   ["hit","hot","dot","dog","cog"],
     *   ["hit","hot","lot","log","cog"]
     * ]
     *
     * Thoughts:
     * 1. BFS + DFS (find paths)
     * 1. add level & neigh map
     * 2. update the level of a word when first visit
     *
     * time: O(V+E), space: O(V+E)
     *
     */
    List<List<String>> res = new ArrayList<>();
    Map<String, Integer> level = new HashMap<>();
    Map<String, List<String>> neigh = new HashMap<>();

    public List<List<String>> findLaddersII(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        // begin word, level = 1
        level.put(beginWord, 1);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                // reached the end level, break
                if (s.equals(endWord)) {
                    break;
                }
                List<String> adj = getAdj(wordSet, s);
                neigh.put(s, adj);
                for (String str: adj) {
                    if (level.containsKey(str)) continue;
                    level.put(str, level.get(s) + 1);
                    q.offer(str);
                }
            }
        }
        // get all paths
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        getPathII(beginWord, endWord, list);
        return res;
    }

    // DFS - get all paths
    public void getPathII(String cur, String endWord, List<String> list) {
        if (cur.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (String s: neigh.getOrDefault(cur, new ArrayList<>())) {
            if (level.get(s) == level.get(cur) + 1) {
                list.add(s);
                getPathII(s, endWord, list);
                list.remove(list.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        // test case 1
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        // print shortest len
        int len = new WordLadder().ladderLengthI(beginWord, endWord, wordList);
        System.out.println(len);

        // print shortest path
        List<String> path = new WordLadder().findLaddersI(beginWord, endWord, wordList);
        for (String p: path) {
            System.out.print(p + " ");
        }
        System.out.println();

        // print all shortest paths
        List<List<String>> paths = new WordLadder().findLaddersII(beginWord, endWord, wordList);
        for (List<String> p: paths) {
            for (String s: p) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

}
