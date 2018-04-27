package Math;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 27/04/2018.
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *
 * Also, a self-dividing number is not allowed to contain the digit zero.
 *
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 *
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> L = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(isSelfDividing(i)) L.add(i);
        }
        return L;
    }

    public boolean isSelfDividing(int num){
        int val = num;
        while(num != 0){
            int digit = num % 10;
            if(digit == 0) return false;
            if(val % digit != 0) return false;
            num = num / 10;
        }
        return true;
    }

    public static void main(String args[]){
        new SelfDividingNumbers().selfDividingNumbers(1, 22);
    }
}
