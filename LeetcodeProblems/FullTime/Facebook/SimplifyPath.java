package FullTime.Facebook;

import java.util.Stack;

public class SimplifyPath {

    // Given an absolute path for a file (Unix-style), simplify it.
    //
    // Input: "/a/./b/../../c/"
    // Output: "/c"
    //
    // stack
    // time: O(N), space: O(N)
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "";

        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");

        for (String s: strs) {
            if (s.length() == 0 || s.equals(".")) continue;
            else if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }
        return res.length() == 0? "/": res.toString();
    }
}
