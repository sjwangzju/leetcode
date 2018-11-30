package Airbnb;

import java.util.*;

public class RoundPrices_18 {

    public List<Integer> roundPrices(List<Float> prices) {
        List<Integer> roundPrices = new LinkedList<>();
        List<Float> diff = new LinkedList<>();
        float oriSum = 0;
        int floorSum = 0;

        for (Float price: prices) {
            oriSum += price;
            int floorPrice = (int)Math.floor(price);
            floorSum += floorPrice;
            roundPrices.add(floorPrice);
            diff.add(price - floorPrice);
        }

        int n = (int) (oriSum - floorSum);
        List<Float> tmp = new LinkedList<>(diff);
        Collections.sort(tmp, new Comparator<Float>() {
            @Override
            public int compare(Float o1, Float o2) {
                return Float.compare(o2, o1);
            }
        });
        for (int i = 0; i < n; i++) {
            int index = diff.indexOf(tmp.get(i));
            roundPrices.set(index, roundPrices.get(index) + 1);
        }
        return roundPrices;
    }

    public static void main(String[] args) {
        List<Float> prices = new ArrayList<>(Arrays.asList(1.2f, 2.5f, 3.6f, 4.0f));
        List<Integer> roundPrices = new RoundPrices_18().roundPrices(prices);
        for (int n: roundPrices) {
            System.out.println(n);
        }
    }
}
