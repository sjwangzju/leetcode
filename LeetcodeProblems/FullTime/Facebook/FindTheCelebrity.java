package FullTime.Facebook;

public class FindTheCelebrity {

    public boolean knows(int a, int b) {
        return true;
    }

    // Input: graph = [
    //  [1,1,0],
    //  [0,1,0],
    //  [1,1,1]
    // ]
    // Output: 1
    //
    // Thoughts:
    // 1. assign celebrity = 0 -> then update
    // 2. check if celebrity is valid
    //
    // time: O(N), space: O(N)
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == celebrity) continue;
            if (knows(celebrity, i) || !knows(i, celebrity)) return -1;
        }
        return celebrity;
    }
}
