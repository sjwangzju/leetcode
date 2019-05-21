//package Dropbox;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class WebCrawler {
//
//    public List<String> crawlBFS(String url) {
//        List<String> res = new LinkedList<>();
//        Queue<String> q = new LinkedList<>();
//
//        q.offer(url);
//        while (!q.isEmpty()) {
//            String cur = q.poll();
//            if (!res.contains(cur)) res.add(cur);
//
//            List<String> list = getUrls(cur);
//            for (String s: list) {
//                q.offer(s);
//            }
//        }
//        return res;
//    }
//
//
//    /****************************************************************************************/
//    // FOLLOWUP: multi-thread
//    public void crawl() {
//        while (true) {
//            synchronized (this) {
//                while (queue.isEmpty()) {
//                    // exit condition
//                    if (workingThread == 0 && queue.isEmpty) {
//                        break;
//                    }
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                nextURL = queue.poll();
//                workingThread++;
//            }
//            List<String> urls = getUrls(nextURL);
//
//            synchronized (this) {
//                for (String url: urls) {
//                    if (!visited.contains(url)) {
//                        visited.add(url);
//                        queue.offer(url);
//                    }
//                }
//                workingThread--;
//                notifyAll();
//            }
//        }
//    }
//
//
//    /****************************************************************************************/
//    // DFS disadvantages: takes long time
//    public List<String> crawlDFS(String url) {
//        List<String> res = new LinkedList<>();
//        dfs(res, url);
//        return res;
//    }
//
//    public void dfs(List<String> res, String cur) {
//        if (!res.contains(cur)) res.add(cur);
//        List<String> list = getUrls(cur);
//        for (String s: list) {
//            dfs(res, s);
//        }
//    }
//
//
//    /****************************************************************************************/
//    // API - get all urls on a certain page
//    public List<String> getUrls(String url) {
//        return null;
//    }
//}
