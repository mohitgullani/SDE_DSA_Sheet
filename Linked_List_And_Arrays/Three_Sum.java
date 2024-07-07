/*
    Problem Name: 3 sum
    Problem Link: https://leetcode.com/problems/3sum/
*/

import java.util.*;

public class Three_Sum {
    /*
        Brute Force Approach
        TC -> O(N^3) + O(no. of unique triplets), assuming hashset will take O(1) for insertion
        I am not including sorting the tripet into my TC as it's just of 3 elements so it will be constant time
        SC -> 2 * O(no. of triplets)
        public static List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Set<List<Integer>> set = new HashSet<>();
            for(int i=0;i<n;i++)  {
                for(int j=i+1;j<n;j++){
                    for(int k=j+1;k<n;k++){
                        if(nums[i] + nums[j] + nums[k] == 0){
                            List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                            Collections.sort(triplet);
                            set.add(triplet);
                        }
                    }
                }
            }
            List<List<Integer>> list = new ArrayList<>();
            for(List<Integer> triplet: set){
                list.add(triplet);
            }
            return list;
        }
    */

    /*
        Better Solution
        TC -> O(N^2) + O(no. of unique triplets), assuming hashset will take O(1) for insertion
        I am not including sorting the tripet into my TC as it's just of 3 elements so it will be constant time
        SC -> O(N) + 2*(no. of unique triplets)
        public static List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Set<List<Integer>> set = new HashSet<>();
            for(int i=0;i<n;i++){
                HashSet<Integer> kset = new HashSet<>();
                for(int j=i+1;j<n;j++){
                    int need = -(nums[i] + nums[j]);
                    if(kset.contains(need)){
                        List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], need));
                        Collections.sort(triplet);
                        set.add(triplet);
                    }
                    kset.add(nums[j]);
                }
            }
            List<List<Integer>> list = new ArrayList<>();
            for(List<Integer> triplet: set){
                list.add(triplet);
            }
            return list;
        }
    */

    /*
        Optimal Solution
        TC -> O(NlogN){For Sorting} + O(N^2)
        SC -> O(N){I am using this space to store the answer not for solving}
    */
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                }else if(sum < 0){
                    j++;
                }else{
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1])  j++;
                    while(j < k && nums[k] == nums[k + 1])  k--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};

        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));
    }
}
