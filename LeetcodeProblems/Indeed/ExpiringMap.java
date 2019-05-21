package Indeed;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ExpiringMap extends Thread {

    public static class Node {
        int key;
        int value;
        long expireTime;

        public Node(int key, int value, long duration) {
            this.key = key;
            this.value = value;
            this.expireTime = System.currentTimeMillis() + duration;
        }
    }

//    Map<Integer, Node> map = new HashMap<>();
//
//    public void put(int key, int value, long duration) {
//        map.put(key, new Node(key, value, duration));
//    }
//
//    public Integer get(int key) {
//        long curTime = System.currentTimeMillis();
//        if (!map.containsKey(key)) return null;
//        if (map.get(key).expireTime <= curTime) {
//            map.remove(key);
//            return null;
//        }
//        return map.get(key).value;
//    }


    Map<Integer, Node> map = new HashMap<>();
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (Long.compare(a.expireTime, b.expireTime)));

    @Override
    public void run() {
        removeInvalid();
    }

    public void removeInvalid() {
        long curTime = System.currentTimeMillis();
        while (!pq.isEmpty() && pq.peek().expireTime <= curTime) {
            Node tmp = pq.peek();
            pq.poll();
            map.remove(tmp.key);
        }
    }

    public void put(int key, int value, long duration) {
        removeInvalid();
        Node n = new Node(key, value, duration);
        map.put(key, n);
        pq.offer(n);
    }

    public Integer get(int key) {
        removeInvalid();
        if (!map.containsKey(key)) return null;
        return map.get(key).value;
    }


    public static void main(String[] args) throws InterruptedException {
        ExpiringMap map = new ExpiringMap();
        map.put(5,10, 5000);
        System.out.println(map.get(5));
        Thread.sleep(1000);
        System.out.println(map.get(5));
        Thread.sleep(4100);
        System.out.println(map.get(5));
    }
}
