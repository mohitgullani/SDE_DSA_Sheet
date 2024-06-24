/*
    Problem Name: Merge Sorted Array
    Problem Link: https://leetcode.com/problems/merge-sorted-array/
*/

import java.util.Arrays;

public class Merge_Sorted_Array {
    /*
        Brute Force Approach
        TC -> O(N + M) + O(N + M)
        SC -> O(N + M)
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] result = new int[m + n];
            int left = 0, right = 0, k = 0;
            while(left < m && right < n){
                if(nums1[left] <= nums2[right]){
                    result[k++] = nums1[left++];
                }else{
                    result[k++] = nums2[right++];
                }
            }

            while(left < m){
                result[k++] = nums1[left++];
            }
            while(right < n){
                result[k++] = nums2[right++];
            }
            for(int i=0;i<result.length;i++){
                nums1[i] = result[i];
            }
            System.out.println(Arrays.toString(nums1));
        }
    */

    /*
        Optimal Solution 1
        TC -> O(Min(N, M)) + O(NlogN) + O(MlogM) + O(N)
        SC -> O(1)
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int left = m - 1;
            int right = 0;
            while(left >= 0 && right < n){
                if(nums1[left] > nums2[right]){
                    swap(nums1, nums2, left, right);
                }else{
                    break;
                }
                left--;
                right++;
            }
            Arrays.sort(nums1, 0, m);
            Arrays.sort(nums2);
            for(int i=0;i<n;i++){
                nums1[m + i] = nums2[i];
            }   
            System.out.println(Arrays.toString(nums1));     
        }

        private static void swap(int[] nums1, int[] nums2, int left, int right){
            int temp = nums1[left];
            nums1[left] = nums2[right];
            nums2[right] = temp;
        }
    */

    /*
        Optimal Solution 2
        TC -> O(log(N + M)) * O(N + M)
        SC -> O(1)
    */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int gap = (length / 2) + (length % 2);
        while(gap > 0){
            int left = 0;
            int right = left + gap;
            while(right < length){
                // left in nums1 & right in nums2
                if(left < m && right >= m){
                    swapIfGreater(nums1, nums2, left, right - m);
                }
                // Both are in nums1
                else if(right < m){
                    swapIfGreater(nums1, nums1, left, right);
                }
                // Both are in nums2
                else{
                    swapIfGreater(nums2, nums2, left - m, right - m);
                }
                left++;
                right++;
            }
            if(gap == 1)    break;
            gap = (gap / 2) + (gap % 2);
        }
        for(int i=0;i<n;i++){
            nums1[m + i] = nums2[i];
        }
        System.out.println(Arrays.toString(nums1));
    }

    private static void swapIfGreater(int[] nums1, int[] nums2, int left, int right){
        if(nums1[left] > nums2[right]){
            int temp = nums1[left];
            nums1[left] = nums2[right];
            nums2[right] = temp;
        }
    }

    public static void main(String[] args) {
        // Test Cases 1
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
    }
}
