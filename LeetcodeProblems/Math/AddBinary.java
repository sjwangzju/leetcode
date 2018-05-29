package Math;

/**
 * Created by sjwang on 05/16/2018.
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        int add = 0, temp, l1 = a.length(), l2 = b.length();
        char[] ch1 = a.toCharArray(), ch2 = b.toCharArray(), l;
        if(l2 > l1){
            int t = l2; l2 = l1; l1 = t;
            l = ch1; ch1 = ch2; ch2 = l;
        }
        for(int i = 1; i <= l1; i ++){
            if(i <= l2){
                temp = (ch1[l1 - i] - '0' + ch2[l2 - i] - '0') + add;
            }else temp = ch1[l1 - i] - '0' + add;
            add = (temp >= 2? 1 : 0);
            if(add == 1){
                temp -= 2;
                if(i == l1){
                    ch1[l1 - i] = (char) (temp + '0');
                    char[] dup = new char[ch1.length + 1];
                    dup[0] = '1';
                    System.arraycopy(ch1, 0, dup, 1, ch1.length);
                    return new String(dup);
                }
            }
            ch1[l1 - i] = (char) (temp + '0');
        }
        return new String(ch1);
    }

    public static void main(String args[]){
        String num1 = "1010", num2 = "1011";
        System.out.println(new AddBinary().addBinary(num1, num2));
    }
}
