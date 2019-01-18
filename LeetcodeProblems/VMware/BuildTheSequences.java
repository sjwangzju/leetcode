package VMware;

import java.util.PriorityQueue;

public class BuildTheSequences {

    public String[] buildSubsequences(String s) {
        int len = (int)Math.pow(2, s.length()) - 1;
        String[] res = new String[len];
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> a.compareTo(b));

        build(pq, s, 0, new StringBuilder());
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }

    public void build(PriorityQueue pq, String s, int start, StringBuilder cur) {

        for (int i = start; i < s.length(); i++) {
            cur.append(s.charAt(i));
            pq.offer(cur.toString());
            build(pq, s, i + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "ysx";
        String[] res = new BuildTheSequences().buildSubsequences(s);
        for(String ss: res) {
            System.out.println(ss);
        }
    }
}
