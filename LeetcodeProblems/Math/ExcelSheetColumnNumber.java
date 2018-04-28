package Math;

/**
 * Created by sjwang on 28/04/2018.
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 */

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int sum = 0, mul = 1;
        for(int i = chs.length - 1; i >= 0; i --){
            sum += (chs[i] - 'A' + 1) * mul;
            mul *= 26;
        }
        return sum;
    }

    public static void main(String args[]){
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
    }
}
