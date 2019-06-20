package FullTime.FB;

import java.util.Stack;

public class LC143_ReorderList_M {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        int size = stack.size();
        cur = head;
        while (stack.size() >  Math.ceil((double)size/2)) {
            ListNode node = stack.pop();
            ListNode tmp = cur.next;
            node.next = null;
            cur.next = node;
            node.next = tmp;
            cur = tmp;
        }
        if (cur != null) {
            cur.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        new LC143_ReorderList_M().reorderList(n1);
        System.out.println(n1.val);
    }

}
