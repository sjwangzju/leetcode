package FullTime.Facebook;

public class ReorderList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    // reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
    //
    // Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
    //
    // Thoughts:
    // 1. find the middle of the list
    // 2. reverse the second half
    // 3. integrate the two halves

    // time: O(N), space: O(1)
    public void reorderList(ListNode head) {
        if (head == null) return;

        // head->1->2->3->4->5
        // find the middle of the list (3)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // (head)->1->2, (head2)->5->4->3
        // reverse the second half
        ListNode mid = slow;
        ListNode head2 = reverse(mid);

        // head->1->5->2->4->3
        // integrate first and second halves
        while (head2.next != null) {
            ListNode n2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head2 = n2;
            head = head.next.next;
        }
    }

    // reverse linked list
    public ListNode reverse(ListNode node) {
        ListNode dummy = new ListNode(0);
        while (node != null) {
            ListNode tmp = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = tmp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2; n2.next = n3;
        n3.next = n4; n4.next = n5;
        new ReorderList().reorderList(n1);
    }
}
