package Google;

import java.util.Arrays;

public class StoresAndHouses {

    public int[] solution(int[] stores, int[] houses) {
        int[] ret = new int[houses.length];
        Arrays.sort(stores);
        for (int i = 0; i < houses.length; i++) {
            ret[i] = searchStore(stores, houses[i]);
        }
        return ret;
    }

    public int searchStore(int[] stores, int house) {
        int lo = 0, hi = stores.length - 1, mid;
        if (house <= stores[0]) {
            return stores[0];
        } else if (house >= stores[hi]) {
            return stores[hi];
        } else {
            while (lo < hi - 1) {
                mid = lo + (hi - lo) / 2;
                if (house >= stores[mid] && house < stores[hi]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
            if (Math.abs(stores[lo] - house) <= Math.abs(stores[hi] - house)) {
                return stores[lo];
            }
        }
        return stores[hi];
    }

    public static void main(String[] args) {
        // test cases
        int[] stores1 = {1,5,20,11,16};
        int[] houses1 = {5,10,17};

        int[] stores2 = {5,20,11,16};
        int[] houses2 = {0,1,2};

        int[] stores3 = {1,5,20,11,16};
        int[] houses3 = {20,25,100};

        int[] stores4 = {1,5,20,11,16};
        int[] houses4 = {3,8,11};

        int[] stores5 = {1};
        int[] houses5 = {0,5,15};

        int[] stores6 = {1,5,5,6,10};
        int[] houses6 = {0,1,5,6,6,12};

        int[] stores7 = {1000000};
        int[] houses7 = {1,999999};

        int[] stores8 = {0,4,6,8,10};
        int[] houses8 = {2,5,7,9};

        int[] stores9 = {5,5,5,5};
        int[] houses9 = {1,5,9};

        int[] stores10 = {1,5,20,11,16};
        int[] houses10 = {6,6,6};

        int[] ret = new StoresAndHouses().solution(stores10, houses10);
        for (int n: ret) {
            System.out.println(n);
        }
    }
}
