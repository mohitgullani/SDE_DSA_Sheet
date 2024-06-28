/*
    Problem Name: Reverse Pairs
    Problem Link: https://leetcode.com/problems/reverse-pairs/description/
*/
public class Reverse_Pairs {
    /*
        Brute Force Approach
        TC -> O(N^2)
        SC -> O(1)
        public static int reversePairs(int[] nums) {
            int count = 0;
            int n = nums.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(nums[i] > 2 * nums[j]){
                        count++;
                    }
                }
            }
            return count;
        }
    */

    /*
        Optimal Solution
        TC -> O(2NlogN)
        SC -> O(N)
    */
    public static void merge(int[] nums, int low, int mid, int high){
        int left = low, right = mid + 1, index = 0;
        int[] temp = new int[high - low + 1];
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[index++] = nums[left++];
            }else{
                temp[index++] = nums[right++];
            }
        }
        while(left <= mid){
            temp[index++] = nums[left++];
        }
        while(right <= high){
            temp[index++] = nums[right++];
        }
        for(int i=0;i<temp.length;i++){
            nums[low + i] = temp[i];
        }
    }
    
    public static int countPairs(int[] nums, int low, int mid, int high){
        int count = 0;
        int right = mid + 1;
        for(int i=low;i<=mid;i++){
            while(right <= high && (long)nums[i] > 2 *(long)nums[right]){
                right++;
            }
            count = count + right - (mid + 1);
        }
        return count;
    }

    public static int mergeSort(int[] nums, int low, int high){
        int count = 0;
        if(low >= high){
            return count;
        }
        int mid = (low + high)/2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }

    public static int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 3, 2, 3, 1};
        int[] nums2 = {2, 4, 3, 5, 1};
        
        System.out.println(reversePairs(nums1));
        System.out.println(reversePairs(nums2));
    }
}
