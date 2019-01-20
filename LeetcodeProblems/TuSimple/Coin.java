package TuSimple;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Coin {

    /**
     * time: O(nlogn), space: O(n)
     * @param p
     * @param k
     * @return
     */
    public double getProbability(double[] p, int k) {
        List<Double> res = new LinkedList<>();
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> (Double.compare(b[1], a[1])));
        pq.offer(new double[]{p[0],1});
        pq.offer(new double[]{1-p[0], 0});

        for (int i = 1; i < p.length; i++) {
            double curP = p[i];
            int siz = pq.size();
            List<double[]> list = new LinkedList<>();

            for(int j = 0; j < siz; j++) {
                list.add(pq.poll());
            }

            for (int m = 0; m < list.size(); m++) {
                double[] cur = list.get(m);
                double P1 = cur[0] * curP;
                double N1 = cur[1] + 1;
                double P2 = cur[0] * (1 - curP);
                double N2 = cur[1];
                pq.offer(new double[]{P1, N1});
                pq.offer(new double[]{P2, N2});
            }
        }

        while (!pq.isEmpty()) {
            double[] tmp = pq.poll();
            if (tmp[1] == k) res.add(tmp[0]);
            else if (tmp[1] < k) break;
        }

        double result = 0;
        for (double r: res) result += r;
        return result;
    }

    public static void main(String[] args) {
        double[] p = {0.3,0.5};
        int k = 0;
        System.out.println(new Coin().getProbability(p, k));
    }
}
