package Amazon;

public class FindNum {

    public boolean findNum(int[] nums, int n) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return findIncreasing(nums, n, 0, lo) || findDecreasing(nums, n, lo + 1, nums.length - 1);
    }

    public boolean findIncreasing(int[] nums, int n, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == n) return true;
            if (nums[mid] < n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public boolean findDecreasing(int[] nums, int n, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == n) return true;
            if (nums[mid] > n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,4,5,4,3};
        System.out.println(new FindNum().findNum(nums, 2));
    }
}
