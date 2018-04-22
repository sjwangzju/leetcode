package LinkedList;

/**
 * Created by sjwang on 22/04/2018.
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 */

public class IntersectionOfTwoLinkedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode A = headA;
        ListNode B = headB;
        ListNode AA = A;
        ListNode BB = B;

        while(A != null){
            lenA ++;
            A = A.next;
        }
        while(B != null){
            lenB ++;
            B = B.next;
        }

        int step = Math.abs(lenA - lenB);
        while(step > 0){
            if(lenA > lenB){
                AA = AA.next;
            }else{
                BB = BB.next;
            }
            step --;
        }
        while(AA != null){
            if(AA == BB) return AA;
            AA = AA.next;
            BB = BB.next;
        }
        return null;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);

        l1.next = null;
        l2.next = l1;
        l3.next = l2;
        l4.next = l3;
        l5.next = l2;

        new IntersectionOfTwoLinkedLists().getIntersectionNode(l5, l4);
    }

}
