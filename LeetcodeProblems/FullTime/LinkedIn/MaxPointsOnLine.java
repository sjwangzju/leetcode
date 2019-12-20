package FullTime.LinkedIn;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {

    // Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
    //
    // Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
    // Output: 4
    // Explanation:
    // ^
    // |
    // |  o
    // |     o        o
    // |        o
    // |  o        o
    // +------------------->
    // 0  1  2  3  4  5  6
    //
    //
    // Thoughts:
    // 1. gcd (greatest common divisor)
    // 2. HashMap
    //    key: dx/gcd + "," + dy/gcd -> represent a slope
    //    val: freq
    // 3. corner case: duplicate points at same position should be counted
    //
    // time: O(N^2), space: O(N)
    //
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int len = points.length, res = 0;
        if (len <= 2) return len;

        for (int i = 0; i < len; i++) {
            int dup = 0, cur = 0;
            Map<String, Integer> map = new HashMap<>();

            for (int j = i + 1; j < len; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    dup++;
                    continue;
                }
                int tmp = gcd(dx, dy);
                dx /= tmp;
                dy /= tmp;
                String s = dx + "," + dy;
                map.put(s, map.getOrDefault(s, 0) + 1);
                cur = Math.max(cur, map.get(s));
            }
            res = Math.max(res, 1 + cur + dup);
        }
        return res;
    }

    // calculate the greatest common divisor
    public int gcd(int dx, int dy) {
        if (dy == 0) return dx;
        return gcd(dy, dx % dy);
    }
}
