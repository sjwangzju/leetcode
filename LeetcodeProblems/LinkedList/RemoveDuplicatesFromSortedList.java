package LinkedList;

/**
 * Created by sjwang on 04/22/2018.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */

public class RemoveDuplicatesFromSortedList {

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
    public ListNode deleteDuplicatesIteratively(ListNode head) {
        ListNode L = head;
        if(head == null) return head;
        while(head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }
            else{
                head = head.next;
            }
        }
        return L;
    }

    /**
     * Recursively
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesRecursively(ListNode head) {
        if(head == null) return null;
        while(head.next != null && head.val == head.next.val) {
            head.next = head.next.next;
        }
        head.next = deleteDuplicatesRecursively(head.next);
        return head;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        l1.next = null;
        l2.next = l1;
        l3.next = l2;
        new RemoveDuplicatesFromSortedList().deleteDuplicatesRecursively(l3);
        new RemoveDuplicatesFromSortedList().deleteDuplicatesIteratively(l3);
    }

}
