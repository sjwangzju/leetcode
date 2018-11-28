package Airbnb;

import java.util.LinkedList;
import java.util.List;

/**
 * x & (-x) --> power of the lowest set bit
 */
public class IPRangeToCIDR_10 {

    public List<String> IPRangeToCIDR(String ip, int range) {
        String[] ips = ip.split("\\.");
        long n = 0;
        for (int i = 0; i < ips.length; i++) {
            n = Integer.parseInt(ips[i]) + n * 256;
        }

        List<String> res = new LinkedList<>();
        while (range > 0) {
            long step = n & -n;
            while (step > range) step /= 2;
            res.add(longToCIDR(n, (int)step));
            range -= step;
            n += step;
        }
        return res;
    }

    public String longToCIDR(long n, int step) {
        int[] res = new int[4];
        res[0] = (int) (n & 255); n >>= 8;
        res[1] = (int) (n & 255); n >>= 8;
        res[2] = (int) (n & 255); n >>= 8;
        res[3] = (int) (n & 255);
        int len = 33;
        while (step > 0) {
            len--;
            step /= 2;
        }
        return res[3] + "." + res[2] + "." + res[1] + "." + res[0] + "/" + len;
    }

    public static void main(String[] args) {
        String ip = "255.0.0.7";
        int range = 11;
        List<String> res = new IPRangeToCIDR_10().IPRangeToCIDR(ip, range);
        for (String s: res) {
            System.out.println(s);
        }
    }
}
