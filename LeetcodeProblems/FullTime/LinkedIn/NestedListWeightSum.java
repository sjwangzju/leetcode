package FullTime.LinkedIn;

import java.util.List;


public class NestedListWeightSum {

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
     * Nested List Weight Sum II
     *
     * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
     *
     * Input: [1,[4,[6]]]
     * Output: 27
     * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
     *
     * Thoughts:
     * 1. calculate sum recursively
     *
     * time: O(N), N is num of integers
     * space: O(K), K is the max depth
     */

    int res = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        getSum(nestedList, 1);
        return res;
    }

    public void getSum(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger n: nestedList) {
            if (n.isInteger()) {
                res += n.getInteger() * depth;
            } else {
                getSum(n.getList(), depth + 1);
            }
        }
    }


    /**
     * Nested List Weight Sum II
     *
     * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
     * the leaf level integers have weight 1,
     * and the root level integers have the largest weight.
     *
     * Input: [1,[4,[6]]]
     * Output: 17
     * Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
     *
     * Thoughts:
     * 1. get max depth
     * 2. calculate sum recursively
     *
     * time: O(N), N is num of integers
     * space: O(K), K is the max depth
     */

    int sum = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        getSumII(nestedList, getDepth(nestedList));
        return sum;
    }

    // calculate sum recursively
    public void getSumII(List<NestedInteger> nestedList, int cur) {
        for (NestedInteger n: nestedList) {
            if (n.isInteger()) {
                sum += cur * n.getInteger();
            } else {
                getSumII(n.getList(), cur - 1);
            }
        }
    }

    // get max depth
    public int getDepth(List<NestedInteger> nestedList) {
        int res = 1;
        for (NestedInteger n: nestedList) {
            if (n.isInteger()) continue;
            int depth = 1 + getDepth(n.getList());
            res = Math.max(res, depth);
        }
        return res;
    }
}
