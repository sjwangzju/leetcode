package String;

/**
 * Created by sjwang on 04/05/2018.
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        char[] chs = s.toCharArray();
        int A = 0, count = 0;
        char last = ' ';
        for(char ch : chs){
            if(ch == 'A') A ++;
            if(ch == 'L') {
                if(last == 'L') count ++;
                else count = 1;
            }
            else count = 0;
            if(A > 1 || count > 2) return false;
            last = ch;
        }
        return true;
    }

    public static void main(String args[]){
        String str = "LLPLL";
        System.out.println(new StudentAttendanceRecordI().checkRecord(str));
    }
}
