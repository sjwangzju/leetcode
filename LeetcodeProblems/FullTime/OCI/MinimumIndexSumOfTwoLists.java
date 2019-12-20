package FullTime.OCI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    // You need to help them find out their common interest with the least list index sum.
    // If there is a choice tie between answers, output all of them with no order requirement.
    // You could assume there always exists an answer.
    //
    // Input:
    // ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    // ["KFC", "Shogun", "Burger King"]
    // Output: ["Shogun"]
    // Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
    //
    // time: O(N + M), space: O(min(M,N))
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        if (list1.length > list2.length) return findRestaurant(list2, list1);
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int tmp = i + map.get(list2[i]);
                if (tmp <= min) {
                    if (tmp < min) {
                        res = new ArrayList<>();
                        min = tmp;
                    }
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
