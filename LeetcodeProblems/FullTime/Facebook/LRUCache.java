package FullTime.Facebook;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache.
     * It should support the following operations: get and put.
     */
    public class Node {
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
    Map<Integer, Node> map;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeNode(node);
        insertNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            tmp.val = value;
            removeNode(tmp);
            insertNode(tmp);
        } else {
            Node tmp = new Node(key, value);
            insertNode(tmp);
            map.put(key, tmp);
            if (map.size() > capacity) {
                Node n = tail.prev;
                removeNode(n);
                map.remove(n.key);
            }
        }
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // insert to head
    public void insertNode(Node node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }
}
