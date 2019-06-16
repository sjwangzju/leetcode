package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

/**
 * double linked list
 *
 * time: O(1)
 * space: O(N), N is the capacity
 */
public class LC146_LRUCache_M {

    public static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    static class LRUCache {
        int capacity;
        Node head;
        Node tail;
        Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            this.head.next = tail;
            this.map = new HashMap<>();
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addNode(Node node) {
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                Node node = new Node(key, value);
                map.put(key, node);
                addNode(node);
                if (map.size() > capacity) {
                    Node tmp = tail.prev;
                    removeNode(tmp);
                    map.remove(tmp.key);
                }
            } else {
                Node tmp = map.get(key);
                tmp.val = value;
                removeNode(tmp);
                addNode(tmp);
                map.put(key, tmp);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
