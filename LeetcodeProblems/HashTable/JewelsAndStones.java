package HashTable;
import java.util.Hashtable;

/**
 * Created by sjwang on 04/24/2018.
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        Hashtable tab = new Hashtable();
        char[] jewels = J.toCharArray();
        for(char ch : jewels){
            tab.put(ch, 1);
        }
        int sum = 0;
        char[] stones = S.toCharArray();
        for(char ch : stones){
            if(tab.containsKey(ch)) sum ++;
        }
        return sum;
    }

    public static void main(String args[]){
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(new JewelsAndStones().numJewelsInStones(J, S));
    }

}
