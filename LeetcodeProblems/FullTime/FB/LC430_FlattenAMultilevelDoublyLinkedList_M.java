package FullTime.FB;

/**
 * DFS
 *
 * time: O(N)
 * space: O(K), K is max depth of child or next
 */
public class LC430_FlattenAMultilevelDoublyLinkedList_M {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    Node cur;
    public Node flatten(Node head) {
        if (head == null) return null;
        Node dummy = new Node();
        dummy.next = head;
        cur = head;
        dfs();
        return dummy.next;
    }

    public void dfs() {
        Node next = cur.next;
        Node child = cur.child;
        if (next == null && child == null) return;
        if (child != null) {
            cur.next = child;
            child.prev = cur;
            cur.child = null;
            cur = cur.next;
            dfs();
        }
        if (next != null) {
            cur.next = next;
            next.prev = cur;
            cur = cur.next;
            dfs();
        }
    }

}
