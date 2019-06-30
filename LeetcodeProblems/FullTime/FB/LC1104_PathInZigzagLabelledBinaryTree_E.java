package FullTime.FB;

import java.util.LinkedList;
import java.util.List;

public class LC1104_PathInZigzagLabelledBinaryTree_E {

    public List<Integer> pathInZigZagTree(int label) {
        int i = 0;
        while (label >= (int)Math.pow(2, i)) {
            if (label <= (int)Math.pow(2, i + 1) - 1) {
                break;
            }
            i++;
        }

        List<Integer> res = new LinkedList<>();
        res.add(label);
        i--;

        while (i >= 0) {
            label /= 2;
            int n1 = (int)Math.pow(2, i);
            int n2 = (int)Math.pow(2, i + 1) - 1;
            int l1 = label - n1;
            int l2 = n2 - label;

            label = l1 <= l2? n2 - l1: n1 + l2;
            res.add(0, label);
            i--;
        }
        return res;
    }
}
