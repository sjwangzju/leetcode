package FullTime.OCI;

import java.util.Stack;

public class ImplementQueueUsingStack {

    // Thoughts:
    // 1. two stacks
    //
    // time: push O(N), pop O(1), peek O(1), empty O(1)
    // space: O(N)
    class MyQueue {

        Stack<Integer> s1, s2;

        /** Initialize your data structure here. */
        public MyQueue() {
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return s1.pop();
        }

        /** Get the front element. */
        public int peek() {
            return s1.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty();
        }
    }
}
