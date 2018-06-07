package Math;

/**
 * Created by sjwang on 04/28/2018.
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * For example:
 *
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 */

public class AddDigits {
    public int addDigits(int num) {
        int sum = 0, temp = num;
        if(num / 10 == 0) return num;
        while(temp != 0){
            sum += temp % 10;
            temp /= 10;
        }
        return addDigits(sum);
    }

    public static void main(String args[]){
        System.out.println(new AddDigits().addDigits(38));
    }

}
