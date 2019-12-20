package FullTime.Facebook;

import java.util.*;

public class IntersectionOfTwoArrays {

    /**
     * Intersection Of Two Arrays I
     *
     * Given two arrays, write a function to compute their intersection.
     * Arrays are not sorted.
     *
     * Note:
     * Each element in the result must be unique.
     * The result can be in any order.
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     *
     * Solution1: HashSet
     *
     * time: O(M+N), space: O(min(M,N))
     */
    public int[] intersectionI(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersectionI(nums2, nums1);

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int n: nums1) {
            set.add(n);
        }

        for (int n: nums2) {
            if (set.contains(n)) {
                list.add(n);
                set.remove(n);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    // Solution2:
    // 1. when len(nums2) >> len(nums1)
    // 2. sort nums2
    // 3. iterate through nums1, use binary search to find if it's in nums2
    //
    // time: O(NlogN), (N>M)
    // space: O(1)
    /*********************************************************/
    public int[] intersectionII(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersectionII(nums2, nums1);

        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int n: nums1) {
            if (exist(nums2, n)) {
                set.add(n);
            }
        }

        int[] res = new int[set.size()];
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // binary search
    public boolean exist(int[] nums2, int n) {
        int lo = 0, hi = nums2.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums2[mid] == n) return true;
            if (nums2[mid] < n) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }


    /**
     * Intersection Of Two Arrays II
     *
     * output should contain all intersection elements (don't need to be unique)
     * Arrays are not sorted.
     *
     * Input: nums1 = [1,2,1,6], nums2 = [1,3,2,4,1,1,5]
     * Output: [1,2,1]
     *
     */

    // Solution 1: HashMap
    //
    // time: O(M + N)
    // space: O(min(M,N))
    public int[] intersectionIII(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersectionIII(nums2, nums1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int n: nums2) {
            if (map.containsKey(n)) {
                list.add(n);
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) map.remove(n);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    // Solution 2: sort + two pointers
    //
    // time: O(MlogM + NlogN)
    // space: O(1)
    public int[] intersectionIV(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i++]);
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }


    // Solution 3: Binary Search
    //
    // Thoughts:
    // 1. add boolean[] visited
    // 2. don't use an element twice
    //
    // time: O(NlogN), space: O(N)
    public int[] intersectionV(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersectionIII(nums2, nums1);

        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums2);
        boolean[] visited = new boolean[nums2.length];

        for (int n: nums1) {
            if (find(nums2, visited, n, 0, nums2.length - 1)) {
                list.add(n);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // binary search
    public boolean find(int[] nums2, boolean[] visited, int n, int lo, int hi) {
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if (nums2[mid] == n) {
            if (!visited[mid]) {
                visited[mid] = true;
                return true;
            }
            return find(nums2, visited, n, lo, mid - 1) || find(nums2, visited, n, mid + 1, hi);
        } else if (nums2[mid] > n) {
            return find(nums2, visited, n, lo, mid - 1);
        }
        return find(nums2, visited, n, mid + 1, hi);
    }


    public static void main(String[] args) {
        int[] nums1 = {3,1,2}, nums2 = {1,1};
        int[] res = new IntersectionOfTwoArrays().intersectionV(nums1, nums2);
        for (int n: res) {
            System.out.print(n + " ");
        }
    }
}
