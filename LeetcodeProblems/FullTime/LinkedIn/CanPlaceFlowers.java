package FullTime.LinkedIn;

public class CanPlaceFlowers {

    // Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
    // and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
    //
    // Input: flowerbed = [1,0,0,0,1], n = 1
    // Output: True
    //
    // Thoughts:
    // 1. greedy
    // 2. set flowerbed[i] = 1
    //
    // time: O(N), space: O(1)
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0, len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == len - 1 || flowerbed[i + 1] == 0)) {
                cnt++;
                flowerbed[i] = 1;
            }
            if (cnt >= n) return true;
        }
        return false;
    }

}
