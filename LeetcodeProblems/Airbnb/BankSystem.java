package Airbnb;

import java.util.*;

public class BankSystem {

    public static class MyBankSystem{
        Map<Integer, Integer> account;
        Map<Integer, Map<Integer, Integer>> activity;
        Map<Integer, List<Integer>> timeline;

        public MyBankSystem() {
            this.account = new HashMap<>();
            this.activity = new HashMap<>();
            this.timeline = new HashMap<>();
        }

        public void deposit(int id, int timestamp, int amount) {
            account.put(id, account.getOrDefault(id, 0) + amount);

            Map<Integer, Integer> curActivity = activity.getOrDefault(id, new HashMap<>());
            curActivity.put(timestamp, account.get(id));
            activity.put(id, curActivity);

            List<Integer> curTimeline = timeline.getOrDefault(id, new LinkedList<>());
            curTimeline.add(timestamp);
            timeline.put(id, curTimeline);
        }

        public boolean withdraw(int id, int timestamp, int amount) {
            if (!account.containsKey(id) || account.get(id) < amount) return false;
            account.put(id, account.get(id) - amount);

            Map<Integer, Integer> curActivity = activity.getOrDefault(id, new HashMap<>());
            curActivity.put(timestamp, account.get(id));
            activity.put(id, curActivity);

            List<Integer> curTimeline = timeline.getOrDefault(id, new LinkedList<>());
            curTimeline.add(timestamp);
            timeline.put(id, curTimeline);
            return true;
        }

        public Integer check(int id) {
            return account.get(id);
        }


        public int[] getBalance(int id, int startTime, int endTime) {
            int[] res = new int[2];
            if (!account.containsKey(id)) return res;
            List<Integer> curTimeLine = timeline.get(id);

            int s = curTimeLine.get(getStartIndex(curTimeLine, startTime));
            int e = curTimeLine.get(getEndIndex(curTimeLine, endTime));

            res[0] = activity.get(id).get(s);
            res[1] = activity.get(id).get(e);

            return res;
        }

        public int getStartIndex(List<Integer> list, int t) {
            if (t < 0 || t < list.get(0)) return 0;
            int lo = 0;
            int hi = list.size() - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int midTime = list.get(mid);
                if (t <= midTime) {
                    if (t > list.get(mid - 1)) return mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return lo;
        }

        public int getEndIndex(List<Integer> list, int t) {
            if (t > list.get(list.size() - 1)) return list.size() - 1;
            int lo = 0;
            int hi = list.size() - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int midTime = list.get(mid);
                if (t >= midTime) {
                    if (t < list.get(mid + 1)) return mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return lo;
        }

    }

    public static void main(String[] args) {
        MyBankSystem bs = new MyBankSystem();
        // t1 = 0, b = 100
        bs.deposit(1, 0, 100);
        System.out.println(bs.check(1));

        // t2 = 5, b = 50
        bs.withdraw(1, 5, 50);
        System.out.println(bs.check(1));

        // t3 = 10, b = 80
        bs.deposit(1, 10, 30);
        System.out.println(bs.check(1));

        // t4 = 15, b = 260
        bs.deposit(1, 15, 180);
        System.out.println(bs.check(1));

        int[] res = new int[2];
        res = bs.getBalance(1, 5, 12);
        System.out.println(res[0] + " " + res[1]);
    }
}
