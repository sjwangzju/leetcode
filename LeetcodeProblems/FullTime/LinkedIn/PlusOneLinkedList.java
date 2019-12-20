package FullTime.LinkedIn;

public class PlusOneLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    // Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
    //
    // Input: [1,2,3]
    // Output: [1,2,4]
    //
    // recursive
    // time: O(N), space: O(N)
    public ListNode plusOne(ListNode head) {
        int carry = getCarry(head);
        if (carry == 1) {
            ListNode tmp = new ListNode(1);
            tmp.next = head;
            return tmp;
        }
        return head;
    }

    public int getCarry(ListNode node) {
        if (node == null) return 1;
        int carry = getCarry(node.next);
        node.val += carry;
        carry = node.val/10;
        node.val %= 10;
        return carry;
    }
}
