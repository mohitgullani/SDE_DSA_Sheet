/*
    Problem Name: N-Queens Problem
    Problem Link: https://leetcode.com/problems/n-queens/
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {
    /*
        Brute Force Approach
        TC -> O(N! * 3N)
        SC -> O(N^2){for chess board} + O(N){Stack Space}
        public static List<List<String>> solveNQueens(int n) {
            List<List<String>> ans = new ArrayList<>();
            char[][] board = new char[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(board[i], '.');
            }
            solve(0, board, ans, n);
            return ans;
        }

        public static void solve(int col, char[][] board, List<List<String>> ans, int n){
            if(col == n){
                List<String> tempList = new ArrayList<>();
                for(char[] arr: board){
                    StringBuilder sb = new StringBuilder();
                    for(char ch: arr){
                        sb.append(ch);
                    }
                    tempList.add(sb.toString());
                }
                ans.add(tempList);
                return;
            }
            for(int row=0;row<n;row++){
                if(isSafe(row, col, board, n)){
                    board[row][col] = 'Q';
                    solve(col + 1, board, ans, n);
                    board[row][col] = '.';
                }
            }
        }

        public static boolean isSafe(int row, int col, char[][]board, int n){
            int dupRow = row;
            int dupCol = col;
            while(row >= 0 && col >= 0){
                if(board[row][col] == 'Q')  return false;
                row--;
                col--;
            }
            row = dupRow;
            col = dupCol;
            while(col >= 0){
                if(board[row][col] == 'Q')  return false;
                col--;
            }
            row = dupRow;
            col = dupCol;
            while(row < n && col >= 0){
                if(board[row][col] == 'Q')  return false;
                row++;
                col--;
            }
            return true;
        }    
    */

    /*
        Optimal Solution
        TC -> O(N!)
        SC -> O(N^2){for chess board} + O(N){Stack Space}
    */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        boolean[] leftRow = new boolean[n];
        boolean[] upperDiagonal = new boolean[2*n - 1];
        boolean[] lowerDiagonal = new boolean[2*n - 1];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }
        solve(0, board, ans, n, leftRow, lowerDiagonal, upperDiagonal);
        return ans;
    }

    public static void solve(int col, char[][] board, List<List<String>> ans, int n, boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal){
        if(col == n){
            List<String> tempList = new ArrayList<>();
            for(char[] arr: board){
                StringBuilder sb = new StringBuilder();
                for(char ch: arr){
                    sb.append(ch);
                }
                tempList.add(sb.toString());
            }
            ans.add(tempList);
            return;
        }

        for(int row=0;row<n;row++){
            if(!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[n - 1 + col - row]){
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[n - 1 + col - row] = true;
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[n - 1 + col - row] = false;
            }
        }
    }

    public static void main(String[] args) {
        // Test Cases
        int n1 = 4, n2 = 1;
        
        System.out.println(solveNQueens(n1));
        System.out.println(solveNQueens(n2));
    }
}
