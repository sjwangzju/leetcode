package FullTime.Facebook;

public class IntegerToEnglishWords {

    // Convert a non-negative integer to its english words representation.
    //
    // Input: 12345
    // Output: "Twelve Thousand Three Hundred Forty Five"
    //
    // Thoughts:
    // 1. input: non-negative integer [1, 2147483647]
    // 2. upper bound: billion (10^9)
    // 3. same pattern: 123(One Hundred Twenty Three) 456 (Four Hundred Fifty Six)
    //                  123456 (One Hundred Twenty Three Thousand Four Hundred Fifty Six)

    // 4. can use recursion: split by "Hundred, Thousand, Million, Billion"
    //
    // time: O(N), space: O(1)
    /*******************************************************************************/
    String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWordsI(int num) {
        if (num == 0) return "Zero";
        return convertI(num);
    }

    public String convertI(int num) {
        String res = "";
        if (num < 10) res = belowTen[num];
        else if (num < 20) res = belowTwenty[num - 10];
        else if (num < 100) res = belowHundred[num / 10] + " " + belowTen[num % 10];
        else if (num < 1000) res = belowTen[num / 100] + " Hundred " + convertI(num % 100);
        else if (num < 1000000) res = convertI(num / 1000) + " Thousand " + convertI(num % 1000);
        else if (num < 1000000000) res = convertI(num / 1000000) + " Million " + convertI(num % 1000000);
        else res = convertI(num / 1000000000) + " Billion " + convertI(num % 1000000000);
        return res.trim();
    }


    /**
     * num can be negative
     */
    public String numberToWordsII(int num) {
        if (num == 0) return "Zero";
        // if num is negative
        boolean negative = false;
        long n = num;
        if (n < 0) {
            negative = true;
            n = -n;
        }
        return negative? "Negative " + convertII(n): convertII(n);
    }

    public String convertII(long num) {
        String res = "";
        if (num < 10) res = belowTen[(int)num];
        else if (num < 20) res = belowTwenty[(int)(num - 10)];
        else if (num < 100) res = belowHundred[(int)(num / 10)] + " " + belowTen[(int)(num % 10)];
        else if (num < 1000) res = belowTen[(int)(num / 100)] + " Hundred " + convertII(num % 100);
        else if (num < 1000000) res = convertII(num / 1000) + " Thousand " + convertII(num % 1000);
        else if (num < 1000000000) res = convertII(num / 1000000) + " Million " + convertII(num % 1000000);
        else res = convertII(num / 1000000000) + " Billion " + convertII(num % 1000000000);
        return res.trim();
    }


    /*******************************************************************************/
    public static void main(String[] args) {
        // test 1 - edge case
        System.out.println(new IntegerToEnglishWords().numberToWordsI(0));

        // test 2
        System.out.println(new IntegerToEnglishWords().numberToWordsI(2147483647));

        // test 3
        System.out.println(new IntegerToEnglishWords().numberToWordsII(-2147483648));

    }
}
