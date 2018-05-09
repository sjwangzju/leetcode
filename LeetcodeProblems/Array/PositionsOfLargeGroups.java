package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 09/05/2018.
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 *
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 *
 *
 * Note:  1 <= S.length <= 1000
 */

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        ArrayList<ArrayList<Integer>> L = new ArrayList<>();
        char last = ' '; int start = 0, end = 0;
        for(int i = 0; i < S.length(); i ++){
            if(S.charAt(i) != last){
                if(end - start > 1){
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(start); a.add(end);
                    L.add(a);
                }
                last = S.charAt(i);
                start = i;
                end = i;
            }
            else{
                end ++;
                if(i == S.length() - 1 && end - start > 1){
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(start); a.add(end);
                    L.add(a);
                }
            }
        }
        return (List) L;
    }

    public static void main(String args[]){
        String str = "abcddddeee";
        System.out.println(new PositionsOfLargeGroups().largeGroupPositions(str));
    }

}
