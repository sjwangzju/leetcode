package FullTime.Amazon.OA;

public class AlphabetLookUp {

    private int[] lookupI(String s) {
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.charAt(i) - 'A';
        }
        return res;
    }

    private String lookupII(int[] nums) {
        StringBuilder res = new StringBuilder();
        for (int n: nums) {
            res.append((char)('A' + n));
        }
        return res.toString();
    }

    private void printI(String s1) {
        int[] res1 = new AlphabetLookUp().lookupI(s1);
        for (int n: res1) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private void printII(int[] nums) {
        String s = new AlphabetLookUp().lookupII(nums);
        System.out.println(s);
    }

    public static void main(String[] args) {
        AlphabetLookUp lookUp = new AlphabetLookUp();
//        lookUp.printI("QPS");
//        lookUp.printI("TSV");
        lookUp.printI("THANKS");
        lookUp.printII(new int[]{20,6,1,12,11,17});
    }
}
