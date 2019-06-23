package FullTime.FB;

/**
 * two pointers
 *
 * time: O(N), N is len of abbr
 * space: O(1)
 */
public class LC408_ValidWordAbbreviation_E {

    public boolean validWordAbbreviation(String word, String abbr) {
        if (abbr.length() > word.length()) return false;

        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char cur = abbr.charAt(j);

            if (cur == word.charAt(i)) {
                i++;
                j++;
                continue;
            }

            if (Character.isDigit(cur) && cur != '0') {
                int start = j;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                i += Integer.parseInt(abbr.substring(start, j));
                continue;
            }

            return false;
        }
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        String word = "hi";
        String abbr = "2i";
        System.out.println(new LC408_ValidWordAbbreviation_E().validWordAbbreviation(word, abbr));
    }
}
