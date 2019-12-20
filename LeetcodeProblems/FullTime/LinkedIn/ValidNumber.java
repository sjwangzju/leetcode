package FullTime.LinkedIn;

public class ValidNumber {

    /**
     * Validate if a given string can be interpreted as a decimal number.
     *
     * Some examples:
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     *
     * characters that can be in a valid decimal number:
     * 1. Numbers 0-9
     * 2. Exponent "e"
     * 3. Positive/negative sign "+"/"-"
     * 4. Decimal point "."
     *
     *
     * Clarifying question:
     * 1. is ".5" valid? (if "." can appear at index 0)
     *
     * time: O(N), space: O(N)
     */
    public boolean isNumber(String s) {
        boolean numSeen = false, eSeen = false, dotSeen = false;

        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                numSeen = true;
            }
            else if (c == 'e') {
                if (eSeen || !numSeen) return false;
                eSeen = true;
                numSeen = false;
            }
            else if (c == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            }
            else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            }
            else {
                return false;
            }
        }
        return numSeen;
    }
}
