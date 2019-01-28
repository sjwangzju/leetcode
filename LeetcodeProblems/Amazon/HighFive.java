package Amazon;

import java.util.HashMap;
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
    public Map<Integer, Double> getHighFive(Result[] results) {
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
        Result[] results = new Result[7];
        results[0] = new Result(1, 90);
        results[1] = new Result(1, 10);
        results[2] = new Result(1, 90);
        results[3] = new Result(1, 90);
        results[4] = new Result(1, 100);
        results[5] = new Result(1, 100);
        results[6] = new Result(2, 10);

        Map<Integer, Double> res = new HighFive().getHighFive(results);
        for (int k: res.keySet()) {
            System.out.println(k + " " + res.get(k));
        }
    }
}
