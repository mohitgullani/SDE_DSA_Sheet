/*
    Problem Name: Combination Sum
    Problem Link: https://leetcode.com/problems/combination-sum/
*/

import java.util.*;

public class Combination_Sum {
    /*
        TC -> O(2^target * K)
        SC -> O(x * K), where x is the no. of unique combinations and k is the average length of each set
    */
    public static void combinationSumHelper(int index, int[] candidates, int target, List<List<Integer>> list, List<Integer> ds, int n){
        if(target == 0){
            list.add(new ArrayList<>(ds));
            return;
        }
        
        if(index == n){
            return;
        }
        
        if(target - candidates[index] >= 0){
            ds.add(candidates[index]);
            combinationSumHelper(index, candidates, target - candidates[index], list, ds, n);
            ds.remove(ds.size() - 1);
        }
        
        combinationSumHelper(index + 1, candidates, target, list, ds, n);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combinationSumHelper(0, candidates, target, list, new ArrayList<>(), candidates.length);
        return list;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] candidates1 = {2, 3, 6, 7}, candidates2 = {2, 3, 5};
        int target1 = 7, target2 = 8;
        
        System.out.println(combinationSum(candidates1, target1));
        System.out.println(combinationSum(candidates2, target2));
    }
}
