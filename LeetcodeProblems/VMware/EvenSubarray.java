package VMware;

import java.util.*;

public class EvenSubarray {
    public Set<List<Integer>> findSub(int[] input, int k) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        Set<List<Integer>> res = new HashSet<>();
        while (l <= r && r < input.length) {
            if (isOdd(input[r])) {
                cnt++;
            }
            if (cnt == k) {
                add(res, l, r, input);
                while (l < r) {
                    add(res, l, r, input);
                    int tmp = r + 1;
                    while (tmp < input.length && !isOdd(input[tmp])) {
                        add(res, l, tmp, input);
                        tmp++;
                    }
                    if (isOdd(input[l])) break;
                    l++;
                }
                l++;
                cnt--;
            }
            r++;
        }
        return res;
    }

    public boolean isOdd(int n) {
        return n % 2 == 1;
    }

    public void add(Set<List<Integer>> res, int l, int r, int[] input) {
        List<Integer> cur = new LinkedList<>();
        for (int i = l; i <= r; i++) {
            cur.add(input[i]);
        }
        res.add(cur);
    }

    public static void main(String[] args) {
        int[] input = {2,5,6,9};
        Set<List<Integer>> res = new EvenSubarray().findSub(input, 2);
        for (List<Integer> list: res) {
            for (int n: list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
