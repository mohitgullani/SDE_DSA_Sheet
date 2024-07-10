/*
    Problem Name: Subset Sums
    Problem Link: https://www.geeksforgeeks.org/problems/subset-sums2234/1
*/

import java.util.*;

public class Subset_Sums {
    /*
        TC -> O(2^N) + O(2^n * log(2^n))
        SC -> O(2^N), I'm using this space to store the answer not for solving!
    */
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        subsetSumHelper(0, arr, 0, result);
        Collections.sort(result);
        return result;
    }
    
    public static void subsetSumHelper(int index, ArrayList<Integer> arr, int sum, ArrayList<Integer> result){
        if(index == arr.size()){
            result.add(sum);
            return;
        }
        // Pick the Element
        subsetSumHelper(index + 1, arr, sum + arr.get(index), result);

        // Do not Pick the Element
        subsetSumHelper(index + 1, arr, sum, result);
    }
    public static void main(String[] args) {
        // Test Cases
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(2, 3));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(5, 2, 1));

        System.out.println(subsetSums(arr1, arr1.size()));
        System.out.println(subsetSums(arr2, arr2.size()));
    }
}
