package FullTime.FB;

import java.util.*;

/**
 * HashMap + Binary Search
 */
public class LC981_TimeBasedKeyValueStore_M {

    static class timeVal {
        String val;
        int timestamp;

        timeVal(String val, int timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }
    }

    static class TimeMap {
        Map<String, List<timeVal>> map;
        /** Initialize your data structure here. */
        public TimeMap() {
            this.map = new HashMap<>();
        }

        // time: O(1)
        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new timeVal(value, timestamp));
        }

        // time: O(logN)
        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";

            List<timeVal> list = map.get(key);
            int lo = 0, hi = list.size() - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (timestamp >= list.get(mid).timestamp) {
                    if (timestamp < list.get(mid + 1).timestamp) {
                        return list.get(mid).val;
                    }
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (timestamp >= list.get(lo).timestamp) {
                return list.get(lo).val;
            }
            return "";
        }
    }

    public static void main(String[] args) {
        TimeMap m = new TimeMap();
        m.set("love","high",10);
        m.set("love","low",20);
        System.out.println(m.get("love",5));
        System.out.println(m.get("love",10));
        System.out.println(m.get("love",15));
        System.out.println(m.get("love",20));
    }
}
