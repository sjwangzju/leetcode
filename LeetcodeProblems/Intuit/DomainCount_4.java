package Intuit;

import java.util.*;

public class DomainCount_4 {

    /*************************************************************************************/
    // find visits for all subdomains

    // time: O(N), N is the num of domains
    // space: O(N)
    public List<String> subdomainVisits(String[] domains) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> domainCnt = new HashMap<>();

        for (String domain: domains) {
            int n = Integer.valueOf(domain.split(" ")[0]);
            String curDomain = domain.split(" ")[1];
            domainCnt.put(curDomain, domainCnt.getOrDefault(curDomain, 0) + n);

            while (curDomain.contains(".")) {
                int index = curDomain.indexOf('.');
                curDomain = curDomain.substring(index + 1);
                domainCnt.put(curDomain, domainCnt.getOrDefault(curDomain, 0) + n);
            }
        }

        for (String domain: domainCnt.keySet()) {
            String s = domainCnt.get(domain) + " " + domain;
            res.add(s);
        }

        return res;
    }

    /*************************************************************************************/
    // find the longest continuous common history between 2 users

    // 2D dp:

    //      d b c
    //    0 0 0 0
    // a  0 0 0 0
    // b  0 0 1 0
    // c  0 0 0 2

    // if     user1[i-1] == user2[j-1] => dp[i][j] = dp[i-1][j-1] + 1
    // else   dp[i][j] = 0

    // time: O(M * N), M is len of user1, N is len of user2
    // space: O(M * N)
    public List<String> longestContinuousCommonHistory(String[] user1, String[] user2) {
        int l1 = user1.length;
        int l2 = user2.length;
        int[][] dp = new int[l1 + 1][l2 + 1];
        List<String> res = new LinkedList<>();
        List<String> tmp = new LinkedList<>();
        int max = 0;

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (user1[i - 1].equals(user2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i - 1][j - 1] == 0) {
                        tmp = new LinkedList<>();
                    }
                    tmp.add(user1[i - 1]);
                    if (tmp.size() > max) {
                        max = tmp.size();
                        res = tmp;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }


    /*************************************************************************************/

    // find the number of clicks and purchases of each item

    // String[] purchasedUser = ["203948535", "56856", "b86785"]
    // String[] history = ["234.64.23.123,2018.10.3,item A","234.457.2345.123,2018.10.3,item A","34.62.34.3,2018.10.3,item B"]
    // String[] ipaddressUser = ["203948535,234.457.2345.123","74545,234.457.2345.123""2347,234.64.23.123"]


    // time: O(N), N is the num of items

    public void purchase(String[] purchasedUser, String[] history, String[] ipaddressUser) {
        Map<String, List<String>> itemAndIP = new HashMap<>();
        Map<String, List<String>> IPAndUser = new HashMap<>();
        Set<String> users = new HashSet<>();

        // get the user set
        for (String s: purchasedUser) {
            users.add(s);
        }


        // get all ips for each item

        // Map<String, List<String>> itemAndIP:
        // item A: 234.64.23.123
        //         234.457.2345.123
        // item B: 34.62.34.3
        for (String s: history) {
            String curIP = s.split(",")[0];
            String curItem = s.split(",")[2];
            if (!itemAndIP.containsKey(curItem)) {
                itemAndIP.put(curItem, new LinkedList<>());
            }
            itemAndIP.get(curItem).add(curIP);
        }


        // get all users at each IP

        // Map<String, List<String>> IPAndUser:
        // 234.64.23.123: 2347
        // 234.457.2345.123: 203948535
        //                   74545
        for (String s: ipaddressUser) {
            String curUser = s.split(",")[0];
            String curIP = s.split(",")[1];
            if (!IPAndUser.containsKey(curIP)) {
                IPAndUser.put(curIP, new LinkedList<>());
            }
            IPAndUser.get(curIP).add(curUser);
        }


        for (String s: itemAndIP.keySet()) {
            List<String> ips = itemAndIP.get(s);
            int clickNum = ips.size();
            int purchaseNum = 0;
            for (String ip: ips) {
                List<String> u = IPAndUser.getOrDefault(ip, new LinkedList<>());
                for (String user: u) {
                    if (users.contains(user)) purchaseNum++;
                }
            }
            System.out.println(purchaseNum + " out of " + clickNum + " "+ s);
        }
    }

    public static void main(String[] args) {
//        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
//        System.out.println(new DomainCount_4().subdomainVisits(cpdomains));

        String[] user1 = {"h","a","b","g","e","c","d"};
        String[] user2 = {"i","a","q","c","d"};
        System.out.println(new DomainCount_4().longestContinuousCommonHistory(user1, user2));
//
//        String[] purchasedUser = {"203948535","56856","b86785"};
//        String[] history = {"234.64.23.123,2018.10.3,item A","234.457.2345.123,2018.10.3,item A","34.62.34.3,2018.10.3,item B"};
//        String[] ipaddressUser = {"203948535,234.457.2345.123","74545,234.457.2345.123","2347,234.64.23.123"};
//        new DomainCount_4().purchase(purchasedUser, history, ipaddressUser);
    }
}
