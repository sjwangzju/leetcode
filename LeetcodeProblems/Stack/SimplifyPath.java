package Stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by sjwang on 07/30/2018.
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String re = "";
        for(String str : path.split("/")) {
            if(str.equals("..") && !stack.isEmpty()) stack.pop();
            if(!str.equals(".") && !str.equals("..") && !str.equals("")) stack.push(str);
        }
        while(!stack.isEmpty()) {
            re = "/" + stack.pop() + re;
        }
        return re.equals("") ? "/" : re;
    }
    public static void main(String args[]){
        String str = "/home//foo/";
        System.out.println(new SimplifyPath().simplifyPath(str));
    }
}
