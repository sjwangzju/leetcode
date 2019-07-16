package FullTime.FB;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Save by column, search by diagonal points
 *
 * time: O(N^2)
 * space: O(N^2)
 */
public class LC939_MinimumAreaRectangle_M {

    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] p: points) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }

        int min = Integer.MAX_VALUE;
        for (int[] p1: points) {
            for (int[] p2: points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    min = Math.min(min, Math.abs((p2[0] - p1[0]) * (p2[1] - p1[1])));
                }
            }
        }
        return min == Integer.MAX_VALUE? 0: min;
    }

    public static void main(String[] args) {
        int[][] points = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        System.out.println(new LC939_MinimumAreaRectangle_M().minAreaRect(points));
    }
}
