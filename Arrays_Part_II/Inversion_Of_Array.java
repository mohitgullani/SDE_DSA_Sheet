/*
    Problem Name: Count Inversions
    Problem Link: https://www.naukri.com/code360/problems/count-inversions_615
*/

public class Inversion_Of_Array {
    /*
        Brute Force Approach
        TC -> O(N^2)
        SC -> O(1)
        public static int getInversions(int nums[]) {
            int count = 0;
            int n = nums.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(nums[i] > nums[j]){
                        count++;
                    }
                }
            }
            return count;
        }
    */

    /*
        Optimal Solution using merge sort
        TC -> O(NlogN)
        SC -> O(N)
    */
    public static int merge(int[] nums, int low, int mid, int high){
        int count = 0;
        int left = low, right = mid+1, index = 0;
        int[] result = new int[high - low + 1];
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                result[index++] = nums[left++];
            }else{
                count += mid - left + 1;
                result[index++] = nums[right++];
            }
        }
        while(left <= mid){
            result[index++] = nums[left++];
        }
        while(right <= high){
            result[index++] = nums[right++];
        }
        for(int i=0;i<result.length;i++){
            nums[low+i] = result[i];
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
        count += merge(nums, low, mid, high);
        return count;
    }

    public static int getInversions(int nums[]) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {3, 2, 1};
        int[] nums2 = {2, 5, 1, 3, 4};
        int[] nums3 = {5, 3, 2, 4, 1};
        System.out.println(getInversions(nums1));
        System.out.println(getInversions(nums2));
        System.out.println(getInversions(nums3));
    }
}
