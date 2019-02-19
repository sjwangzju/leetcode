package Intuit;

import java.util.*;

public class FindEmployees {

    public void findEmployees(String[] input) {
        Map<String, List<Integer>> time = new HashMap<>();
        Map<String, List<Integer>> res = new HashMap<>();

        for (String s: input) {
            String[] strs = s.split(" ");
            String curName = strs[0];
            int curTime = Integer.parseInt(strs[1]);
            if (!time.containsKey(curName)) {
                time.put(curName, new LinkedList<>());
            }
            addTime(time.get(curName), curTime);
        }

        for (String s: time.keySet()) {
            List<Integer> tmp = time.get(s);
            int last = tmp.get(0);
            int index = 0;
            List<Integer> times = new LinkedList<>();
            times.add(last);
            for (int i = 1; i < tmp.size(); i++) {
                int t = tmp.get(i);
                if (t - last <= 100) {
                    times.add(t);
                } else {
                    if (times.size() >= 3) {
                        res.put(s, times);
                        break;
                    } else {
                        times.remove(tmp.get(index));
                        index++;
                        last = tmp.get(index);
                    }
                }
            }
        }

        if (res.size() == 0) {
            System.out.println("None");
            return;
        }
        List<String> names = new ArrayList<>(res.keySet());
        Collections.sort(names);

        for (String s: names) {
            System.out.print(s + ": ");
            List<Integer> l = res.get(s);
            for (int n: l) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    /**
     * adding element using binary search, time: O(logN)
     * @param list
     * @param n
     */
    public void addTime(List<Integer> list, int n) {
        int lo = 0;
        int hi = list.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (n >= list.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        list.add(lo, n);
    }

    public static void main(String[] args) {
        String[] input = {"Paul 1355","Jennifer 1910","Marcel 830","Paul 1315","Marcel 835",
                "Paul 1405","Paul 1630","Marcel 855","Marcel 930","Marcel 915",
                "Jennifer 1335","Jennifer 730","Marcel 1630"};
        new FindEmployees().findEmployees(input);
    }

}
