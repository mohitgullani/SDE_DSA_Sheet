/*
    Problem Name: Majority Element II
    Problem Link: https://leetcode.com/problems/majority-element-ii/description/
*/

import java.util.*;

public class Majority_Element_II {

    /*
        Brute Force
        TC -> O(N^2)
        SC -> O(1)
        public static List<Integer> majorityElement(int[] nums) {
            List<Integer> list = new ArrayList<>();
            int n = nums.length;
            int min = (n/3) + 1;
            for(int i=0;i<n;i++){
                if(list.size() == 0 || nums[i] != list.get(0)){
                    int count = 0;
                    for(int j=0;j<n;j++){
                        if(nums[i] == nums[j]){
                            count++;
                        }
                    }
                    if(count >= min){
                        list.add(nums[i]);
                    }
                    if(list.size() == 2)    break;
                }
            }
            return list;
        }
    */

    /*
        Better Solution
        TC -> O(N)
        SC -> O(N)
        public static List<Integer> majorityElement(int[] nums) {
            List<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int n = nums.length;
            int min = (n/3) + 1;
            for(int num: nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
                if(map.get(num) == min){
                    list.add(num);
                }
                if(list.size() == 2)    break;
            }
            return list;
        }
    */

    /*
        Optimal Solution
        TC -> O(N) + O(N) -> O(2N)
        SC -> O(1)
    */
    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;
        int n = nums.length;
        for(int num: nums){
            if(count1 == 0 && num != element2){
                element1 = num;
                count1 = 1;
            }else if(count2 == 0 && num != element1){
                element2 = num;
                count2 = 1;
            }else if(element1 == num){
                count1++;
            }else if(element2 == num){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int min = n/3 + 1;
        count1 = 0;
        count2 = 0;
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            if(num == element1){
                count1++;
            }else if(num == element2){
                count2++;
            }
        }
        if(count1 >= min)   list.add(element1);
        if(count2 >= min)   list.add(element2);
        return list;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2};
        int[] nums3 = {1, 2};
        int[] nums4 = {1};

        System.out.println(majorityElement(nums1));
        System.out.println(majorityElement(nums2));
        System.out.println(majorityElement(nums3));
        System.out.println(majorityElement(nums4));
    }
}
