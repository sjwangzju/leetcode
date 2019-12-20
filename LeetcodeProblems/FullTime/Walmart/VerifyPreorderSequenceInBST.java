package FullTime.Walmart;

public class VerifyPreorderSequenceInBST {

    // Solution 1: Recursion
    // time: O(N^2), worst: [5,4,3,2,1]
    // space: O(logN)
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        return isValid(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValid(int[] preorder, int i, int j, int lo, int hi) {
        if (i > j) return true;
        if (preorder[i] >= hi || preorder[i] <= lo) return false;

        int nextj = i + 1;
        while (nextj <= j && preorder[nextj] < preorder[i]) {
            nextj++;
        }
        return isValid(preorder, i + 1, nextj - 1, lo, preorder[i])
                && isValid(preorder, nextj, j, preorder[i], hi);
    }

}
