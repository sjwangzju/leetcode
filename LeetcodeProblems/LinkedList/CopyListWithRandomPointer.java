package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjwang on 07/22/2018.
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> M = new HashMap<>();
        RandomListNode N = head;
        while(N != null){
            M.put(N, new RandomListNode(N.label));
            N = N.next;
        }
        N = head;
        while(N != null){
            M.get(N).next = M.get(N.next);
            M.get(N).random = M.get(N.random);
            N = N.next;
        }
        return M.get(head);
    }
    public static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
    public static void main(String args[]){
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        r1.next = r2; r1.random = r3;
        r2.next = r3; r2.random = r4;
        r3.next = r4; r3.random = r1;
        r4.next = null; r4.random = r2;
        System.out.println(new CopyListWithRandomPointer().copyRandomList(r1));
    }
}
