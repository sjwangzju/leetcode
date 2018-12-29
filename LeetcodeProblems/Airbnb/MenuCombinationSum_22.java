package Airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * get the centPrice (price * 100) to avoid comparing two doubles
 */
public class MenuCombinationSum_22 {

    public static List<List<Double>> MenuCombination(double[] prices, double target) {
        List<List<Double>> res = new ArrayList<>();
        List<Double> cur = new ArrayList<>();
        int[] centPrices = new int[prices.length];

        Arrays.sort(prices);

        for (int i = 0; i < prices.length; i++) {
            centPrices[i] = (int)prices[i] * 100;
        }

        find(res, cur, prices, centPrices, (int)target * 100, 0);

        return res;
    }


    public static void find(List<List<Double>> res, List<Double> cur, double[] prices,
                            int[] centPrices, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < centPrices.length; i++) {
            if (i > start && centPrices[i] == centPrices[i - 1]) continue;
            cur.add(prices[i]);
            find(res, cur, prices, centPrices, target - centPrices[i], i + 1);
            cur.remove(cur.size() - 1);
        }

        return;
    }

    public static void main(String[] args) {
        double[] prices = {1.0, 1.0, 2.0, 3.0, 4.0, 5.0};
        double target = 5.0;
        List<List<Double>> res = new ArrayList<>();
        res = new MenuCombinationSum_22().MenuCombination(prices, target);

        for (List<Double> list: res) {
            for (Double d: list) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}
