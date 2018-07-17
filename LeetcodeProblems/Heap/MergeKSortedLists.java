package Heap;

import java.util.*;

/**
 * Created by sjwang on 07/17/2018.
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> al = new ArrayList<>();
        for(ListNode ln : lists){
            while(ln != null){
                al.add(ln.val);
                ln = ln.next;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int num : al) pq.offer(num);
        if(pq.isEmpty()) return null;
        ListNode n = new ListNode(pq.poll());
        ListNode cur = n;
        while(!pq.isEmpty()){
            ListNode temp = new ListNode(pq.poll());
            temp.next = null;
            cur.next = temp;
            cur = cur.next;
        }
        return n;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public static void main(String args[]){
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(3);
        lists[1] = new ListNode(1);
        lists[2] = new ListNode(2);
        ListNode re = new MergeKSortedLists().mergeKLists(lists);
        while(re != null){
            System.out.println(re.val);
            re = re.next;
        }
    }
}
