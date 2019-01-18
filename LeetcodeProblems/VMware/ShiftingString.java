package VMware;

public class ShiftingString {

    public String getShiftedString(String s, int leftShifts, int rightShifts) {
        int len = s.length();

        while (rightShifts >= len) {
            rightShifts -= len;
        }
        int totalShifts = leftShifts + len - rightShifts;
        while (totalShifts >= len) {
            totalShifts -= len;
        }

        return shift(s, totalShifts);
    }

    public String shift(String s, int shifts) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = i + shifts;
            if (index >= s.length()) index -= s.length();
            res.append(s.charAt(index));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int leftShifts = 0;
        int rightShifts = 80;
        System.out.println(new ShiftingString().getShiftedString(s, leftShifts, rightShifts));
    }
}
