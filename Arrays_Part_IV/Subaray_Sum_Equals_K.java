/*
    Problem Name: Subarray Sum Equals K
    Problem Link: https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_5713505
*/

import java.util.HashMap;

public class Subaray_Sum_Equals_K {
    /*
        Brute Force Approach
        TC -> O(N^3)
        SC -> O(1)
        public static int subarraySum(int[] nums, int K) {
            int longest = 0;
            int n = nums.length;
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    int sum = 0;
                    for(int k=i;k<=j;k++){
                        sum += nums[k];
                    }
                    if(sum == K){
                        longest = Math.max(longest, j - i + 1);
                    }
                }
            }
            return longest;
        }
    */

    /*
        Better Solution
        TC -> O(N^2)
        SC -> O(1)
        public static int subarraySum(int[] nums, int K) {
            int longest = 0;
            int n = nums.length;
            for(int i=0;i<n;i++){
                int sum = 0;
                for(int j=i;j<n;j++){
                    sum += nums[j];
                    if(sum == K){
                        longest = Math.max(longest, j - i + 1);
                    }
                }
            }
            return longest;
        }
    */

    /*
        Optimal solution if the array has Negative, Postives and Zeros but its the better solution if the array has only positives
        TC -> O(N), assuming map takes O(1) for insertion and retrival and there are no collisions
        SC -> O(N)
        public static int subarraySum(int[] nums, int K) {
            HashMap<Long, Integer> map = new HashMap<>();
            int maxLength = 0, n = nums.length;
            long sum = 0;
            for(int i=0;i<n;i++){
                sum += nums[i];
                if(sum == K){
                    maxLength = i+1;
                }
                long rem = sum - K;
                if(map.containsKey(rem)){
                    maxLength = Math.max(maxLength, i - map.get(rem));
                }
                if(!map.containsKey(sum)){
                    map.put(sum, i);
                }
            }
            return maxLength;
        }
    */

    /*
        Optimal Solution: This solution is only for the positive arrays
        TC -> O(2N)
        SC -> O(1)
    */
    public static int subarraySum(int[] nums, int K) {
        int n = nums.length;
        int left = 0, right = 0;
        long sum = nums[0];
        int maxLength = 0;
        while(right < n){
            while(left <= right && sum > K){
                sum -= nums[left];
                left++;
            }
            if(sum == K){
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
            if(right < n){
                sum += nums[right];
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 1, 1};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int K1 = 2, K2 = 3, K3 = 3;

        System.out.println(subarraySum(nums1, K1));
        System.out.println(subarraySum(nums2, K2));
        System.out.println(subarraySum(nums3, K3));
    }
}