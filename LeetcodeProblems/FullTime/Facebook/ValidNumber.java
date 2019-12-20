package FullTime.Facebook;

public class ValidNumber {

    // Validate if a given string can be interpreted as a decimal number.
    // contains:
    //  Numbers 0-9
    //  Exponent - "e"
    //  Positive/negative sign - "+"/"-"
    //  Decimal point - "."
    //
    //
    // Thoughts:
    // 1. set some boolean variables as flags - numberSeen, eSeen, dotSeen
    // 2. logic:
    //    a. invalid 'e'         -> eSeen || !numberSeen
    //    b. invalid '.'         -> dotSeen || eSeen
    //    c. invalid '+' / '-'   -> i != 0 && s.charAt(i - 1) != 'e'
    //    d. any other char is invalid
    // 3. return numberSeen
    //
    // time: O(N), space: O(1)
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean eSeen = false;
        boolean dotSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numberSeen = true;
            }
            else if (c == 'e') {
                if (eSeen || !numberSeen) return false;
                eSeen = true;
                // must have some number after 'e'
                numberSeen = false;
            }
            else if (c == '.') {
                if (dotSeen || eSeen) return false;
                dotSeen = true;
            }
            else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            }
            else {
                return false;
            }
        }
        return numberSeen;
    }
}
