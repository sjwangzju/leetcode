package Indeed;

import java.util.*;

public class WordBreak {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map, 0);
    }

    public List<String> dfs(String s, List<String> wordDict, Map<Integer, List<String>> map, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }

        List<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        } else {
            for (int end = start + 1; end <= s.length(); end++) {
                String cur = s.substring(start, end);
                if (wordDict.contains(cur)) {
                    List<String> nextList = dfs(s, wordDict, map, end);
                    for (String next: nextList) {
                        res.add(cur + (next.length() == 0 ? "": " " + next));
                    }
                }
            }
        }
        map.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code","leetcode");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

}
