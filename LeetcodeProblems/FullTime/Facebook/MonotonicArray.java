package FullTime.Facebook;

public class MonotonicArray {

    // An array is monotonic if it is either monotone increasing or monotone decreasing.
    // monotone increasing: i <= j, A[i] <= A[j]
    // monotone decreasing: i <= j, A[i] >= A[j]
    //
    // Input: [1,2,2,3]
    // Output: true
    //
    // Input: [1,3,2]
    // Output: false
    //
    // time: O(N), space: O(1)
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) return true;

        boolean isIncreasing = true, isDecreasing = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                isDecreasing = false;
            } else if (A[i] < A[i - 1]) {
                isIncreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }
}
