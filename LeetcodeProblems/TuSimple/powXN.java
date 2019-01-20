package TuSimple;

public class powXN {

    /**
     * time: O(logN), space: O(1)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1.0 / x * myPow(1.0 / x, -(n + 1));
        if (n % 2 == 0) return myPow(x * x, n / 2);
        return x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        double x = 2;
        int n = -1;
        System.out.println(new powXN().myPow(x, n));
    }
}
