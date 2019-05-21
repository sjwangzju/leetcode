package Indeed;

import java.util.List;
import java.util.Stack;

public class PythonValidation {

//    public boolean validate(String[] lines) {
//        Stack<String> stack = new Stack<>();
//
//        for (String line: lines) {
//            int curIndent = getIndent(line);
//
//            // rule1: the first line has no indent
//            if (stack.isEmpty()) {
//                if (curIndent != 0) return false;
//            }
//
//            else {
//                String lastLine = stack.peek();
//
//                // rule2: check if last line is control statement
//                if (lastLine.charAt(lastLine.length() - 1) == ':') {
//                    // rule3: the indent of line after control statement should increment 1
//                    if (curIndent != getIndent(lastLine) + 1) {
//                        return false;
//                    }
//                } else {
//                    while (!stack.isEmpty() && getIndent(stack.peek()) > curIndent) {
//                        stack.pop();
//                    }
//                    // rule4: lines in the same block should have same indent
//                    if (getIndent(stack.peek()) != curIndent) {
//                        return false;
//                    }
//                }
//            }
//            stack.push(line);
//        }
//
//        return true;
//    }
//
//    public int getIndent(String line) {
//        int cnt = 0;
//        for (int i = 0; i < line.length(); i++) {
//            if (line.charAt(i) == ' ') {
//                cnt++;
//            }
//        }
//        return cnt;
//    }



    public boolean validate(String[] lines) {

        Stack<String> stack = new Stack<>();

        for (String line: lines) {
            int curIndent = getIndent(line);

            if (stack.size() == 0) {
                if (curIndent != 0) {
                    return false;
                }
            } else {
                String last = stack.peek();
                if (last.charAt(last.length() - 1) == ':') {
                    if (curIndent != getIndent(last) + 1) {
                        return false;
                    }
                } else {
                    while (!stack.isEmpty() && getIndent(stack.peek()) > curIndent) {
                        stack.pop();
                    }
                    if (getIndent(stack.peek()) != curIndent) {
                        return false;
                    }
                }
            }
            stack.push(line);
        }

        return true;
    }

    public int getIndent(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') sum++;
            else break;
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] lines = {
                "def:",
                " abc:",
                "  b2c:",
                "   cc",
                "  b5c",
                "b6c"
        };
        System.out.println(new PythonValidation().validate(lines));
    }
}
