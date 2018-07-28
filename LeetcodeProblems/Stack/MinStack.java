package Stack;

import java.util.Stack;

/**
 * Created by sjwang on 07/28/2018.
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {
    private Stack<Integer> S;
    private Stack<Integer> M;
    public MinStack() {
        S = new Stack<>();
        M = new Stack<>();
    }
    public void push(int x) {
        S.push(x);
        if(M.isEmpty()) M.push(x);
        else {
            int min = M.peek();
            if(x <= min) M.push(x);
        }
    }

    public void pop() {
        int n = S.pop();
        if(n == M.peek()) M.pop();
    }

    public int top() {
        return S.peek();
    }

    public int getMin() {
        return M.peek();
    }
    public static void main(String args[]){
        MinStack ms = new MinStack();
        ms.push(-2); ms.push(0); ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());
    }
}
