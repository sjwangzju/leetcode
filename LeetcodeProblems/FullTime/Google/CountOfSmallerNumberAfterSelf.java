package FullTime.Google;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumberAfterSelf {

    // binary search
    // time: O(NlogN), space: O(N)
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(), list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int tmp = binarySearch(list, nums[i]);
            res.add(0, tmp);
            list.add(tmp, nums[i]);
        }
        return res;
    }

    public int binarySearch(List<Integer> list, int num) {
        int lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (num <= list.get(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
