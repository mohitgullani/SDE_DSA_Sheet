/*
    Problem Name: Maximum Subarray
    Problem Link: https://leetcode.com/problems/maximum-subarray/description/
*/

public class Maximum_Subarray_Sum {
    /*
        Brute Force approach
        TC -> O(N^3)
        SC -> O(1)
        public static int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            int n = nums.length;
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    int sum = 0;
                    for(int k=i;k<=j;k++){
                        sum += nums[k];
                    }
                    maxSum = Math.max(sum, maxSum);
                }
            }
            return maxSum;
        }
    */

    /*
        Better Solution
        TC -> O(N^2)
        SC -> O(1)
        public static int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            int n = nums.length;
            for(int i=0;i<n;i++){
                int sum = 0;
                for(int j=i;j<n;j++){
                    sum += nums[j];
                    maxSum = Math.max(sum, maxSum);
                }
            }
            return maxSum;
        }
    */

    /*
        Optimal Solution using Kadane's Algorithm
        TC -> O(N)
        SC -> O(1)
    */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = nums[0], bestSum = nums[0];
        for(int i=1;i<n;i++){
            if(sum + nums[i] < nums[i]){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            bestSum = Math.max(bestSum, sum);
        }
        return bestSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};

        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray(nums3));
    }
}
