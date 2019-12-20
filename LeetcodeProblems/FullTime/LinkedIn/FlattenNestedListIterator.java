package FullTime.LinkedIn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {

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
     * Given a nested list of integers, implement an iterator to flatten it.
     *
     * Input: [1,[4,[6]]]
     * Output: [1,4,6]
     * Explanation: By calling next repeatedly until hasNext returns false,
     *              the order of elements returned by next should be: [1,4,6].
     */
    public class NestedIterator implements Iterator<Integer> {

        List<Integer> list;
        int i;
        public NestedIterator(List<NestedInteger> nestedList) {
            this.i = 0;
            this.list = new ArrayList<>();
            dfs(nestedList);
        }

        public void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger n: nestedList) {
                if (n.isInteger()) {
                    list.add(n.getInteger());
                } else {
                    dfs(n.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(i++);
        }

        @Override
        public boolean hasNext() {
            return i < list.size();
        }
    }

}
