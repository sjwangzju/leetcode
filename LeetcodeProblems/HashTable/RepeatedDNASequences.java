package HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sjwang on 07/31/2018.
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> S = new HashSet<>();
        List<String> L = new ArrayList<>();
        for(int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if(S.contains(str) && !L.contains(str)) L.add(str);
            else S.add(str);
        }
        return L;
    }
    public static void main(String args[]){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences(s));
    }
}
