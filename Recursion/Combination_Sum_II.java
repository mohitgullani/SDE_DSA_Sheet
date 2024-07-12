/*
    Problem Name: Combination Sum-II
    Problem Link: https://leetcode.com/problems/combination-sum-ii/
*/

import java.util.*;

public class Combination_Sum_II {
    /*
        TC -> O(2^N * K)
        SC -> O(X * K)
        where K is the average time to copy each sub set to list
    */
    public static void combinationSum2Helper(int index, int target, int n, int[] candidates, List<Integer> ds, List<List<Integer>> list){
        if(target == 0){
            list.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index;i<n;i++){
            if(i != index && candidates[i] == candidates[i - 1])    continue;
            if(candidates[i] > target)  break;

            ds.add(candidates[i]);
            combinationSum2Helper(i + 1, target - candidates[i], n, candidates, ds, list);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        int n = candidates.length;
        combinationSum2Helper(0, target, n, candidates, new ArrayList<>(), list);
        return list;
    }
    public static void main(String[] args) {
        // Test Cases
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5}, candidates2 = {2, 5, 2, 1, 2};
        int target1 = 8, target2 = 5;
        
        System.out.println(combinationSum2(candidates1, target1));
        System.out.println(combinationSum2(candidates2, target2));
    }
}
