package FB;

/**
 * non-negative integer, less than 2^31 - 1
 *
 * Recursion
 * time: O(N), N is the num of digits
 * space: O(N), the depth of stack
 */
public class LC273_IntegerToEnglishWords_H {

    String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return convert(num);
    }

    /**
     * convert a num to its English representation
     * @param num
     * @return
     */
    public String convert(int num) {
        String res;
        if (num < 10) res = belowTen[num];
        else if (num < 20) res = belowTwenty[num - 10];
        else if (num < 100) res = belowHundred[num / 10] + " " + belowTen[num % 10];
        else if (num < 1000) res = convert(num / 100) + " Hundred " + convert(num % 100);
        else if (num < 1000000) res = convert(num / 1000) + " Thousand " + convert(num % 1000);
        else if (num < 1000000000) res = convert(num / 1000000) + " Million " + convert(num % 1000000);
        else res = convert(num / 1000000000) + " Billion " + convert(num % 1000000000);
        return res.trim();
    }

    public static void main(String[] args) {
        System.out.println(new LC273_IntegerToEnglishWords_H().numberToWords(103));
        System.out.println(new LC273_IntegerToEnglishWords_H().numberToWords(123));
        System.out.println(new LC273_IntegerToEnglishWords_H().numberToWords(12345));
        System.out.println(new LC273_IntegerToEnglishWords_H().numberToWords(1234567));
        System.out.println(new LC273_IntegerToEnglishWords_H().numberToWords(1234567891));
    }
}
