package FullTime.Amazon.OA;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    public Node copyRandomList(Node head) {
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
}
