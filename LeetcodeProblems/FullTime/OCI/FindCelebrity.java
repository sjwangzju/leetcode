package FullTime.OCI;

public class FindCelebrity {

    // API
    public class Relation {
        boolean knows(int a, int b) {
            return true;
        }
    }

    // time: O(N), space: O(1)
    public class Solution extends Relation {
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
}
