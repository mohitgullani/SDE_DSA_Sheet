/*
    Problem Name: 4 Sum
    Problem Link: https://leetcode.com/problems/4sum/
*/

import java.util.*;

public class Four_Sum {
    /*
        Brute Force Approach
        TC -> O(N^4) + O(no. of quads)
        SC -> 2 * O(no. of quads)
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> list = new ArrayList<>();
            Set<List<Integer>> set = new HashSet<>();
            int n = nums.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    for(int k=j+1;k<n;k++){
                        for(int l=k+1;l<n;l++){
                            int sum = nums[i] + nums[j];
                            sum += nums[k];
                            sum += nums[l];
                            if(sum == target){
                                set.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                            }
                        }
                    }
                }
            }
            for(List<Integer> temp: set){
                list.add(temp);
            }
            return list;
        }
    */

    /*
        Better Solution
        TC -> O(N^3) + O(no. of quads)
        SC -> 2 * O(no. of quads)
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> list = new ArrayList<>();
            Set<List<Integer>> set = new HashSet<>();
            int n = nums.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    Set<Integer> tempSet = new HashSet<>();
                    for(int k=j+1;k<n;k++){
                        int sum = nums[i] + nums[j];
                        sum += nums[k];
                        int fourthElement = target - sum;
                        if(tempSet.contains(fourthElement)){
                            set.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], fourthElement, nums[k])));
                        }
                        tempSet.add(nums[k]);
                    }
                }
            }
            for(List<Integer> temp: set){
                list.add(temp);
            }
            return list;
        }
    */

    /*
        Optimal Solution
        TC -> O(N^2 * N) -> O(N^3)
        SC -> O(N){for sorting the array} + O(no. of quads){I am using this space to return the answer not for solving!}
    */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i != 0 && nums[i] == nums[i-1])    continue;
            for(int j=i+1;j<n;j++){
                if(j != i+1 && nums[j] == nums[j-1])    continue;
                int k = j + 1;
                int l = n - 1;
                while(k < l){
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum == target){
                        list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1])    k++;
                        while(k < l && nums[l] == nums[l+1])    l--;
                    }else if(sum < target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int[] nums2 = {2, 2, 2, 2, 2};

        int target1 = 0, target2 = 8;
        System.out.println(fourSum(nums1, target1));
        System.out.println(fourSum(nums2, target2));
    }
}
