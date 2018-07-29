package Stack;

import java.util.Stack;

/**
 * Created by sjwang on 07/29/2018.
 *
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 * Example:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 *
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue),
 * as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueUsingStacks {

    public static class MyQueue {
        Stack<Integer> mq, temp;

        /** Initialize your data structure here. */
        public MyQueue() {
            mq = new Stack<>();
            temp = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            mq.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int n = peek();
            temp.pop();
            return n;
        }

        /** Get the front element. */
        public int peek() {
            if(temp.isEmpty()) {
                while(!mq.isEmpty()) temp.push(mq.pop());
            }
            return temp.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return mq.isEmpty() && temp.isEmpty();
        }
    }

    public static void main(String args[]){
        MyQueue mq = new MyQueue();
        mq.push(1); mq.push(2);
        System.out.println(mq.peek());
    }
}
