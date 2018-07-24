package BinarySearch;

import java.util.Random;

/**
 * Created by sjwang on 07/24/2018.
 *
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 *
 * Example:
 * n = 10, I pick 6.
 * Return 6.
 */
public class GuessNumberHigherOrLower extends GuessGame{
    public int guessNumber(int n) {
        int i = new Random().nextInt(n) + 1;
        new GuessGame();
        target = i;
        int lo = 1, hi = n;
        while(lo <= hi){
            int mid = lo + (lo - hi) / 2;
            if(guess(mid) == 0) return mid;
            else if(guess(mid) == -1) hi = mid - 1;
            else lo = mid + 1;
        }
        return 0;
    }
    public static void main(String args[]){
        System.out.println(new GuessNumberHigherOrLower().guessNumber(10));
    }
}
