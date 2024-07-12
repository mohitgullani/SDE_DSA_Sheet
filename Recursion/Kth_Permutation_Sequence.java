/*
    Problem Name: Permutation Sequence
    Problem Link: https://leetcode.com/problems/permutation-sequence/
*/

import java.util.*;

public class Kth_Permutation_Sequence {
    /*
        Brute Force Approach
        TC -> O(N){for creating the list 1 - N} + N! * N + N!log(N!){Sorting}
        SC -> O(N)
        Auxilliary Space -> O(N)
        public static String getPermutation(int n, int k) {
            int[] nums = new int[n];
            for(int i=1;i<=n;i++){
                nums[i - 1] = i;
            }

            List<String> list = new ArrayList<>();
            generatePermutations(0, nums, list, n);
            Collections.sort(list);
            return list.get(k - 1);

        }

        public static void generatePermutations(int index, int[] nums, List<String> list, int n){
            if(index == n){
                StringBuilder sb = new StringBuilder();
                for(int num: nums)  sb.append(num);
                list.add(sb.toString());
                return;
            }
            for(int i=index;i<n;i++){
                swap(nums, i, index);
                generatePermutations(index + 1, nums, list, n);
                swap(nums, i, index);
            }
        }
            
        public static void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    */

    /*
        Optimal Solution
        TC -> O(N){for creating the list 1 - N} + (O(N){looping} * O(N){deleting the element})
        SC -> O(N)
    */
    public static String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int fact = 1;
        for(int i=1;i<n;i++){
            list.add(i);
            fact *= i;
        }
        list.add(n);
        k -= 1;

        while(list.size() > 0){
            sb.append(list.get(k / fact));
            list.remove(k / fact);
            k %= fact;
            if(list.size() == 0){
                break;
            }
            fact /= list.size();
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        // Test Cases
        int n1 = 3, n2 = 4, n3 = 3;
        int k1 = 3, k2 = 9, k3 = 1;

        System.out.println(getPermutation(n1, k1));
        System.out.println(getPermutation(n2, k2));
        System.out.println(getPermutation(n3, k3));
    }
}
