package TuSimple;

public class FindKthLargestElement {

    public int findKth(int[] nums, int k) {
        return find(nums, 0, nums.length - 1, nums.length - k);
    }

    public int find(int[] nums, int lo, int hi, int k) {
        int lb = lo;
        int hb = hi;
        int pt = lo + 1;
        int pivot = nums[lb];

        while (pt <= hb) {
            if (nums[pt] < pivot) swap(nums, lb++, pt++);
            else if (nums[pt] > pivot) swap(nums, pt, hb--);
            else pt++;
        }

        if (k < lb) return find(nums, lo, lb - 1, k);
        if (k > hb) return find(nums, hb + 1, hi, k);
        return pivot;
    }

    public void swap(int[] n, int i, int j) {
        int tmp = n[i];
        n[i] = n[j];
        n[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 3;
        System.out.println(new FindKthLargestElement().findKth(nums, k));
    }
}
