/*
    Problem Name: Rotate Image
    Problem Link: https://leetcode.com/problems/rotate-image/description/
*/

import java.util.*;

public class Rotate_Matrix{
    /*
        Brute force Solution
        TC -> O(N^2) + O(N^2) -> O(2N^2)
        SC -> O(N^2)
        public static void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] rotatedMatrix = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    rotatedMatrix[j][n - i - 1] = matrix[i][j];
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = rotatedMatrix[i][j];
                }
            }
            display(matrix);
        }
    */

    /*
        Optimal Solution
        TC -> O(N^2) + O(N^2) -> O(2N^2)
        SC -> O(1)
    */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // Taking transpose of the matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reversing each row after the transpose
        for(int i=0;i<n;i++){
            reverse(matrix[i], 0, n - 1);
        }
        display(matrix);
    }

    public static void reverse(int[] row, int i, int j ){
        while(i < j){
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){
        int[][] matrix1 = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        int[][] matrix2 = {{5, 1, 9, 11},{2, 4, 8, 10},{13, 3, 6, 7},{15,14,12,16}};
        rotate(matrix1);
        rotate(matrix2);
    }

    public static void display(int[][] matrix){
        for(int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("----------------------------------");
    }
}