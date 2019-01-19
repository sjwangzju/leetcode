package VMware;

import java.util.*;

public class EvenSubarray {

    public int evenSubarray(int[] input, int k) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        Set<List<Integer>> res = new HashSet<>();

        while (l <= r && r < input.length) {
            if (input[r] % 2 == 1) {
                cnt++;
            }
            if (cnt <= k) {
                getSubArray(res, l, r, input);
            } else {
                while (l <= r && input[l] % 2 == 0) {
                    l++;
                }
                l++;
                cnt--;
            }
            r++;
        }
        return res.size();
    }

    public void getSubArray(Set<List<Integer>> res, int l, int r, int[] input) {
        List<Integer> cur;
        for (int i = l; i <= r; i++) {
            cur = new LinkedList<>();
            for (int j = i; j <= r; j++) {
                cur.add(input[j]);
                res.add(new ArrayList<>(cur));
            }
        }
    }


    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        System.out.println(new EvenSubarray().evenSubarray(input, 1));
    }
}
