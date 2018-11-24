package Airbnb;

import java.util.*;

public class DisplayPage_4 {

    // Solution 1: for loop
    public List<String> reorder_1(List<String> input, int n) {
        List<String> inputList = new LinkedList<>();
        List<String> outputList = new LinkedList<>();
        int pageNum = input.size() / n;

        for (String s: input) {
            inputList.add(s);
        }

        for (int i = 0; i < pageNum; i++) {
            Set<String> hostID = new HashSet<>();
            int cnt = 0;
            int j = 0;
            while(cnt < n) {
                if (j >= inputList.size()) {
                    for (int k = 0; k < n - cnt; k++) {
                        outputList.add(inputList.get(0));
                        inputList.remove(0);
                        cnt++;
                    }
                } else {
                    String tmp = inputList.get(j++);
                    String host_id = tmp.split(",")[0];
                    if (!hostID.contains(host_id)) {
                        outputList.add(tmp);
                        inputList.remove(tmp);
                        hostID.add(host_id);
                        cnt++;
                        j--;
                    }
                }
            }
            outputList.add(" ");
        }
        for (int i = 0; i < inputList.size(); i++) {
            outputList.add(inputList.get(i));
        }
        return outputList;
    }

    // Solution 2: using iterator
    public List<String> reorder_2(List<String> input, int n) {
        List<String> output = new ArrayList<>();
        if (input == null || input.size() == 0) {
            return output;
        }
        Iterator<String> iter = input.iterator();
        List<String> hostID = new ArrayList<>();
        boolean reachEnd = false;

        while(input.size() > 0) {
            String tmp = iter.next();
            String host_id = tmp.split(",")[0];
            if (!hostID.contains(host_id) || reachEnd) {
                output.add(tmp);
                hostID.add(host_id);
                iter.remove();
            }
            if (hostID.size() == n) {
                hostID.clear();
                reachEnd = false;
                if (!input.isEmpty()) {
                    output.add(" ");
                }
                iter = input.iterator();
            }
            if (!iter.hasNext()) {
                reachEnd = true;
                iter = input.iterator();
            }
        }
        return output;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("1,28,310.6,SF");
        input.add("4,5,204.1,SF");
        input.add("20,7,203.2,Oakland");
        input.add("6,8,202.2,SF");
        input.add("6,10,199.1,SF");
        input.add("1,16,190.4,SF");
        input.add("6,29,185.2,SF");
        input.add("7,20,180.1,SF");
        input.add("6,21,162.1,SF");
        input.add("2,18,161.2,SF");
        input.add("2,30,149.1,SF");
        input.add("3,76,146.2,SF");
        input.add("2,14,141.1,San Jose");
        List<String> output = new DisplayPage_4().reorder_2(input, 5);
        for (String s: output) {
            System.out.println(s);
        }
    }
}
