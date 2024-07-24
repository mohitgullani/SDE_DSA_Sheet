/*
    Problem Name: Rotting Oranges
    Problem Link: https://leetcode.com/problems/rotting-oranges/
*/

import java.util.*;

public class Rotten_Oranges {
    /*
        BFS Approach
        TC -> O(N * M) + 4 * O(N * M) -> Approximately O(N * M)
        SC -> O(N * M) + O(N * M) -> O(2 * N * M)
    */
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> que = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    visited[i][j] = 2;
                    que.add(new Pair(i, j, 0));
                }

                if(grid[i][j] == 1){
                    freshOranges += 1;
                }
            }
        }

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        int maxTime = 0;
        while(!que.isEmpty()){
            int row = que.peek().row;
            int col = que.peek().col;
            int time = que.peek().time;
            que.remove();

            for(int i=0;i<4;i++){
                int newRow = row + di[i];
                int newCol = col + dj[i];

                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1 && visited[newRow][newCol] != 2){
                    que.add(new Pair(newRow, newCol, time + 1));
                    maxTime = Math.max(maxTime, time + 1);
                    visited[newRow][newCol] = 2;
                    freshOranges -= 1;
                }
            }
        }

        if(freshOranges != 0){
            return -1;
        }
        return maxTime;
    }

    public static class Pair{
        int row, col, time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        // Test Cases
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] grid3 = {{0, 2}};

        System.out.println(orangesRotting(grid1));
        System.out.println(orangesRotting(grid2));
        System.out.println(orangesRotting(grid3));
    }
}
