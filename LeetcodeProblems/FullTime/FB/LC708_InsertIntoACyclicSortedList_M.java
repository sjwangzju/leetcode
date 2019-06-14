package FullTime.FB;

/**
 * Iterate through the list (!corner case)
 *
 * time: O(N)
 * space: O(1)
 */
public class LC708_InsertIntoACyclicSortedList_M {

    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        Node cur = head;
        while (cur.next != head) {
            if (insertVal >= cur.val && insertVal <= cur.next.val
                    || cur.next.val < cur.val && (insertVal > cur.val || insertVal < cur.next.val)) {
                break;
            }
            cur = cur.next;
        }
        Node node = new Node(insertVal, cur.next);
        cur.next = node;
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(4, null);
        Node n2 = new Node(3, n1);
        Node n3 = new Node(1, n2);
        n1.next = n3;
        Node node = new LC708_InsertIntoACyclicSortedList_M().insert(n2, 2);
        System.out.println(node.val);
    }
}
