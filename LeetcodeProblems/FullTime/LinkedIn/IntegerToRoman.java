package FullTime.LinkedIn;

public class IntegerToRoman {


    // Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    //
    // Symbol       Value
    // I             1
    // V             5
    // X             10
    // L             50
    // C             100
    // D             500
    // M             1000
    //
    // Input: 58
    // Output: "LVIII"
    // Explanation: L = 50, V = 5, III = 3.
    //
    // time: O(1), space: O(1)
    public String intToRoman(int num) {
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] vals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num >= vals[i]) {
                num -= vals[i];
                res.append(strs[i]);
            }
            i++;
        }
        return res.toString();
    }

}
