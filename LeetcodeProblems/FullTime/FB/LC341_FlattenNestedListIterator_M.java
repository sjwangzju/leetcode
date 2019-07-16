package FullTime.FB;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Queue + recursion
 *
 * time: O(N)
 * space: O(N)
 */
public class LC341_FlattenNestedListIterator_M {

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

    public class NestedIterator implements Iterator<Integer> {

         Queue<Integer> q;
         public NestedIterator(List<NestedInteger> nestedList) {
            this.q = new LinkedList<>();
            for (NestedInteger n: nestedList) {
                getAll(n);
            }
         }

         @Override
         public Integer next() {
             return q.poll();
         }

         @Override
         public boolean hasNext() {
             return !q.isEmpty();
         }

         public void getAll(NestedInteger n) {
             if (n.isInteger()) {
                 q.offer(n.getInteger());
                 return;
             }
             for (NestedInteger nest: n.getList()) {
                 getAll(nest);
             }
         }
    }
}
