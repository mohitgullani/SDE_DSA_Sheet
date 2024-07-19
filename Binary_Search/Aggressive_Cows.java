/*
    Problem Name: Aggressive Cows
    Problem Link: https://www.geeksforgeeks.org/problems/aggressive-cows/0
*/

import java.util.Arrays;

public class Aggressive_Cows {
    /*
        Brute Force Approach
        TC -> O(max - min) * O(N)
        SC -> O(1)
        public static int solve(int n, int k, int[] stalls) {
            int min = 0, max = 0;
            Arrays.sort(stalls);
            int low = 1, high = stalls[n - 1] - stalls[0];
            for(int i=low;i<=high;i++){
                if(!canWePlaceCows(stalls, i, k)){
                    return (i - 1);
                }
            }
            return -1;
        }
        
        public static boolean canWePlaceCows(int[] stalls, int dist, int cows){
            int cowPlaced = 1, lastCow = stalls[0];
            for(int i=1;i<stalls.length;i++){
                if((stalls[i] - lastCow) >= dist){
                    cowPlaced += 1;
                    lastCow = stalls[i];
                }
                
                if(cowPlaced == cows){
                    return true;
                }
            }
            return false;
        }
    */

    /*
        Optimal Solution -> Binary Search
        TC -> O(log(max - min)) * O(N)
        SC -> O(1)
    */
    public static int solve(int n, int k, int[] stalls) {
        int min = 0, max = 0;
        Arrays.sort(stalls);
        int low = 1, high = stalls[n - 1] - stalls[0];
        while(low <= high){
            int mid = (low + high) >> 1;
            
            if(canWePlaceCows(stalls, mid, k)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
    
    public static boolean canWePlaceCows(int[] stalls, int dist, int cows){
        int cowPlaced = 1, lastCow = stalls[0];
        for(int i=1;i<stalls.length;i++){
            if((stalls[i] - lastCow) >= dist){
                cowPlaced += 1;
                lastCow = stalls[i];
            }
            
            if(cowPlaced == cows){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] stalls1 = {1, 2, 4, 8, 9}, stalls2 = {10, 1, 2, 7, 5};
        int k1 = 3, k2 = 3;

        System.out.println(solve(stalls1.length, k1, stalls1));
        System.out.println(solve(stalls2.length, k2, stalls2));
    }
}
