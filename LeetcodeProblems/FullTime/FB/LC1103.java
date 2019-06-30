package FullTime.FB;

public class c1 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 1, j = num_people, sum = 0;
        int cur = (i + j) * num_people / 2;

        while (cur < candies) {
            sum++;
            i += num_people;
            j += num_people;
            candies -= cur;
            cur = (i + j) * num_people / 2;
        }

        int tmp = sum * num_people + 1;
        for (int k = 0; k < num_people; k++) {
            res[k] = sum * (sum - 1) / 2 * num_people + sum * (k + 1);
            if (candies > 0) {
                if (candies >= tmp) {
                    res[k] += tmp;
                    candies -= tmp;
                    tmp++;
                } else {
                    res[k] += candies;
                    candies = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new c1().distributeCandies(60,4);
        for (int n: res) {
            System.out.print(n + " ");
        }
    }
}
