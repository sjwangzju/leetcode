package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

/**
 * Two pointers
 *
 * time: O(N)
 * space: O(1)
 */
public class LC246_StrobogrammaticNumber_E {

    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return true;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);

        int l = 0, r = num.length() - 1;
        while (l <= r) {
            int n1 = num.charAt(l++) - '0';
            int n2 = num.charAt(r--) - '0';
            if (!map.containsKey(n1) || !map.get(n1).equals(n2)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String num = "754";
        System.out.println(new LC246_StrobogrammaticNumber_E().isStrobogrammatic(num));
    }
}
