/*
    Problem Name: Max Consecutive Ones
    Problem Link: https://leetcode.com/problems/max-consecutive-ones/
*/

import java.util.Arrays;

public class Max_Consecutive_Ones {
    
    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(1)
    */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxOnes = 0, n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                count++;
            }else{
                count = 0;
            }
            maxOnes = Math.max(maxOnes, count);
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int[] nums2 = {1, 0, 1, 1, 0, 1};

        System.out.println("There are " + findMaxConsecutiveOnes(nums1) + " consecutive ones in the array -> " + Arrays.toString(nums1));
        System.out.println("There are " + findMaxConsecutiveOnes(nums2) + " consecutive ones in the array -> " + Arrays.toString(nums2));
    }   
}
