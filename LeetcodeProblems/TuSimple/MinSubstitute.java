package TuSimple;

public class MinSubstitute {

    /**
     * time: O(n)
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int tmp = 0;
        int[] cnt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                tmp++;
            }
            cnt[i] = tmp;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int n1 = nums[i];
            int n2 = nums[i + 1];
            if (n1 != n2) {
                int cur;
                if (n1 == 1) {
                    cur = cnt[i] + nums.length - 1 - i - (tmp - cnt[i]);
                } else {
                    cur = i + 1 - cnt[i] + tmp - cnt[i];
                }
                min = Math.min(min, cur);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,0,1};
        System.out.println(new MinSubstitute().findMin(nums));
    }
}
