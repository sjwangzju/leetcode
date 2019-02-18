package Indeed;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ExpiringMap extends Thread {

    public class Node {
        public int key;
        public int value;
        public long expireTime;

        public Node(int key, int value, long duration) {
            this.key = key;
            this.value = value;
            this.expireTime = System.currentTimeMillis() + duration;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (Long.compare(a.expireTime, b.expireTime)));


    @Override
    public void run() {
        removeInvalid();
    }

    /**
     * time: O(klogN), k is the num of invalid elements removed
     */
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
        Node cur = new Node(key, value, duration);
        pq.offer(cur);
        map.put(key, cur);
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
        Thread.sleep(4900);
        System.out.println(map.get(5));
    }
}
