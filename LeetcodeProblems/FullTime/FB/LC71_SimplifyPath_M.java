package FullTime.FB;

import java.util.Stack;

/**
 *  Stack
 *
 *  time: O(N)
 *  space: O(N)
 */
public class LC71_SimplifyPath_M {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "";
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String dir: dirs) {
            if (dir.length() > 0) {
                if (dir.equals(".")) {
                    continue;
                }
                if (dir.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(dir);
                }
            }
        }
        if (stack.isEmpty()) return "/";

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
            res.insert(0, "/");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(new LC71_SimplifyPath_M().simplifyPath(path));
    }
}
