package FullTime.LinkedIn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {

    // Write a function to find all the 10-letter-long sequences (substrings)
    // that occur more than once in a DNA molecule.
    //
    // Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    // Output: ["AAAAACCCCC", "CCCCCAAAAA"]
    //
    // time: O(N*L), space: O(N)
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();

        Set<String> set = new HashSet<>(), res = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String tmp = s.substring(i, i + 10);
            if (set.contains(tmp)) {
                res.add(tmp);
            } else {
                set.add(tmp);
            }
        }
        return new ArrayList<>(res);
    }
}
