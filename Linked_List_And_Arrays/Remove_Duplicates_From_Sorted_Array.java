/*
    Problem Name: Remove Duplicates from Sorted Array
    Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/

import java.util.Arrays;

public class Remove_Duplicates_From_Sorted_Array {
    
    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(1)
    */
    public static int removeDuplicates(int[] nums) {
        int left = 0, right = 1, n = nums.length;
        while(right < n){
            if(nums[right] == nums[left]){
                right++;
            }else{
                nums[++left] = nums[right++];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};

        System.out.println("first " + removeDuplicates(nums1) + " are the unique elements in the array -> " + Arrays.toString(nums1));
        System.out.println("first " + removeDuplicates(nums2) + " are the unique elements in the array -> " + Arrays.toString(nums2));
    }
}
