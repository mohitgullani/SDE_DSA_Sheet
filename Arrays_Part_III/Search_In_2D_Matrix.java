/*
    Problem Name: Search a 2D Matrix
    Problem Link: https://leetcode.com/problems/search-a-2d-matrix/description/
*/

import java.util.Arrays;

public class Search_In_2D_Matrix {
    /*
        Brute Force Approach
        TC -> O(N x M)
        SC -> O(1)
        public static boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            int m = matrix[0].length;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
            return false;
        }
    */

    /*
        Better Solution
        TC -> O(N) + O(logM)
        SC -> O(1)
        public static boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            int m = matrix[0].length;
            for(int i=0;i<n;i++){
                if(matrix[i][0] <= target && target <= matrix[i][m-1]){
                    if(Arrays.binarySearch(matrix[i], target) >= 0){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
            return false;
        }
    */

    /*
        Optimal Solution 
        TC -> O(log(N x M))
        SC -> O(1)
    */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = n * m - 1;
        while(low <= high){
            int mid = (low + high)/2;
            int row = mid / m;
            int col = mid % m;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // Test Cases
        int[][] matrix1 = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 60}};
        int[][] matrix2 = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 60}};
        int target1 = 3, target2 = 13;
        System.out.println(searchMatrix(matrix1, target1));
        System.out.println(searchMatrix(matrix2, target2));
    }
}
