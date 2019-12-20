package FullTime.OCI;

public class IntersectionOfTwoLinkedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Write a program to find the node at which the intersection of two singly linked lists begins.
    //
    // Solution1:
    // 1. two pointers
    // 2. In the first iteration, reset the pointer of one linkedlist to the head of another linkedlist after it reaches the tail node.
    //    In the second iteration, move two pointers until they points to the same node.
    //
    // time: O(M+N), space: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA, p2 = headB;

        while (p1 != p2) {
            p1 = p1 == null? headB: p1.next;
            p2 = p2 == null? headA: p2.next;
        }
        return p1;
    }

    // Solution2:
    // 1. get the len of two lists
    // time: O(M+N), space: O(1)
    public ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
        ListNode tmp1 = headA, tmp2 = headB;
        int l1 = getLen(tmp1), l2 = getLen(tmp2);

        if (l1 > l2) return getIntersectionNodeII(headB, headA);

        int diff = l2 - l1;
        for (int i = 0; i < diff; i++) {
            headB = headB.next;
        }
        while (headB != headA) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public int getLen(ListNode tmp) {
        int l = 0;
        while (tmp != null) {
            l++;
            tmp = tmp.next;
        }
        return l;
    }
}
