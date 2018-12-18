package FB;

import java.util.*;

public class FindTripletsThatSumToZero {
    /**
     * bruteforce - time: O(N^3), space: O(1)
     * @param nums
     * @return
     */
    public List<List<Integer>> findTripletsI(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    if (nums[j] + nums[k] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return res;
    }

    /**
     * hashmap - time: O(N^2), space: O(N)
     * @param nums
     * @return
     */
    public List<List<Integer>> findTripletsII(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int target = - nums[i] - nums[j];
                if (map.containsKey(target)) {
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
        }
        return res;
    }


    /**
     * two pointers - time: O(N^2), space: O(1)
     * @param nums
     * @return
     */
    public List<List<Integer>> findTripletsIII(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int lo = i; int hi = nums.length - 1;
            while (lo <= hi) {
                if (nums[lo] + nums[hi] < target) {
                    lo++;
                } else if (nums[lo] + nums[hi] > target) {
                    hi--;
                } else {
                    res.add(Arrays.asList(nums[lo], nums[hi], nums[i]));
                    lo++;
                    hi--;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-3,3,-1,0,2,-2,1};
        List<List<Integer>> res = new ArrayList<>();
        res = new FindTripletsThatSumToZero().findTripletsIII(nums);
        for (List<Integer> list: res) {
            for (int n: list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
