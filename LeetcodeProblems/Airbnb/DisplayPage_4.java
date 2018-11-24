package Airbnb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DisplayPage_4 {
    public String[] reorder(String[] input, int n) {
        List<String> inputList = new LinkedList<>();
        List<String> outputList = new LinkedList<>();
        int pageNum = input.length / n;

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
        return outputList.toArray(new String[outputList.size()]);
    }

    public static void main(String[] args) {
        String[] input = new String[13];
        input[0] = "1,28,310.6,SF";
        input[1] = "4,5,204.1,SF";
        input[2] = "20,7,203.2,Oakland";
        input[3] = "6,8,202.2,SF";
        input[4] = "6,10,199.1,SF";
        input[5] = "1,16,190.4,SF";
        input[6] = "6,29,185.2,SF";
        input[7] = "7,20,180.1,SF";
        input[8] = "6,21,162.1,SF";
        input[9] = "2,18,161.2,SF";
        input[10] = "2,30,149.1,SF";
        input[11] = "3,76,146.2,SF";
        input[12] = "2,14,141.1,San Jose";
        String[] output = new DisplayPage_4().reorder(input, 5);
        for (String s: output) {
            System.out.println(s);
        }
    }
}
