package FullTime.FB;

/**
 * time: O(L^2 + N), N is len of input, L = 120
 * space: O(L)
 */
public class LC825_FriendsOfAppropriateAges_M {

    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) return 0;

        int[] cnt = new int[121];
        for (int age: ages) {
            cnt[age]++;
        }

        int sum = 0;
        for (int A = 120; A >= 1; A--) {
            int cntA = cnt[A];
            for (int B = A; B >= 1; B--) {
                int cntB = cnt[B];
                if (B <= 0.5 * A + 7) {
                    break;
                }
                sum += cntA * cntB;
                if (A == B) {
                    sum -= cntA;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ages = {73,106,39,6,26,15,30,100,71,35,46,112,6,60,110};
        System.out.println(new LC825_FriendsOfAppropriateAges_M().numFriendRequests(ages));
    }
}
