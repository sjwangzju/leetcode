package FullTime.FB;

import java.util.List;

/**
 * Recursion
 *
 * time: O(N)
 * space: O(L), L is the deepest level
 */
public class LC339_NestedListWeightSum_E {

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        for (NestedInteger n: nestedList) {
            add(n, 1);
        }
        return sum;
    }

    public void add(NestedInteger n, int level) {
        if (n.isInteger()) {
            sum += n.getInteger() * level;
        } else {
            for (NestedInteger nest: n.getList()) {
                add(nest, level + 1);
            }
        }
    }
}
