/*
    Problem Name: Nth Root of an Integer
    Problem Link: https://www.naukri.com/code360/problems/1062679
*/

import java.util.*;

public class Nth_Root {
    /*
        Most Optimal Approach
        TC -> O(NlogN)
        SC -> O(1)
    */
    public static int NthRoot(int n, int m) {
        int low = 1, high = m;
        while(low <= high){
            int mid = (low + high)/2;
            int result=(int)Math.pow(mid, n);
            if(result == m){
                return mid;
            }else if(result > m){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test Cases
        int n1 = 3, n2 = 4;
        int m1 = 27, m2 = 69;

        System.out.println(NthRoot(n1, m1));
        System.out.println(NthRoot(n2, m2));
    }
}