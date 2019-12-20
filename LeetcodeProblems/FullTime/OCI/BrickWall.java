package FullTime.OCI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

    // You want to draw a vertical line from the top to the bottom and cross the least bricks.
    //
    // Thoughts:
    // 1. HashMap
    //    key: width, value: num of edges at that width
    // 2. return wall.size() - max edges
    //
    // time: O(N), space: O(N)
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (List<Integer> w: wall) {
            int sum = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                sum += w.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(max, map.get(sum));
            }
        }
        return wall.size() - max;
    }
}
