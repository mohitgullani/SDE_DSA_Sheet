/*
    Problem Name: Median of 2 Sorted Arrays
    Problem Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
*/

public class Median_of_2_Sorted_Arrays {
    /*
        Brute Force approach
        TC -> O(N1 + N2)
        SC -> O(N1 + N2)
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] result = mergeArray(nums1, nums2);
            int n1 = nums1.length, n2 = nums2.length;
            int length = n1 + n2;
            if(length % 2 == 1){
                return (double)result[length/2];
            }else{
                return (double)(result[length/2] + result[length/2 - 1]) / 2.0;
            }
        }
        public static int[] mergeArray(int[] nums1, int[] nums2){
            int i = 0, j = 0, k = 0, n1 = nums1.length, n2 = nums2.length;
            int[] result = new int[n1 + n2];
            while(i < n1 && j < n2){
                if(nums1[i] <= nums2[j]){
                    result[k++] = nums1[i++];
                }else{
                    result[k++] = nums2[j++];
                }
            }

            while(i < n1){
                result[k++] = nums1[i++];
            }

            while(j < n2){
                result[k++] = nums2[j++];
            }
            return result;
        }
    */

    /*
        Better Solution
        TC -> O(N1 + N2)
        SC -> O(1)
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length, n2 = nums2.length;
            int length = n1 + n2;
            int index1 = length/2 - 1, index2 = length/2;
            int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;
            int i = 0, j = 0, count = 0;
            while(i < n1 && j < n2){
                if(nums1[i] <= nums2[j]){
                    if(index1 == count) element1 = nums1[i];
                    if(index2 == count) element2 = nums1[i];
                    i += 1;
                }else{
                    if(index1 == count) element1 = nums2[j];
                    if(index2 == count) element2 = nums2[j];
                    j += 1;
                }
                count += 1;
            }

            while(i < n1){
                if(index1 == count) element1 = nums1[i];
                if(index2 == count) element2 = nums1[i];
                i += 1;
                count += 1;
            }

            while(j < n2){
                if(index1 == count) element1 = nums2[j];
                if(index2 == count) element2 = nums2[j];
                j += 1;
                count += 1;
            }

            if(length % 2 == 1) return (double)element2;
            return (double)(element1 + element2) / 2.0;
        }
    */

    /*
        Optimal Solution
        TC -> O(min(logN1, logN2))
        SC -> O(1)
    */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int length = n1 + n2;
        int low = 0, high = n1;
        int left = (n1 + n2 + 1)/2;
        while(low <= high){
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1 < n1)   r1 = nums1[mid1];
            if(mid2 < n2)   r2 = nums2[mid2];
            if(mid1 - 1 >= 0)   l1 = nums1[mid1 - 1];
            if(mid2 - 1 >= 0)   l2 = nums2[mid2 - 1];

            if(l1 <= r2 && l2 <= r1){
                if(length % 2 == 1) return (double)Math.max(l1, l2);
                return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }else if(l1 > r2){
                high = mid1 - 1;
            }else{
                low = mid1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 3}, nums2 = {2};
        int[] nums3 = {1, 2}, nums4 = {3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays(nums3, nums4));
    }
}
