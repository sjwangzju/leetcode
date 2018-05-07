package String;

/**
 * Created by sjwang on 07/05/2018.
 * Given two strings representing two complex numbers.
 *
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 *
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 *
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100].
 * And the output should be also in this form.
 */

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        int w, x, y, z, t, m;
        t = a.indexOf('+'); m = b.indexOf('+');

        w = Integer.valueOf(a.substring(0, t));
        x = Integer.valueOf(a.substring(t + 1, a.length() - 1));

        y = Integer.valueOf(b.substring(0, m));
        z = Integer.valueOf(b.substring(m + 1, b.length() - 1));
        return Integer.toString(w * y - x * z) + "+" + Integer.toString(w * z + x * y) + "i";
    }

    public static void main(String args[]){
        String str1 = "10+9i", str2 = "1+-1i";
        System.out.println(new ComplexNumberMultiplication().complexNumberMultiply(str1, str2));
    }

}
