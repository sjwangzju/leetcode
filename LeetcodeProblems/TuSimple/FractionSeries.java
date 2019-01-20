package TuSimple;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FractionSeries {

    /**
     * time: O(nlogn), space: O(n)
     * @param n
     * @return
     */
    public List<Double> findSeries(int n) {
        List<Double> res = new LinkedList<>();
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(a[0], b[0]));
        for (int i = 2; i <= n; i ++) {
            pq.offer(new double[]{1.0/i, i, 1});
        }

        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            double num = cur[0];
            res.add(num);
            double numerator = cur[1];
            double next = cur[2] + 1;
            if ((int) next < numerator) {
                pq.offer(new double[]{next/numerator, numerator, next});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Double> res = new FractionSeries().findSeries(5);
        for (double d: res) {
            System.out.println(d);
        }
    }
}
