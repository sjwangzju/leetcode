package FullTime.Google.OA;

public class OA2_MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] A, int[] B) {
        for (int n = 1; n <= 6; n++) {
            int cnt = getCount(A, B, n);
            if (cnt == -1) continue;
            return cnt;
        }
        return -1;
    }

    public int getCount(int[] A, int[] B, int n) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != n && B[i] != n) return -1;
            if (A[i] != n) cnt1++;
            if (B[i] != n) cnt2++;
        }
        return Math.min(cnt1, cnt2);
    }
}
