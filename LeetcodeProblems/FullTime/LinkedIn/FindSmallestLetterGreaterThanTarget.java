package FullTime.LinkedIn;

public class FindSmallestLetterGreaterThanTarget {

    // Given a list of sorted characters letters containing only lowercase letters,
    // and given a target letter target, find the smallest element in the list that is larger than the given target.
    //
    // Input:
    // letters = ["c", "f", "j"]
    // target = "a"
    // Output: "c"
    //
    // binary search
    // time: O(logN), space: O(1)
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo == letters.length? letters[0]: letters[lo];
    }
}
