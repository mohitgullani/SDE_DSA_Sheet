public class Single_Element_In_Sorted_Array {
    /*
        Brute Force Approach
        TC -> O(N)
        SC -> O(1)
        public static int singleNonDuplicate(int[] nums) {
            int xor = 0;
            for(int num: nums){
                xor ^= num;
            }
            return xor;
        }
    */

    /*
        Optimal Solution
        TC -> O(logN)
        SC -> O(1)
        public static int singleNonDuplicate(int[] nums) {
            int low = 0, high = nums.length - 2;
            while(low <= high){
                int mid = (low + high) >> 1; // Same as (low + high) / 2;
                if(mid % 2 == 0){
                    // Even Index
                    if(nums[mid] == nums[mid + 1]){
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }else{
                    // Odd Index
                    if(nums[mid] == nums[mid + 1]){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }
            }
            return nums[low];
        }
    */
    
    /*
        Most Optimal Solution using Binary Search with Bit Manipulation
        TC -> O(logN)
        SC -> O(1)
    */
    public static int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2;
        while(low <= high){
            int mid = (low + high) >> 1; // Same as (low + high) / 2;
            if(nums[mid] == nums[mid ^ 1]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return nums[low];
    }
    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};

        System.out.println(singleNonDuplicate(nums1));
        System.out.println(singleNonDuplicate(nums2));
    }
}
