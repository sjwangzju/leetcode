package Indeed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class JobDescription {

    public static Map<Integer, Set<String>> jobs = new HashMap<>();

    public static void storeDocument(final String document, final int documentNumber) {
        Set<String> set = new HashSet<>();
        String[] contentWords = document.split(" ");
        for (String s: contentWords) {
            set.add(s);
        }
        jobs.put(documentNumber, set);
    }

    public String performSearch(final String search) {
        if (search == null || search.length() == 0) return "-1";
        Map<Integer, Integer> match = new HashMap<>();

        for (int id: jobs.keySet()) {
            int curMatch = countMatch(search, jobs.get(id));
            match.put(id, curMatch);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (match.get(a) == match.get(b)? (b - a) : (match.get(a) - match.get(b))));

        for (int id: match.keySet()) {
            if (match.get(id) > 0) {
                pq.offer(id);
            }
            if (pq.size() > 10) {
                pq.poll();
            }
        }

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            int curId = pq.poll();
            if (match.get(curId) > 0) {
                res.insert(0, curId + " ");
            }
        }

        if (res.length() == 0) {
            return "-1";
        }
        return res.toString();

    }

    public static int countMatch(String search, Set<String> set) {
        String[] searchWords = search.split("\\s+");
        int cnt = 0;

        for (String s: searchWords) {
            if (set.contains(s)) {
                cnt++;
            }
        }
        return cnt;
    }



    public static void main(String args[] ) throws Exception {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        final int N = Integer.parseInt(br.readLine());
//        // Read documents
//        for (int i = 0; i < N; i++) {
//            storeDocument(br.readLine(), i);
//        }
//
//        final int M = Integer.parseInt(br.readLine());
//        // Read searches
//        for (int j = 0; j < M; j++) {
//            System.out.println(performSearch(br.readLine()));
//        }
        JobDescription job = new JobDescription();
        System.out.println(job.performSearch("software"));
        System.out.println(job.performSearch("experienced developer"));
        System.out.println(job.performSearch("javascript developer experienced leader"));
        System.out.println(job.performSearch("recruiter"));
        System.out.println(job.performSearch("leader"));
    }
}
