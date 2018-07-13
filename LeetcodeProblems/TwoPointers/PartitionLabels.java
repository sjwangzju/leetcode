package TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 07/13/2018.
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible
 * so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 *
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> L = new ArrayList<>();
        int[] index = new int[26];

        /**Record the last index of each letter*/
        for(int i = 0; i < S.length(); i ++){
            index[S.charAt(i) - 'a'] = i;
        }
        /**Record the end of the current substring*/
        int start = 0, last = 0;
        for(int i = 0; i < S.length(); i ++){
            last = Math.max(last, index[S.charAt(i) - 'a']);
            if(last == i){
                L.add(last - start + 1);
                start = last + 1;
            }
        }
        return L;
    }

    public static void main(String args[]){
        String s = "";
        System.out.println(new PartitionLabels().partitionLabels(s));
    }
}
