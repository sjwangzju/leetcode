package Airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * get the centPrice (price * 100) to avoid comparing two doubles
 */
public class MenuCombinationSum_22 {
    public List<List<Double>> MenuCombination(double[] prices, double target) {
        List<List<Double>> res = new ArrayList<>();
        List<Double> cur = new ArrayList<>();
        if (prices == null || prices.length == 0 || target < 0) return res;

        int centTarget = (int)(target * 100);
        int[] centPrices = new int[prices.length];
        boolean[] used = new boolean[prices.length];

        Arrays.sort(prices);
        for (int i = 0; i < prices.length; i++) {
            centPrices[i] = (int)(prices[i] * 100);
        }
        findCombination(res, cur, prices, centTarget, centPrices, 0, used);
        return res;
    }

    public void findCombination(List<List<Double>> res, List<Double> cur,
                                double[] prices, int centTarget, int[] centPrices, int start, boolean[] used) {
        if (centTarget == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < centPrices.length; i++) {
            if (i > 0 && centPrices[i] == centPrices[i - 1] && !used[i - 1]
                    || cur.size() > 0 && prices[i] < cur.get(cur.size() - 1)) continue;

            // break when this combination doesn't work
            if (centTarget < centPrices[i]) break;
            cur.add(prices[i]);
            used[i] = true;
            findCombination(res, cur, prices, centTarget - centPrices[i], centPrices, start + 1, used);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        double[] prices = {1.0, 1.0, 2.0, 3.0, 4.0, 5.0};
        double target = 5.0;
        List<List<Double>> res = new ArrayList<>();
        res = new MenuCombinationSum_22().MenuCombination(prices, target);

        for (List<Double> list: res) {
            for (Double d: list) {
                System.out.println(d + " ");
            }
            System.out.println();
        }
    }
}
