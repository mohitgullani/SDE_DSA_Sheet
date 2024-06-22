/*
    Problem Number and Name: 31. Next Permutation
    Problem Link: https://leetcode.com/problems/next-permutation/description/
*/

import java.util.Arrays;

public class Next_Permutation {
    /*
        Brute Force
        Generate all permutations and sort -> O(N! x N), where N! for generating all permutations and each permutation is of length N
        Perform Linear Search
        If find return the next permutation.
    */

    /*
        Optimal Solution
        TC -> O(N) + O(N) + O(N) -> O(3N)
        SC -> O(1)
    */
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(nums, 0, n-1);
            return;
        }
        for(int i=n-1;i>index;i--){
            if(nums[i] > nums[index]){
                swap(nums, index, i);
                break;
            }
        }
        reverse(nums, index + 1, n - 1);
    }
    
    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 2, 1};
        int[] nums3 = {1, 1, 5};

        nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1));
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));
        nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));

    }

    public static void swap(int[] nums, int i, int j){
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
    public static void reverse(int nums[], int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
