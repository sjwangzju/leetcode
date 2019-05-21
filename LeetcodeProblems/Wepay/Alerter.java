package Wepay;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Alerter {


    public boolean Alert(List<Integer> inputs, int windowSize, float allowedIncrease) {

        int[] windowMax;
        double[] windowAverage;

        windowMax = getWindowMax(inputs, windowSize);
        windowAverage = getWindowAverage(inputs, windowSize);

        boolean firstCondition = checkFirst(windowMax, windowAverage, windowSize, allowedIncrease);
        boolean secondCondition = checkSecond(windowAverage, allowedIncrease);

        // return true if meet either condition
        return firstCondition || secondCondition;
    }

    // check the first condition
    public boolean checkFirst(int[] windowMax, double[] windowAverage, int windowSize, float allowedIncrease) {
        boolean res;
        for (int i = 0; i < windowMax.length; i++) {
            res = true;
            // check each window that the current max appears
            for (int j = i; j <= i + windowSize - 1 && j < windowAverage.length; j++) {
                if (windowMax[i] / windowAverage[j] <= allowedIncrease) {
                    res = false;
                }
            }
            if (res) return true;
        }
        return false;
    }

    // check the second condition
    public boolean checkSecond(double[] windowAverage, double allowedIncrease) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < windowAverage.length; i++) {
            if (Double.compare(windowAverage[i], min) < 0) {
                min = windowAverage[i];
            }
            if (Double.compare(windowAverage[i] / min, allowedIncrease) > 0) {
                return true;
            }
        }
        return false;
    }

    // get the average value of each window
    public double[] getWindowAverage(List<Integer> inputs, int s) {
        int len = inputs.size();
        double[] average = new double[len - s + 1];
        double tmp = 0;

        for (int i = 0; i < inputs.size(); i++) {
            tmp += inputs.get(i);
            if (i >= s) {
                tmp -= inputs.get(i - s);
            }
            if (i >= s - 1) {
                average[i - s + 1] = tmp / (double) s;
            }
        }
        return average;
    }

    // get the max value of each window
    public int[] getWindowMax(List<Integer> inputs, int s) {
        int len = inputs.size();
        int[] windowMax = new int[len - s + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && deque.peek() < i - s + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && inputs.get(deque.getLast()) < inputs.get(i)) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i >= s - 1 && deque.peek() != null) {
                windowMax[i - s + 1] = inputs.get(deque.peek());
            }
        }
        return windowMax;
    }

    public static void main(String[] args) {
        List<Integer> inputs = Arrays.asList(1,2,4,2,2);
        System.out.println(new Alerter().Alert(inputs, 2, 2.5f));
    }
}
