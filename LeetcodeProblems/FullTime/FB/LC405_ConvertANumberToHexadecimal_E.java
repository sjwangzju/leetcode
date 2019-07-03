package FullTime.FB;

/**
 * >> signed right shift:    shift with sign-extension
 * >>> unsigned right shift: shift with zero-extension
 *
 * e.g.
 *
 * -1        = 11111111 11111111 11111111 11111111
 * -1 >>  4  = 11111111 11111111 11111111 11111111
 * -1 >>> 4  = 00001111 11111111 11111111 11111111
 */
public class LC405_ConvertANumberToHexadecimal_E {

    public String toHex(int num) {
        if (num == 0) return "0";

        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            res.insert(0, map[num & 15]);
            num >>>= 4;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int num = -1;
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-1 >> 4));
        System.out.println(Integer.toBinaryString(-1 >>> 4));
        System.out.println(new LC405_ConvertANumberToHexadecimal_E().toHex(num));
    }
}
