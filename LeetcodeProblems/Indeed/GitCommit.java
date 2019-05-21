package Indeed;

import java.util.*;

public class GitCommit {

    public static class GitNode{
        int id;
        List<GitNode> parent;

        public GitNode(int id) {
            this.id = id;
            this.parent = new LinkedList<>();
        }
    }

    public List<GitNode> findAllCommits(GitNode node) {
        List<GitNode> res = new LinkedList<>();
        Set<GitNode> visited = new HashSet<>();
        Queue<GitNode> queue = new LinkedList<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            GitNode cur = queue.poll();
            res.add(cur);

            List<GitNode> parent = cur.parent;
            for (GitNode n: parent) {
                if (!visited.contains(n)) {
                    queue.offer(n);
                }
            }
        }
        return res;
    }

    public GitNode findLCA(GitNode node1, GitNode node2) {
        Set<GitNode> s1 = new HashSet<>();
        Set<GitNode> s2 = new HashSet<>();
        Queue<GitNode> q1 = new LinkedList<>();
        Queue<GitNode> q2 = new LinkedList<>();

        s1.add(node1);
        q1.offer(node1);
        s2.add(node2);
        q2.offer(node2);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (!q1.isEmpty()) {
                GitNode cur1 = q1.poll();

                if (s2.contains(cur1)) {
                    return cur1;
                }
                s1.add(cur1);

                for (GitNode g1: cur1.parent) {
                    if (!s1.contains(g1)) {
                        q1.offer(g1);
                    }
                }
            }

            if (!q2.isEmpty()) {
                GitNode cur2 = q2.poll();

                if (s1.contains(cur2)) {
                    return cur2;
                }
                s2.add(cur2);

                for (GitNode g2: cur2.parent) {
                    if (!s2.contains(g2)) {
                        q2.offer(g2);
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        GitNode g1 = new GitNode(1);
        GitNode g2 = new GitNode(2);
        GitNode g3 = new GitNode(3);
        GitNode g4 = new GitNode(4);
        g4.parent.add(g2);
        g2.parent.add(g1);
        g3.parent.add(g1);
        g3.parent.add(g2);
//        List<GitNode> list = new GitCommit().findAllCommits(g4);
//        for (GitNode g: list) {
//            System.out.println(g.id);
//        }
        System.out.println(new GitCommit().findLCA(g3, g4).id);
    }
}
