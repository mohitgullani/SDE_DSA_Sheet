import java.util.Arrays;

public class Sort_0s_1s_2s {
    /*
        Brute Force
        Applying any sorting algorithm
        If Merge Sort, TC -> O(NlogN) and SC -> O(N)
        if Quick Sort, TC -> O(NlogN) and SC -> O(1)
    */

    /*
        Better Solution
        TC -> O(N) + O(N) -> O(2N)
        SC -> O(1)
        public static void sortColors(int[] nums) {
            int count0 = 0, count1 = 0, count2 = 0;
            for(int num: nums){
                if(num == 0)    count0++;
                else if(num == 1)   count1++;
                else    count2++;
            }

            for(int i=0;i<count0;i++){
                nums[i] = 0;
            }
            for(int i=count0;i<count0+count1;i++){
                nums[i] = 1;
            }
            for(int i = count0+count1;i<nums.length;i++){
                nums[i] = 2;
            }
        }
    */

    /*
        Optimal Solution using Dutch National Flag Algorithm
        TC -> O(N)
        SC -> O(1)
    */
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, mid, low);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums, mid, high);
                high--;
            }
        }
    }
    
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        int[] nums2 = {2, 0, 1};

        sortColors(nums1);
        System.out.println(Arrays.toString(nums1));
        sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
