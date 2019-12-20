package FullTime.Google.OA;

public class OA1_WateringFlowers {

    public int cntSteps(int[] plants, int capacity) {
        if (plants == null || plants.length == 0) return 0;

        int res = 0, i = 0, cur = capacity;
        while (i < plants.length) {
            // go back to refill watering can
            if (cur < plants[i]) {
                cur = capacity;
                res += 2 * i;
            }
            // water the next plant
            cur -= plants[i++];
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] plants = {2,4,5,1,2};
        int capacity = 16;
        int res = new OA1_WateringFlowers().cntSteps(plants, capacity);
        System.out.println(res);
    }
}
