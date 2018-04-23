package String;

/**
 * Created by sjwang on 23/04/2018.
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 *
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 *
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 */

public class JudgeRouteCircle {

    public boolean judgeCircle(String moves) {
        int sum_ver = 0;
        int sum_hor = 0;
        for(int i = 0; i < moves.length(); i++){
            char ch = moves.charAt(i);
            if(ch == 'U') sum_ver ++;
            if(ch == 'D') sum_ver --;
            if(ch == 'R') sum_hor ++;
            if(ch == 'L') sum_hor --;
        }
        return (sum_hor == 0 && sum_ver == 0);
    }

    public boolean judgeCirclee(String moves) {
        int value = 0;
        for(int i = 0; i < moves.length(); i++){
            value = value ^ moves.charAt(i);
        }
        if(value == 0) return true;
        return false;
    }

    public static void main(String args[]){
        String str = "UDUDLR";
        System.out.println(new JudgeRouteCircle().judgeCirclee(str));
    }
}
