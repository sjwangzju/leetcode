package FullTime.LinkedIn;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII_DataStructureDesign {

    /**
     * Design and implement a TwoSum class.
     * It should support the following operations: add and find.
     *
     * add - Add the number to an internal data structure.
     * find - Find if there exists any pair of numbers which sum is equal to the value.
     *
     * add(1); add(3); add(3); add(5);
     * find(4) -> true
     * find(6) -> true
     * find(7) -> false
     *
     * the pair can be same numbers (3, 3)
     *
     * Solution: HashMap
     *
     * space: O(N), N is num of distinct numbers
     */
    class TwoSum {

        Map<Integer, Integer> map;

        /** Initialize your data structure here. */
        public TwoSum() {
            this.map = new HashMap<>();
        }

        // time: O(1)
        /** Add the number to an internal data structure.. */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        // time: O(N)
        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (int n: map.keySet()) {
                if (n == value - n) {
                    if (map.get(n) > 1) {
                        return true;
                    }
                } else {
                    if (map.containsKey(value - n)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
