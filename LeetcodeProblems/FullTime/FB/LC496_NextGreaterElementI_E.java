package FullTime.FB;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * stack
 *
 * time: O(M+N)
 * space: O(M+N)
 */
public class LC496_NextGreaterElementI_E {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1};
        int[] res = new LC496_NextGreaterElementI_E().nextGreaterElement(nums1, nums2);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
