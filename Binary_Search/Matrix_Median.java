/*
    Problem Name: Matrix Median
    Problem Link: https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
*/

import java.util.*;

public class Matrix_Median {
    /*
        Brute Force Approach
        TC -> O(N * M) + O(N * M(log(N * M)))
        SC -> O(N * M)
        public static int median(int matrix[][], int n, int m) {
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    list.add(matrix[i][j]);
                }
            }
            Collections.sort(list);
            return list.get((n*m)/2);
        }
    */

    /*
        Optimal Solution
        TC -> O(N) + O(log(10^9)){For Binary Search} * (N * log(M)){small Equals function}
        SC -> O(1)
    */
    public static int median(int matrix[][], int n, int m) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][m-1]);
        }
        int low = min, high = max;
        int required = (n*m) / 2;
        while(low <= high){
            int mid = (low + high) / 2;
            int smallEquals = getSmallEquals(matrix, mid);
            if(smallEquals <= required){
               low = mid + 1; 
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    
    public static int getSmallEquals(int[][] matrix, int mid){
        int count = 0;
        for(int i=0;i<matrix.length;i++){
            count += upperBound(matrix[i], mid);
        }
        return count;
    }
    
    public static int upperBound(int[] nums, int search){
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] <= search){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        // Test Cases
        int[][] matrix1 = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        int[][] matrix2 = {{1}, {2}, {3}};

        System.out.println(median(matrix1, matrix1.length, matrix1[0].length));
        System.out.println(median(matrix2, matrix2.length, matrix2[0].length));
    }
}
