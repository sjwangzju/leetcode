package LinkedList;

/**
 * Created by sjwang on 22/04/2018.
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     *Iteratively
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsIteratively(ListNode l1, ListNode l2) {
        ListNode N = new ListNode(0);
        N.next = null;
        ListNode P = N;
        while(l1 != null && l2 != null){
            int temp;
            ListNode L;
            if(l1.val != l2.val){
                if(l1.val < l2.val){
                    temp = l1.val;
                    l1 = l1.next;
                }
                else{
                    temp = l2.val;
                    l2 = l2.next;
                }
                L = new ListNode(temp);
                L.next = null;
            }
            else{
                temp = l1.val;
                l1 = l1.next;
                L = new ListNode(temp);
                L.next = new ListNode(temp);
                L.next.next = null;
            }
            N.next = L;
            N = N.next;
        }
        if(l1 == null){
            N.next = l2;
            return P.next;
        }
        N.next = l1;
        return P.next;
    }

    /**
     * Recursively
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsRecursively(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = mergeTwoListsRecursively(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoListsRecursively(l1, l2.next);
        return l2;
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(0);
        l1.next = null;
        l2.next = l1;
        l3.next = l2;

        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(0);
        l4.next = null;
        l5.next = l4;
        l6.next = l5;
        new MergeTwoSortedLists().mergeTwoListsRecursively(l3, l6);
        new MergeTwoSortedLists().mergeTwoListsIteratively(l3, l6);
    }
}
