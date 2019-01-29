package Amazon;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {

    public static class Result {
        public int id;
        public int value;

        public Result(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }

    /**
     * fixed size priority queue
     *
     * @param results
     * @return
     */
    public Map<Integer, Double> getHighFive(List<Result> results) {
        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> score = new HashMap<>();

        for (Result r: results) {
            int curId = r.id;
            int curValue = r.value;
            if (!score.containsKey(curId)) {
                score.put(curId, new PriorityQueue<>());
                score.get(curId).add(curValue);
                res.put(curId, (double)curValue);
            } else {
                if (score.get(curId).size() == 5) {
                    if (curValue > score.get(curId).peek()) {
                        int last = score.get(curId).poll();
                        score.get(curId).offer(curValue);
                        res.put(curId, res.get(curId) - last + curValue);
                    }
                } else {
                    score.get(curId).offer(curValue);
                    res.put(curId, res.get(curId) + curValue);
                }
            }
        }

        for (int k: res.keySet()) {
            res.put(k, res.get(k) / score.get(k).size());
        }

        return res;
    }

    public static void main(String[] args) {
        List<Result> list = new LinkedList<>();

        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 10);
        Result r3 = new Result(1, 92);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 100);
        Result r6 = new Result(1, 100);
        Result r7 = new Result(2, 10);
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        list.add(r5);
        list.add(r6);
        list.add(r7);

        Map<Integer, Double> res = new HighFive().getHighFive(list);
        for (int k: res.keySet()) {
            System.out.println(k + " " + res.get(k));
        }
    }
}
