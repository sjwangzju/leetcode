package Google;

public class Ancestor {
    public int[] solution (int D, int[] A) {
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ans[i] = findAncestor(A, D, i);
        }
        return ans;
    }

    public int findAncestor (int[] A, int D, int i) {
        if (D == 0) {
            return i;
        } else if (A[i] == -1) {
            return -1;
        }
        return findAncestor(A, D - 1, A[i]);
    }

    public static void main (String[] args) {
        // test cases:
        int D1 = 2;
        int[] A1 = {-1, 0, 1, 2, 3};

        int D2 = 3;
        int[] A2 = {-1, 0, 4, 2, 1};

        int D3 = 4;
        int[] A3 = {-1, 0, 4, 2, 1};

        int D4 = 10;
        int[] A4 = {-1, 0, 4, 2, 1};

        int D5 = 0;
        int[] A5 = {-1, 0, 4, 2, 1};

        int D6 = 1;
        int[] A6 = {-1, 0, 4, 2, 1};

        int D7 = 2;
        int[] A7 = {-1, 0, 4, 2, 2};

        int D8 = 2;
        int[] A8 = {-1, 0, 0, 1, 2};

        int D9 = 2;
        int[] A9 = {-1, 0, 0, 0, 0};

        int D10 = 3;
        int[] A10 = {-1, 0, 1, 1, 3, 4, 4};

        int[] ans = new Ancestor().solution(D1, A1);
        for (int i: ans) {
            System.out.println(i);
        }
    }
}
