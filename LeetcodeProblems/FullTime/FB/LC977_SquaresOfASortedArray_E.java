package FullTime.FB;

/**
 * Two Pointers
 *
 * time: O(N)
 * space: O(1)
 */
public class LC977_SquaresOfASortedArray_E {

    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int l = 0, r = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i]) < min) {
                l = i;
                min = Math.abs(A[i]);
            }
        }

        r = l;
        int j = 0;
        while (l >= 0 || r < A.length) {
            if (l < 0) {
                res[j++] = A[r] * A[r++];
                continue;
            }
            if (r >= A.length) {
                res[j++] = A[l] * A[l--];
                continue;
            }
            if (Math.abs(A[l]) <= Math.abs(A[r])) {
                if (l == r) r++;
                res[j++] = A[l] * A[l--];
            } else {
                res[j++] = A[r] * A[r++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {-7,-3,2,3,11};
        int[] res = new LC977_SquaresOfASortedArray_E().sortedSquares(A);

        for (int n: res) {
            System.out.println(n);
        }
    }
}
