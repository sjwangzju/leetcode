package FullTime.LinkedIn;

import java.util.*;

public class InsertDeleteGetRandom {

    /**
     * Design a data structure that supports all following operations in average O(1) time.
     *
     * insert(val): Inserts an item val to the set if not already present.
     * remove(val): Removes an item val from the set if present.
     * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
     *
     * Thoughts:
     * 1. HashMap + List
     * 2. remove(val): every time delete the last element in the list (ensure O(1) time)
     *                a. get the index
     *                b. list.set(index, lastElement)
     *
     * time: O(1), space: O(N)
     */
    class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int index = map.get(val);
            // replace the element to be removed with the last element
            if (index < list.size() - 1) {
                int tmp = list.get(list.size() - 1);
                list.set(index, tmp);
                map.put(tmp, index);
            }
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random rd = new Random();
            return list.get(rd.nextInt(list.size()));
        }
    }
}
