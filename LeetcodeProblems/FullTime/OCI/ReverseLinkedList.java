package FullTime.OCI;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Reverse a singly linked list.
    //
    // Example:
    // Input: 1->2->3->4->5->NULL
    // Output: 5->4->3->2->1->NULL
    //
    // Solution1: iterative
    // time: O(N), space: O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0), cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = tmp;
        }
        return dummy.next;
    }

    // Solution2: Recursive
    // time: O(N), space: O(N)
    public ListNode reverseListII(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }
}
