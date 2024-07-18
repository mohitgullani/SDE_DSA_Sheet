/*
    Problem Name: Search in Rotated Sorted Array
    Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
*/

public class Search_In_Rotated_Sorted_Array {
    /*
        Brute Force Approach -> Linear Search
        TC -> O(N)
        SC -> O(1)
        public static int search(int[] nums, int target) {
            for(int i=0;i<nums.length;i++){
                if(nums[i] == target){
                    return i;
                }
            }
            return -1;
        }
    */

    /*
        Optimal Solution -> Binary Search
        TC -> log(N)
        SC -> O(1)
    */
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {1};

        int target1 = 0, target2 = 3, target3 = 0;

        System.out.println(search(nums1, target1));
        System.out.println(search(nums2, target2));
        System.out.println(search(nums3, target3));
    }
}