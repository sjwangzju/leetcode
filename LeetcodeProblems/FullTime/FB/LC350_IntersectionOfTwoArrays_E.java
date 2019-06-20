package FullTime.FB;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * time: O(M+N)
 * space: O(min(M,N))
 */
public class LC350_IntersectionOfTwoArrays_E {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int n: nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n: nums2) {
            if (map.containsKey(n)) {
                list.add(n);
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    map.remove(n);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = new LC350_IntersectionOfTwoArrays_E().intersect(nums1, nums2);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
