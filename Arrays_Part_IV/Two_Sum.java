/*
    Problem Link: https://leetcode.com/problems/two-sum/
    Problem Name & Number: 1. Two Sum
    Problem Descripton: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. 
                        You may assume that each input would have exactly one solution, 
                        and you may not use the same element twice.You can return the answer in any order.
*/

import java.util.*;

public class Two_Sum {

    /*
        Brute Force Solution
        TC -> O(N^2)
        SC -> O(1)
        public static List<Integer> twoSum(int[] nums, int target) {
            List<Integer> list = new ArrayList<>();
            int n = nums.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(nums[i] + nums[j] == target){
                        list.add(i);
                        list.add(j);
                        break;
                    }
                }
            }
            return list;
        }
    */

    /*
        Better Solution if we just need to return either true or false
        TC -> O(NlogN) + O(N)
        SC -> O(1)

        public static Boolean twoSum(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int left = 0, right = n-1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum == target){
                    return true;
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
            return false;
        }
    */

    /*
        Optimal Solution
        TC -> O(NlogN)
        SC -> O(N)
    */
    public static List<Integer> twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            int b = target - nums[i];
            if(map.containsKey(b)){
                list.add(map.get(b));
                list.add(i);
                break;
            }
            map.put(a, i);
        }
        return list;
    }
    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};
        int target1 = 9, target2 = 6, target3 = 6;
        System.out.println(twoSum(nums1, target1));
        System.out.println(twoSum(nums2, target2));
        System.out.println(twoSum(nums3, target3));
    }
}
