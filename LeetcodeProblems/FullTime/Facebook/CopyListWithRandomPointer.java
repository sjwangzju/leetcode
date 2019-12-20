package FullTime.Facebook;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    // A linked list is given such that each node contains an additional random pointer
    // which could point to any node in the list or null. Return a deep copy of the list.
    //
    // Solution1: HashMap - store copied nodes in the map
    //
    // time: O(N), space: O(N)
    //
    public Node copyRandomListI(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val, null, null));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node tmp = map.get(cur);
            tmp.next = map.get(cur.next);
            tmp.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    // Solution2:
    // 1. copy nodes iteratively: A->A'->B->B'->C->C'
    // 2. split A->A'->B->B'->C->C'
    //    A->B->C & A'->B'->C'
    //
    // time: O(N), space: O(1)
    /*********************************************************/
    public Node copyRandomListII(Node head) {
        if (head == null) return null;

        // insert copied nodes: A->A'->B->B'->C->C'
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val, null, null);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }

        // copy random pointers
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null? null: cur.random.next;
            cur = cur.next.next;
        }

        // split A->A'->B->B'->C->C'
        // A->B->C & A'->B'->C'
        Node oldList = head, newList = head.next;
        Node res = head.next;
        while (oldList != null) {
            oldList.next = oldList.next.next;
            newList.next = newList.next == null? null: newList.next.next;
            oldList = oldList.next;
            newList = newList.next;
        }
        return res;
    }

}
