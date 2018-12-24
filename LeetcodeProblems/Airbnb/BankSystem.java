package Airbnb;

import java.util.*;

public class BankSystem {

    Map<Integer, Integer> balance;
    Map<Integer, List<Integer>> times;
    Map<Integer, Map<Integer, Integer>> activity;

    BankSystem() {
        balance = new HashMap<>();
        times = new HashMap<>();
        activity = new HashMap<>();
    }

    public void deposit(int id, int timestamp, int amount) {
        balance.put(id, amount + balance.getOrDefault(id, 0));

        List<Integer> tmp = times.getOrDefault(id, new LinkedList<>());
        tmp.add(timestamp);
        times.put(id, tmp);

        Map<Integer, Integer> m = activity.getOrDefault(id, new HashMap<>());
        m.put(timestamp, balance.get(id));
        activity.put(id, m);

        return;
    }

    public boolean withdraw(int id, int timestamp, int amount) {
        if (!balance.containsKey(id) || balance.get(id) < amount) return false;
        balance.put(id, balance.get(id) - amount);

        List<Integer> tmp = times.getOrDefault(id, new LinkedList<>());
        tmp.add(timestamp);
        times.put(id, tmp);

        Map<Integer, Integer> m = activity.getOrDefault(id, new HashMap<>());
        m.put(timestamp, balance.get(id));
        activity.put(id, m);

        return true;
    }

    public int[] check(int id, int start, int end) {
        int[] res = new int[2];
        List<Integer> cur = times.getOrDefault(id, new LinkedList<>());
        int index1 = findBalanceII(cur, start);
        int index2 = findBalanceII(cur, end);

        res[0] = index1 == -1 ? 0: activity.get(id).get(cur.get(index1));
        res[1] = index2 == -1 ? 0: activity.get(id).get(cur.get(index2));
        return res;
    }

    /**
     * binary search, time: O(logN)
     *
     * @param list
     * @param time
     * @return
     */
    public int findBalanceI(List<Integer> list, int time) {
        if (time < list.get(0)) return -1;
        int lo = 0;
        int hi = list.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (time >= list.get(mid)) {
                if(time < list.get(mid + 1)) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    /**
     * Sort the timestamp list, time: O(NlogN)
     *
     * @param list
     * @param time
     * @return
     */
    public int findBalanceII(List<Integer> list, int time) {
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (time < list.get(i)) return i - 1;
        }
        return list.size() - 1;
    }

    public static void main(String[] args) {
        BankSystem bs = new BankSystem();
        System.out.println(bs.withdraw(0, 0, 100));
        bs.deposit(0, 0, 100);
        bs.withdraw(0, 5, 50);
        System.out.println(bs.check(0, 0, 3)[1]);
        System.out.println(bs.check(0, 0, 6)[1]);
        System.out.println(bs.check(0, 5, 10)[0]);
        System.out.println(bs.check(0, 5, 10)[1]);
    }
}
