package Math;

/**
 * Created by sjwang on 05/16/2018.
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int add = 0, temp, l1 = num1.length(), l2 = num2.length();
        char[] ch1 = num1.toCharArray(), ch2 = num2.toCharArray(), l;
        if(l2 > l1){
            int t = l2; l2 = l1; l1 = t;
            l = ch1; ch1 = ch2; ch2 = l;
        }
        for(int i = 1; i <= l1; i ++){
            if(i <= l2){
                temp = (ch1[l1 - i] - '0' + ch2[l2 - i] - '0') + add;
            }else temp = ch1[l1 - i] - '0' + add;
            add = (temp >= 10? 1 : 0);
            if(add == 1){
                temp -= 10;
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
        String num1 = "256", num2 = "1323";
        System.out.println(new AddStrings().addStrings(num1, num2));
    }

}
