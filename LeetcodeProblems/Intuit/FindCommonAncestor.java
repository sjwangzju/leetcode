package Intuit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindCommonAncestor {

    public boolean findAncestor(int[] p, int[][] pairs) {
        Map<Integer, List<Integer>> parent = new HashMap<>();

        for (int[] pair: pairs) {
            int n1 = pair[0];
            int n2 = pair[1];
            if (!parent.containsKey(n2)) {
                parent.put(n2, new LinkedList<>());
            }
            parent.get(n2).add(n1);
        }

        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        findAllAncestors(parent, p[0], p[0], list1);
        findAllAncestors(parent, p[1], p[1], list2);

        list1.retainAll(list2);
        return list1.size() != 0;
    }

    public void findAllAncestors(Map<Integer, List<Integer>> parent, int n, int origin, List<Integer> res) {
        if (n != origin) {
            res.add(n);
        }
        if (!parent.containsKey(n)) {
            return;
        }
        List<Integer> tmp = parent.get(n);
        for (int t: tmp) {
            findAllAncestors(parent, t, origin, res);
        }
    }

    public static void main(String[] args) {
        int[] p = {6,3};
        int[][] pairs = {{1,3},{2,3},{3,6},{4,5},{5,6},{5,7},{4,8},{8,9}};
        System.out.println(new FindCommonAncestor().findAncestor(p, pairs));
    }
}
