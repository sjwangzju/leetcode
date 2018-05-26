package Math;

/**
 * Created by sjwang on 05/16/2018.
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 * Input: 1
 * Output: "A"
 *
 * Example 2:
 * Input: 28
 * Output: "AB"
 *
 * Example 3:
 * Input: 701
 * Output: "ZY"
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String s = "";
        int mul = 1;
        while(n != 0){
            int d = n % 26;
            if(d == 0) d = 26;
            s = (char) (d - 1 + 'A') + s;
            n -= d * mul;
            mul *= 26;
        }
        return s;
    }

    public static void main(String args[]){
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));
    }
}
