package Google;

import java.util.LinkedList;
import java.util.List;

public class TriangleSortedArray {

    /**
     * find pivot and do merge sort
     *
     * time: O(N), space: O(N)
     *
     * @param nums
     */
    public void sort(int[] nums) {
        int i = 0;
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();

        while (nums[i] < nums[i + 1] && i + 1 < nums.length) {
            left.add(nums[i]);
            i++;
        }
        left.add(nums[i++]);

        for (int j = nums.length - 1; j >= i; j--) {
            right.add(nums[j]);
        }

        int l = 0;
        int r = 0;
        int p = 0;
        while (l < left.size() && r < right.size()) {
            if (left.get(l) < right.get(r)) {
                nums[p] = left.get(l++);
            } else {
                nums[p] = right.get(r++);
            }
            p++;
        }

        while (l < left.size()) {
            nums[p++] = left.get(l++);
        }

        while (r < right.size()) {
            nums[p++] = right.get(r++);
        }

        return;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,4,3};
        new TriangleSortedArray().sort(nums);
        for(int n: nums) {
            System.out.println(n);
        }
    }
}
