/*
    Problem Name: Find the Duplicate Number
    Problem Link: https://leetcode.com/problems/find-the-duplicate-number/description/
*/

import java.util.*;

public class Find_The_Duplicate_Number {
    /*
        Brute Force
        TC -> O(NlogN) + O(N)
        SC -> O(N), if we are using the merge sort or O(1) if we are using the quick sort
        public static int findDuplicate(int[] nums) {
            Arrays.sort(nums);
            for(int i=1;i<nums.length;i++){
                if(nums[i] == nums[i - 1]){
                    return nums[i];
                }
            }
            return -1;
        }
    */

    /*
        Optimal Solution
        TC -> O(N) + O(N)
        SC -> O(N)
    */
    public static int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key: map.keySet()){
            if(map.get(key) > 1){
                return key;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};
        int[] nums3 = {3,3,3,3,3};
        
        System.out.println(findDuplicate(nums1));
        System.out.println(findDuplicate(nums2));
        System.out.println(findDuplicate(nums3));
    }
}
