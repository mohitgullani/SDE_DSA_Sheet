/*
    Problem Name: Longest Consecutive Sequence
    Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/description/
*/

import java.util.*;

public class Longest_Consecutive_Sequence {
    /*
        Brute Force Approach
        TC -> O(N^2)
        SC -> O(1)
        public static int longestConsecutive(int[] nums) {
            int longest = 0;
            for(int num: nums){
                int count = 1;
                int x = num;
                while(linearSearch(nums, x + 1)){
                    x += 1;
                    count += 1;
                }
                longest = Math.max(longest, count);
            }
            return longest;
        }
        public static boolean linearSearch(int[] nums, int x){
            for(int num: nums){
                if(num == x){
                    return true;
                }
            }
            return false;
        }
    */

    /*
        Better Solution
        TC -> O(NlogN) + O(N)
        SC -> O(N), if we are using merge sort but if we use quick sort it will be O(1)
        public static int longestConsecutive(int[] nums) {
            Arrays.sort(nums);
            int longest = 0, n = nums.length;
            int lastSmallest = Integer.MIN_VALUE;
            int count = 0;
            for(int i=0;i<n;i++){
                if(nums[i] - 1 == lastSmallest){
                    count += 1;
                    lastSmallest = nums[i];
                }else if(nums[i] != lastSmallest){
                    count = 1;
                    lastSmallest = nums[i];
                }
                longest = Math.max(longest, count);
            }
            return longest;
        }
    */

    /*
        Optimal Solution
        TC -> O(N) + O(2N) -> O(3N), assuming set will take O(1) for insertion & lookup
        SC -> O(N)
    */
    public static int longestConsecutive(int[] nums) {
        int longest = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        for(int num: set){
            if(!set.contains(num - 1)){
                int count = 1;
                int x = num;
                while(set.contains(x + 1)){
                    count += 1;
                    x += 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(longestConsecutive(nums1));
        System.out.println(longestConsecutive(nums2));
    }
}
