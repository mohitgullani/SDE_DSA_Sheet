/*
    Problem Name: Minimum Platforms
    Problem Link: https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
*/

import java.util.*;

public class Minimum_Platforms {
    /*
        Brute Force Approach
        TC -> O(N^2)
        SC -> O(1)
        public static int findPlatform(int arr[], int dep[], int n){
            int maxCount = 1;
            for(int i=0;i<n;i++){
                int count = 1;
                for(int j=i+1;j<n;j++){
                    if((arr[j] < arr[i] && dep[j] < arr[i]) || (arr[j] > dep[i] && dep[j] > dep[i])){
                        continue;
                    }else{
                        count++;
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
            return maxCount;
        }
    */

    /*
        Better Solution
        TC -> O(N) + O(N) + O(2Nlog2N) + O(2N) -> O(4N) + O(2Nlog2N)
        SC -> O(2N)
        public static int findPlatform(int arr[], int dep[], int n){
            Pair[] pair = new Pair[2*n];
            int index = 0;
            for(int i=0;i<n;i++){
                pair[index++] = new Pair(arr[i], 'A');
            }
            
            for(int i=0;i<n;i++){
                pair[index++] = new Pair(dep[i], 'D');
            }
            
            Arrays.sort(pair, new Comparator<Pair>(){
                @Override
                public int compare(Pair p1, Pair p2){
                    return p1.time - p2.time;
                }
            });
            int count = 0, maxCount = 0;
            for(int i=0;i<2*n;i++){
                int time = pair[i].time;
                int status = pair[i].status;
                if(status == 'A'){
                    count++;
                }else{
                    count--;
                }
                maxCount = Math.max(maxCount, count);
            }
            
            return maxCount;
        }
        
        public static class Pair{
            int time;
            char status;
            Pair(int time, char status){
                this.time = time;
                this.status = status;
            }
        }
    */

    /*
        Optimal Solution
        TC -> O(NlogN) + O(NlogN) + O(2N) -> O(2N) + O(2NlogN)
        SC -> O(1)
    */
    public static int findPlatform(int arr[], int dep[], int n){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platforms = 0, maxPlatforms = 0, i = 0, j = 0;
        while(i < n){
            if(arr[i]<= dep[j]){
                platforms++;
                i++;
            }else{
                platforms--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }
        return maxPlatforms;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] start1 = {900, 940, 950, 1100, 1500, 1800}, start2 = {900, 1235, 1100}, start3 = {1000, 935, 1100};
        int[] end1 = {910, 1200, 1120, 1130, 1900, 2000}, end2 = {1000, 1240, 1200}, end3 = {1200, 1240, 1130};
        int n1 = 6, n2 = 3, n3 = 3;

        System.out.println(findPlatform(start1, end1, n1));
        System.out.println(findPlatform(start2, end2, n2));
        System.out.println(findPlatform(start3, end3, n3));
    }
}
