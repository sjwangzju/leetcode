package TuSimple;

import java.util.Stack;

public class RightMostLargeElement {

    /**
     * stack
     * time: O(N), space: O(N)
     * @param nums
     * @return
     */
    public int[] findLarge(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                res[index] = i;
            }
            stack.push(i);
        }
        res[0] = -1;

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,2,1,3};
        int[] res = new RightMostLargeElement().findLarge(nums);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
