package BinarySearch;

import java.util.Random;

/**
 * Created by sjwang on 07/24/2018.
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 * Given n = 5, and version = 4 is the first bad version.
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 */
public class FirstBadVersion extends VersionControl{
    public int firstBadVersion(int n) {
        new VersionControl();
        firstBad = new Random().nextInt(n) + 1;
        int lo = 1, hi = n;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid) == true) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    public static void main(String args[]){
        System.out.println(new FirstBadVersion().firstBadVersion(5));
    }
}
