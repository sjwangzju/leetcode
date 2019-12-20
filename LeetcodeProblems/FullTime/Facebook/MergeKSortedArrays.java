package FullTime.Facebook;

public class MergeKSortedArrays {

    // Merge sort
    //
    // time: O(L*NlogN), space: O(N*L)
    public int[] mergeSort(int[][] arr) {
        return help(arr, 0, arr.length - 1);
    }

    public int[] help(int[][] arr, int lo, int hi) {
        if (lo == hi) return arr[lo];
        int mid = lo + (hi - lo) / 2;
        int[] n1 = help(arr, lo, mid);
        int[] n2 = help(arr, mid + 1, hi);
        return mergeTwoArrays(n1, n2);
    }

    public int[] mergeTwoArrays(int[] n1, int[] n2) {
        int l1 = n1.length, l2 = n2.length;
        int[] res = new int[l1 + l2];

        int i = 0, j = 0, k = 0;
        while (i < l1 && j < l2) {
            if (n1[i] <= n2[j]) {
                res[k++] = n1[i++];
            } else {
                res[k++] = n2[j++];
            }
        }
        while (i < l1) {
            res[k++] = n1[i++];
        }
        while (j < l2) {
            res[k++] = n2[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
        int[] res = new MergeKSortedArrays().mergeSort(arr);
        for (int n: res) {
            System.out.print(n +" ");
        }
    }
}
