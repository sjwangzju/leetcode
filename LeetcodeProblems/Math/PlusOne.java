package Math;

/**
 * Created by sjwang on 04/29/2018.
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int add = 1, len = digits.length;
        for(int i = len - 1; i >= 0; i --){
            if(add == 1){
                if(digits[i] == 9) digits[i] = 0;
                else{
                    digits[i] ++;
                    return digits;
                }
            }
            if(i == 0){
                int[] re = new int[len + 1];
                re[0] = 1;
                return re;
            }
        }
        return digits;
    }

    public static void main(String args[]){
        int[] digits = {9, 9};
        int[] result = new PlusOne().plusOne(digits);
        for(int i : result){
            System.out.println(i);
        }
    }
}
