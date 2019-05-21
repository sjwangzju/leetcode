package Dropbox;

import java.util.*;

public class MaxPhoto {

    // hashmap + sort
    // time: O(NlogN)
    // space: O(N)
    public List<Integer> getMaxPhotoI(List<Integer> viewList, int k) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int id: viewList) {
            map.put(id, map.getOrDefault(id, 0) + 1);
        }

        for (int n: map.keySet()) {
            res.add(n);
        }

        Collections.sort(res, (a,b) -> (map.get(b) - map.get(a)));
        return res.subList(0, k);
    }


    // hashmap + heap (size == k)
    public List<Integer> getMaxPhotoII(List<Integer> viewList, int k) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq
                = new PriorityQueue<>((a,b) -> (map.get(a) == map.get(b) ? (a - b) : (map.get(a) - map.get(b) )));

        for (int id: viewList) {
            map.put(id, map.getOrDefault(id, 0) + 1);
        }

        for (int n: map.keySet()) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int n: pq) {
            res.add(n);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> viewList = Arrays.asList(1,2,2,3,1,1,2,5,6,5,5);
        System.out.println(new MaxPhoto().getMaxPhotoII(viewList, 4));
    }
}
