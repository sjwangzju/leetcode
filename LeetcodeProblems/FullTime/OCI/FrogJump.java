package FullTime.OCI;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {

    // If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units.
    // Note that the frog can only jump in the forward direction.
    //
    // [0,1,3,5,6,8,12,17]
    //
    // There are a total of 8 stones.
    // The first stone at the 0th unit, second stone at the 1st unit,
    // third stone at the 3rd unit, and so on...
    // The last stone at the 17th unit.
    //
    // Return true. The frog can jump to the last stone by jumping
    // 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
    // 2 units to the 4th stone, then 3 units to the 6th stone,
    // 4 units to the 7th stone, and 5 units to the 8th stone.
    //
    // Thoughts:
    // 1. dfs + memo (2D DP)
    //
    // time: O(N^2), space: O(N^2)
    Map<Integer, Integer> map = new HashMap<>();
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return true;

        int len = stones.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        return isValid(dp, stones, 0, 0);
    }

    // prev - prev position, cur - cur position (not index)
    public boolean isValid(int[][] dp, int[] stones, int prev, int cur) {
        if (!map.containsKey(cur)) return false;
        if (map.get(cur) == stones.length - 1) {
            dp[map.get(prev)][map.get(cur)] = 1;
            return true;
        }
        if (dp[map.get(prev)][map.get(cur)] != 0) return dp[map.get(prev)][map.get(cur)] == 1;

        int k = cur - prev;
        for (int gap = -1; gap <= 1; gap++) {
            int next = cur + k + gap;
            if (next <= cur) continue;
            if (isValid(dp, stones, cur, next)) {
                dp[map.get(prev)][map.get(cur)] = 1;
                return true;
            }
        }
        dp[map.get(prev)][map.get(cur)] = -1;
        return false;
    }
}
