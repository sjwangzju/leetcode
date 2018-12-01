package Airbnb;

public class MaximumNightAccommodate_20 {

    /**
     * the same as lc198
     * @param request
     * @return
     */
    public int findMaximumNights(int[] request) {
        if (request.length == 0 || request == null) return 0;

        int f1 = 0; int f2 = 0;
        for (int i = 0; i < request.length; i++) {
            int tmp = Math.max(f2, f1 + request[i]);
            f1 = f2;
            f2 = tmp;
        }
        return f2;
    }

    public static void main(String[] args) {
        int[] request = {4,10,3,1,5};
        int max = new MaximumNightAccommodate_20().findMaximumNights(request);
        System.out.println(max);
    }
}
