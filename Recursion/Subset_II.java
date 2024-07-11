/*
    Problem Name: Subset_II
    Problem Link: https://leetcode.com/problems/subsets-ii/
*/
import java.util.*;

public class Subset_II {
    /*
        TC -> O(2^n) * n
        SC -> O(2^n) * k, where k is the average size of each set
    */
    public static void subsetWithDupHelper(int index, List<Integer> ds, int[] nums, int n, List<List<Integer>> result){
        result.add(new ArrayList<>(ds));
        for(int i=index;i<n;i++){
            if(i != index && nums[i] == nums[i - 1])    continue;
            ds.add(nums[i]);
            subsetWithDupHelper(i + 1, ds, nums, n, result);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetWithDupHelper(0, new ArrayList<>(), nums, nums.length, result);
        return result;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {0};

        System.out.println(subsetsWithDup(nums2));
        System.out.println(subsetsWithDup(nums1));
    }
}
