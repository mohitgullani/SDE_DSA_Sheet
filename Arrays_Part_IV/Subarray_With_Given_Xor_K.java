/*
    Problem Name: Count number of subarrays with given xor K
    Problem Link: https://www.interviewbit.com/problems/subarray-with-given-xor/
*/

import java.util.*;

public class Subarray_With_Given_Xor_K {
    /*
        Brute Force Approach
        TC -> O(N^3)
        SC -> O(1)
        public static int solve(int[] nums, int K) {
            int n = nums.length;
            int count = 0;
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    int xor = 0;
                    for(int k=i;k<=j;k++){
                        xor ^= nums[k];
                    }
                    if(xor == K){
                        count++;
                    }
                }
            }
            return count;
        }
    */

    /*
        Better Solution
        TC -> O(N^2)
        SC -> O(1)
        public static int solve(int[] nums, int K) {
            int n = nums.length;
            int count = 0;
            for(int i=0;i<n;i++){
                int xor = 0;
                for(int j=i;j<n;j++){
                    xor ^= nums[j];
                    if(xor == K){
                        count++;
                    }
                }
            }
            return count;
        }
    */

    /*
        Optimal Solution
        TC -> O(N), assuming map takes O(1) while insertion and retreival
        SC -> O(N) for the map data structure
    */
    public static int solve(int[] nums, int K) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        map.put(0, 1);
        for(int num: nums){
            xor ^= num;
            if(map.containsKey(xor ^ K)){
                count += map.get(xor ^ K);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {4, 2, 2, 6, 4};
        int[] nums2 = {5, 6, 7, 8, 9};
        int K1 = 6, K2 = 5;

        System.out.println(solve(nums1, K1));
        System.out.println(solve(nums2, K2));
    }
}
