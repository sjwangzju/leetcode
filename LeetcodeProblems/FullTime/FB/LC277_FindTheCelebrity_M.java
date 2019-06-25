package FullTime.FB;

/**
 * time: O(N)
 * space: O(1)
 */
public class LC277_FindTheCelebrity_M {

    public int findCelebrity(int n) {
        int cur = 0;
        for (int i = 1; i < n; i++) {
            if (knows(cur, i)) {
                cur = i;
            }
        }

        for (int i = 0; i < n; i++) {
            // cur celebrity knows others, or other don't know him
            if (i != cur && (knows(cur, i) || !knows(i, cur))) {
                return -1;
            }
        }
        return cur;
    }

    // API
    public boolean knows(int a, int b) {
        return false;
    }
}
