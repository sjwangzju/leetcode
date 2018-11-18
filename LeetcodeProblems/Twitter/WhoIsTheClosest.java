package Twitter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WhoIsTheClosest {
    public int[] closest(String s, int[] queries) {
        char[] chs = s.toCharArray();
        int[] ret = new int[queries.length];
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            List l = map.getOrDefault(chs[i], new LinkedList<>());
            l.add(i);
            map.put(chs[i], l);
        }
        for (int i = 0; i < queries.length; i++) {
            List<Integer> cur = map.get(chs[queries[i]]);
            if (cur.size() == 1) {
                ret[i] = -1;
            } else {
                int pos = cur.indexOf(queries[i]);
                if (pos == 0) {
                    ret[i] = cur.get(1);
                } else if (pos == cur.size() - 1) {
                    ret[i] = cur.get(pos - 1);
                } else {
                    ret[i] = Math.abs(cur.get(pos) - cur.get(pos - 1))
                            <= Math.abs(cur.get(pos + 1) - cur.get(pos)) ? cur.get(pos - 1) : cur.get(pos + 1);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "hackerrank";
        int[] queries = {4,4,1,6,8};
        int[] ret = new WhoIsTheClosest().closest(s, queries);
        for (int n: ret) {
            System.out.println(n);
        }
    }
}
