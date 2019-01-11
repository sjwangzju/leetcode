package FB;

public class LC88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * array mergeSort,
     *
     * time: O(NlogN), N is the number of elements in the array
     *
     * space: O(N)
     *
     */
    public int[] mergeSort(int[] nums) {
        int[] tmp = new int[nums.length];
        mergeSort(nums, tmp, 0, nums.length - 1);
        return tmp;
    }

    public void mergeSort(int[] nums, int[] tmp, int loStart, int hiEnd) {
        if (loStart >= hiEnd) return;
        int mid = loStart + (hiEnd - loStart) / 2;
        mergeSort(nums, tmp, loStart, mid);
        mergeSort(nums, tmp, mid + 1, hiEnd);
        mergeHalves(nums, tmp, loStart, hiEnd);
    }

    public void mergeHalves(int[] nums, int[] tmp, int loStart, int hiEnd) {
        int loEnd = loStart + (hiEnd - loStart) / 2;
        int hiStart = loEnd + 1;
        int left = loStart;
        int right = hiStart;
        int index = loStart;

        while (left <= loEnd && right <= hiEnd) {
            if (nums[left] <= nums[right]) tmp[index++] = nums[left++];
            else tmp[index++] = nums[right++];
        }
        for (int i = left; i <= loEnd; i++) {
            tmp[index++] = nums[left++];
        }
        for (int i = right; i <= hiEnd; i++) {
            tmp[index++] = nums[right++];
        }
        System.arraycopy(tmp, loStart, nums, loStart, hiEnd - loStart + 1);
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
//        int m = 3;
//        int n = 3;
//        new LC88MergeSortedArray().merge(nums1, m, nums2, n);
//        for (int num: nums1) {
//            System.out.println(num);
//        }
        int[] nums = {5,12,8,56,11,29};
        new LC88MergeSortedArray().mergeSort(nums);
        for (int n: nums) {
            System.out.println(n);
        }
    }
}
