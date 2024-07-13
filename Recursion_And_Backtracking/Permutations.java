/*
    Problem Name: Print all permutations of a string/array
    Problem Link: https://leetcode.com/problems/permutations/
*/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /*
        Swapping Approach
        TC -> O(N!) * N{copying the array from tempList to list}
        SC -> O(N!){for returning the answer list} + O(N){Auxilliary Stack Space}
    */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        getAllPermutations(0, nums, list, n);
        return list;
    }

    public static void getAllPermutations(int index, int[] nums, List<List<Integer>> list, int n){
        if(index == n){
            List<Integer> tempList = new ArrayList<>();
            for(int num: nums)  tempList.add(num);
            list.add(tempList);
            return;
        }
        for(int i=index;i<n;i++){
            swap(nums, index, i);
            getAllPermutations(index + 1, nums, list, n);
            swap(nums, index, i);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {0, 1};
        int[] nums3 = {1};

        System.out.println(permute(nums1));
        System.out.println(permute(nums2));
        System.out.println(permute(nums3));
    }
}
