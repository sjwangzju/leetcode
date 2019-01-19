package TuSimple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedArrays {

    /**
     * time: O(nlogk)
     * space: O(n)
     *
     * @param arr
     * @return
     */
    public int[] merge(int[] arr) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                nums.add(new ArrayList<>(cur));
                nums.add(new ArrayList<>(Arrays.asList(arr[i])));
                cur = new ArrayList<>();
            } else {
                cur.add(i);
            }
        }
        if (cur.size() > 0) nums.add(new ArrayList<>(cur));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
        }

        int index = 0;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            res[index++] = tmp[0];
            int next = tmp[2] + 1;
            int pos = tmp[1];
            if (next < nums.get(pos).size()) {
                pq.offer(new int[]{nums.get(pos).get(next), pos, next});
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,1,4,5,10,7,8,9};
        int[] res = new MergekSortedArrays().merge(arr);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
