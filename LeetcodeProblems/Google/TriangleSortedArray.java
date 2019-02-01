package Google;


public class TriangleSortedArray {

    /**
     * find pivot and do merge sort
     *
     * time: O(N), space: O(N)
     *
     * @param nums
     */
    public int[] sort(int[] nums) {
        int i = 0;
        int[] res = new int[nums.length];

        while (nums[i] < nums[i + 1]) {
            i++;
        }

        int l = 0;
        int r = nums.length - 1;
        int p = 0;
        while (l <= i && r > i) {
            if (nums[l] < nums[r]) {
                res[p] = nums[l++];
            } else {
                res[p] = nums[r--];
            }
            p++;
        }

        while (l <= i) {
            res[p++] = nums[l++];
        }

        while (r > i) {
            res[p++] = nums[r--];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,4,3};
        int[] res = new TriangleSortedArray().sort(nums);
        for(int n: res) {
            System.out.println(n);
        }
    }
}
