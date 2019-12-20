package FullTime.Facebook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class aaaNestedList {

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    /**
     * Flatten Nested List Iterator
     *
     * Input: [[1,1],2,[1,1]]
     * Output: [1,1,2,1,1]
     *
     * edge case: [[1,1],2,[]]
     *
     * Solution 1:
     * 1. add all integers into a list
     *
     * space: O(N)
     */
    public class NestedIterator implements Iterator<Integer> {

        // space: O(N)
        List<Integer> list;
        int i;
        public NestedIterator(List<NestedInteger> nestedList) {
            this.i = 0;
            this.list = new ArrayList<>();
            dfs(nestedList);
        }

        // time: O(N)
        public void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger n: nestedList) {
                if (n.isInteger()) {
                    list.add(n.getInteger());
                } else {
                    dfs(n.getList());
                }
            }
        }

        // time: O(1)
        @Override
        public Integer next() {
            return list.get(i++);
        }

        // time: O(1)
        @Override
        public boolean hasNext() {
            return i < list.size();
        }
    }


    /**
     * Flatten Nested List Iterator
     *
     * Solution 2:
     * 1. use stack
     * 2. while loop in hasNext() -> until the element at the top of stack is integer
     * 3. for loop starts from (size - 1)
     *
     */
    public class NestedIteratorII implements Iterator<Integer> {

        Stack<NestedInteger> stack;
        public NestedIteratorII(List<NestedInteger> nestedList) {
            this.stack = new Stack<>();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        // time: O(1)
        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        // time: O(1)
        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                NestedInteger cur = stack.peek();
                if (cur.isInteger()) {
                    return true;
                }
                List<NestedInteger> list = stack.pop().getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
            return false;
        }
    }



    /**
     * Nested List Weight Sum
     *
     * Input: [[1,1],2,[1,1]]
     * Output: 10
     * Explanation: Four 1's at depth 2, one 2 at depth 1.
     *
     * Thoughts:
     * 1. Recursion
     *
     * time: O(N), space: O(D), D is the max depth
     */
    int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        getSum(nestedList, 1);
        return sum;
    }

    public void getSum(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger n: nestedList) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                getSum(n.getList(), depth + 1);
            }
        }
    }


    /**
     * Nested List Weight Sum II
     *
     * Input: [[1,1],2,[1,1]]
     * Output: 8
     * Explanation: Four 1's at depth 1, one 2 at depth 2.
     *
     * Thoughts: Two Pass DFS solution
     * 1. get the max depth first
     * 2. Recursion
     *
     * time: O(N), space: O(D), D is the max depth
     */
    int sum2 = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getDepth(nestedList);
        getSumII(nestedList, maxDepth);
        return sum2;
    }

    public void getSumII(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger n: nestedList) {
            if (n.isInteger()) {
                sum2 += n.getInteger() * depth;
            } else {
                getSumII(n.getList(), depth - 1);
            }
        }
    }

    public int getDepth(List<NestedInteger> nestedList) {
        int max = 0;
        for (NestedInteger n: nestedList) {
            if (n.isInteger()) continue;
            max = Math.max(max, getDepth(n.getList()));
        }
        return 1 + max;
    }

}
