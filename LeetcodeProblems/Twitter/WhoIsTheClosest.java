package Twitter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WhoIsTheClosest {
    public List<Integer> closest(String s, List<Integer> queries) {
        char[] chs = s.toCharArray();
        int[] nearest = new int[s.length()];
        List<Integer> ret = new LinkedList<>();
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < chs.length; i++) {
            List l = map.getOrDefault(chs[i], new LinkedList<>());
            l.add(i);
            map.put(chs[i], l);

            if (l.size() == 1) {
                nearest[i] = -1;
            } else {
                if (l.size() == 2) {
                    nearest[(int)l.get(0)] = (int)l.get(1);
                } else if (l.size() > 2) {
                    int dis1 = (int)l.get(l.size() - 2) - (int)l.get(l.size() - 3);
                    int dis2 = (int)l.get(l.size() - 1) - (int)l.get(l.size() - 2);
                    if (dis2 < dis1) {
                        nearest[(int)l.get(l.size() - 2)] = (int)l.get(l.size() - 1);
                    }
                }
                nearest[i] = (int)l.get(l.size() - 2);
            }
        }
        for (int i = 0; i < queries.size(); i++) {
            ret.add(nearest[queries.get(i)]);
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "hackerrank";
        List<Integer> queries = new LinkedList<>();
        queries.add(4);queries.add(4);queries.add(1);queries.add(6);queries.add(8);
        List<Integer> ret = new WhoIsTheClosest().closest(s, queries);
        for (int n: ret) {
            System.out.println(n);
        }
    }
}
