/*
    Problem Name: Rat in a Maze
    Problem Link: https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
*/

import java.util.ArrayList;

public class Rat_In_A_Maze {
    /*
        Simple Recursive Approach
        TC -> 4^(n*m)
        SC -> O(N*M){For Visited Array} + O(N*M){Recursion Stack Space}
    */
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> list = new ArrayList<>();
        if(m[0][0] == 0 || m[n - 1][n - 1] == 0)    return list;
        boolean[][] visited = new boolean[n][n];
        solve(0, 0, m, n, "", visited, list);
        return list;
    }
    
    public static void solve(int row, int col, int[][] m, int n, String asf, boolean[][] visited, ArrayList<String> list){
        if(row == n - 1 && col == n - 1){
            list.add(asf);
            return;
        }
        visited[row][col] = true;
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};
        for(int i=0;i<4;i++){
            int newRow = row + di[i];
            int newCol = col + dj[i];
            if(newRow >= 0 && newCol >= 0 &&  newRow < n && newCol < n && m[newRow][newCol] == 1 && !visited[newRow][newCol]){
                solve(newRow, newCol, m, n, asf + dir[i], visited, list);
            }
        }
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        // Test Cases
        int[][] matrix1 = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        int[][] matrix2 = {{1, 0}, {1, 0}};
        int n1 = 4, n2 = 2;

        System.out.println(findPath(matrix1, n1));
        System.out.println(findPath(matrix2, n2));
    }
}
