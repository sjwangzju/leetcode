package FullTime.FB;

public class LC896_MonotonicArray_E {

    // Two Pass
    // time: O(N)
    // space: O(1)
    public boolean isMonotonicI(int[] A) {
        return isIncreasing(A) || isDecreasing(A);
    }

    public boolean isDecreasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isIncreasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return false;
            }
        }
        return true;
    }


    // One Pass
    // time: O(N)
    // space: O(1)
    public boolean isMonotonicII(int[] A) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1])
                isIncreasing = false;
            if (A[i] < A[i + 1])
                isDecreasing = false;
        }
        return isDecreasing || isIncreasing;
    }

    public static void main(String[] args) {
        int[] A = {1,2,2,1};
        System.out.println(new LC896_MonotonicArray_E().isMonotonicII(A));
    }
}
