package Dropbox;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    // Queue
    // time:  hit => O(1), getHits => O(N), N is the num of outdated hits
    // space:  O(M), M is the num of hits
    public static class HitCounterI {
        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public HitCounterI() {
            this.queue = new LinkedList<>();
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            queue.offer(timestamp);
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
                queue.poll();
            }
            return queue.size();
        }
    }

    /****************************************************************************************/
    //Follow up:
    //What if the number of hits per second could be very large? Does your design scale?

    // time: hit => O(1),  getHits => O(N), N is the window size
    // space: O(N)
    public static class HitCounterII {

        public static class Hit{
            int timestamp;
            int hitNum;

            public Hit(int timestamp, int hitNum) {
                this.timestamp = timestamp;
                this.hitNum = hitNum;
            }
        }

        private int size;
        private Hit[] myHit;
        private int cnt;

        /** Initialize your data structure here. */
        public HitCounterII(int size) {
            this.size = size;
            this.myHit = new Hit[size];
            this.cnt = 0;
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            int index = timestamp % size;
            Hit h = myHit[index];
            if (h != null && timestamp == h.timestamp) {
                h.hitNum++;
            } else {
                myHit[index] = new Hit(timestamp, 1);
            }
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            int cnt = 0;
            for (Hit h: myHit) {
                if (h != null && timestamp - h.timestamp < size) {
                    cnt += h.hitNum;
                }
            }
            return cnt;
        }
    }


    /****************************************************************************************/
    public static void main(String[] args) {
        HitCounterII hc = new HitCounter.HitCounterII(300);
        hc.hit(1);
        hc.hit(1);
        hc.hit(1);
        hc.hit(5);
        System.out.println(hc.getHits(300));
        System.out.println(hc.getHits(301));
    }
}
