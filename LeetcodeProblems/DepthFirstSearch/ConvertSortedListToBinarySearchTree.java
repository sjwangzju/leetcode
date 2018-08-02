package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 08/02/2018.
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 * Given the sorted linked list: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<Integer> L = new ArrayList<>();
        while(head != null) {
            L.add(head.val);
            head = head.next;
        }
        return constructTree(L, 0, L.size() - 1);
    }
    public TreeNode constructTree(List<Integer> L, int lo, int hi) {
        if(lo > hi || lo < 0 || hi >= L.size()) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode t = new TreeNode(L.get(mid));
        t.left = constructTree(L, lo, mid - 1);
        t.right = constructTree(L, mid + 1, hi);
        return t;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String args[]){
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        System.out.println(new ConvertSortedListToBinarySearchTree().sortedListToBST(n1));
    }
}
