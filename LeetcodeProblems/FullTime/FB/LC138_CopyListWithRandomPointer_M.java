package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

public class LC138_CopyListWithRandomPointer_M {

    static class Node {
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

    // Solution1: HashMap<Node, Node>, connect original node with its copy
    // time: O(N)
    // space: O(N)
    Map<Node, Node> map;
    public Node copyRandomListI(Node head) {
        if (head == null) return null;

        map = new HashMap<>();
        Node cur = head;
        Node tmp = new Node(cur.val, null, null);
        map.put(cur, tmp);

        while (cur != null) {
            tmp.next = cloneNode(cur.next);
            tmp.random = cloneNode(cur.random);
            cur = cur.next;
            tmp = tmp.next;
        }
        return map.get(head);
    }

    public Node cloneNode(Node node) {
        if (node == null) return null;
        if (!map.containsKey(node)) {
            map.put(node, new Node(node.val, null, null));
        }
        return map.get(node);
    }

    
    
    // Solution2: A->B->C  A->A'->B->B'->C->C'
    // time: O(N)
    // space: O(1)
    public Node copyRandomListII(Node head) {
        if (head == null) return null;
        // copy next
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val, null, null);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        
        // copy random
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null? null: cur.random.next;
            cur = cur.next.next;
        }
        
        // detach old and new list
        // A->A'->B->B'->C->C' => A->B->C, A'->B'->C'
        Node i = head;
        Node j = head.next;
        Node res = head.next;
        
        while (i != null) {
            i.next = i.next.next;
            j.next = (j.next == null)? null: j.next.next;
            i = i.next;
            j = j.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n2 = new Node(2, null, null);
        n1.next = n2;
        n1.random = n2;
        n2.next = null;
        n2.random = n2;
        Node res = new LC138_CopyListWithRandomPointer_M().copyRandomListII(n1);
        System.out.println(res.val);
    }
}
