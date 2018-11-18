package Twitter;

public class MissingWords {
    public String[] missingWords(String s, String t) {
        String[] ss = s.split(" ");
        String[] tt = t.split(" ");
        String[] ret = new String[ss.length - tt.length];
        int pos = 0, tmp = 0;
        for (String str: ss) {
            if (pos < tt.length && str.equals(tt[pos])) {
                pos++;
            } else {
                ret[tmp++] = str;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "I am using HackerRank to improve programming";
        String t = "am HackerRank to improve";
        String[] str = new MissingWords().missingWords(s, t);
        for (String string: str) {
            System.out.println(string);
        }
    }
}
