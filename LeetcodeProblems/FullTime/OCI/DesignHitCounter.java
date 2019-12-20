package FullTime.OCI;

public class DesignHitCounter {

    /**
     * Design a hit counter which counts the number of hits received in the past 5 minutes.
     *
     * HitCounter counter = new HitCounter();
     * // hit at timestamp 1.
     * counter.hit(1);
     * // hit at timestamp 2.
     * counter.hit(2);
     * // hit at timestamp 3.
     * counter.hit(3);
     * // get hits at timestamp 4, should return 3.
     * counter.getHits(4);
     * // hit at timestamp 300.
     * counter.hit(300);
     * // get hits at timestamp 300, should return 4.
     * counter.getHits(300);
     * // get hits at timestamp 301, should return 3.
     * counter.getHits(301);
     *
     * time: O(1), space: O(1)
     *
     */
    class HitCounter {

        int[] cnt;
        int[] time;

        /** Initialize your data structure here. */
        public HitCounter() {
            this.cnt = new int[300];
            this.time = new int[300];
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            int i = (timestamp - 1) % 300;
            if (time[i] != timestamp) {
                time[i] = timestamp;
                cnt[i] = 0;
            }
            cnt[i]++;
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            int sum = 0;
            for (int i = 0; i < 300; i++) {
                if (timestamp - time[i] < 300) {
                    sum += cnt[i];
                }
            }
            return sum;
        }
    }
}
