package TuSimple;

import java.util.*;

public class FractionSeries {

    /**
     * time: O(nlogn), space: O(n)
     *
     * time: O(n), space: O(1)
     *
     * @param n
     * @return
     */
    public List<Double> findSeries(int n) {
        List<Double> res = new LinkedList<>();
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(a[0], b[0]));
//        for (int i = 2; i <= n; i ++) {
//            pq.offer(new double[]{1.0/i, i, 1});
//        }
//
//        while (!pq.isEmpty()) {
//            double[] cur = pq.poll();
//            double num = cur[0];
//            res.add(num);
//            double numerator = cur[1];
//            double next = cur[2] + 1;
//            if ((int) next < numerator) {
//                pq.offer(new double[]{next/numerator, numerator, next});
//            }
//        }
        pq.offer(new double[]{1.0/n, n, 1});
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            double num = cur[0];
            if (!res.contains(num)) res.add(num);
            double numerator = cur[1];

            double rightIndex = cur[2] + 1;
            if ((int) rightIndex < numerator) {
                pq.offer(new double[]{rightIndex/numerator, numerator, rightIndex});
            }

            double downNumerator = cur[1] - 1;
            if ((int) downNumerator > 1 && (int) downNumerator > cur[2]) {
                pq.offer(new double[]{cur[2]/downNumerator, downNumerator, cur[2]});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Double> res = new FractionSeries().findSeries(4);
        for (double d: res) {
            System.out.println(d);
        }
    }
}
