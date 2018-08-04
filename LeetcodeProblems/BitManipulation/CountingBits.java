package BitManipulation;

/**
 * Created by sjwang on 08/04/2018
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
 * in their binary representation and return them as an array.
 *
 * Example 1:
 * Input: 2
 * Output: [0,1,1]
 *
 * Example 2:
 * Input: 5
 * Output: [0,1,1,2,1,2]
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] re = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            re[i] = Integer.bitCount(i);
        }
        return re;
    }
    public static void main(String args[]){
        System.out.println(new CountingBits().countBits(5));
    }
}
