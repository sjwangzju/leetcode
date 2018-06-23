package LinkedList;

/**
 * Created by sjwang on 04/22/2018.
 * Reverse a singly linked list iteratively or recursively.
 */

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Iteratively
     * @param head
     * @return
     */
    public ListNode reverseListIteratively(ListNode head) {
        ListNode cur = head;
        ListNode temp = null;
        while(cur != null){
            ListNode L = new ListNode(cur.val);
            L.next = temp;
            temp = L;
            cur = cur.next;
        }
        return temp;
    }

    /**
     * Recursively
     * @param head
     * @return
     */
    public ListNode reverseListRecursively(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode L = new ReverseLinkedList().reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return L;
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = null;
        l2.next = l1;
        l3.next = l2;
        new ReverseLinkedList().reverseListRecursively(l3);
        new ReverseLinkedList().reverseListIteratively(l3);
    }

}
