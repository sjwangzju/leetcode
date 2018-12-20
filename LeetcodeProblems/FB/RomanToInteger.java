package FB;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    /**
     * I - 1, IV - 4, V - 5, IX - 9, X - 10,
     * XL - 40, L - 50, XC - 90, C - 100,
     * CD - 400, D - 500, CM - 900, M - 1000
     *
     * @param input
     * @return
     */
    public int toInteger(String input) {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1); dict.put('V', 5);
        dict.put('X', 10); dict.put('L', 50);
        dict.put('C', 100); dict.put('D', 500); dict.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            char ch1 = input.charAt(i);
            char ch2 = input.charAt(i + 1);
            if (dict.get(ch1) < dict.get(ch2)) {
                sum -= dict.get(ch1);
            } else {
                sum += dict.get(ch1);
            }
        }
        sum += dict.get(input.charAt(input.length() - 1));
        return sum;
    }

    public static void main(String[] args) {
        String input = "MCMXCIV";
        System.out.println(new RomanToInteger().toInteger(input));
    }
}
