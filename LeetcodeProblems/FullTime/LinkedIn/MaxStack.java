package FullTime.LinkedIn;

import java.util.Stack;

public class MaxStack {

    /**
     * Design a max stack that supports push, pop, top, peekMax and popMax.
     *
     * push(x)  -- Push element x onto stack.
     * pop()    -- Remove the element on top of the stack and return it.
     * top()    -- Get the element on the top.
     * peekMax()-- Retrieve the maximum element in the stack.
     * popMax() -- Retrieve the maximum element in the stack, and remove it.
     *             If you find more than one maximum elements, only remove the top-most one.
     *
     * Thoughts:
     * 1. Two stacks (one record the order, one record the max number till now)
     *
     */
    Stack<Integer> s1;
    Stack<Integer> s2;

    /** initialize your data structure here. */
    public MaxStack() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    // time: O(1)
    public void push(int x) {
        s1.push(x);
        int max = s2.isEmpty()? x: Math.max(x, s2.peek());
        s2.push(max);
    }

    // time: O(1)
    public int pop() {
        s2.pop();
        return s1.pop();
    }

    // time: O(1)
    public int top() {
        return s1.peek();
    }

    // time: O(1)
    public int peekMax() {
        return s2.peek();
    }

    // time: O(N)
    public int popMax() {
        int max = s2.peek();
        Stack<Integer> tmp = new Stack<>();
        while (top() != max) {
            tmp.push(pop());
        }
        pop();
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return max;
    }

}
