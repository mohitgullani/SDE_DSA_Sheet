/*
    Problem Name: Unique Paths
    Problem Link: https://leetcode.com/problems/unique-paths/description/
*/

import java.util.Arrays;

public class Unique_Paths {
    /*
        Brute Force Approach
        TC -> Exponential
        SC -> O(log(N x M)), auxillary space
        public static int uniquePathsHelper(int row, int col, int m, int n){
            if(row == m-1 && col == n-1)    return 1;
            if(row >= m || col >= n)    return 0;
            int right = uniquePathsHelper(row, col + 1, m, n);
            int bottom = uniquePathsHelper(row + 1, col, m, n);
            return right + bottom;
        }

        public static int uniquePaths(int m, int n) {
            return uniquePathsHelper(0, 0, m, n);        
        }
    */

    /*
        Better Solution
        DP Memoization solution
        TC -> O(N x M)
        SC -> O(N x M) + O(log(N x M)), where O(log(N x M)) is the Auzillary Stack Space
        public static int uniquePathsHelper(int row, int col, int m, int n, int[][] dp){
            if(row == m-1 && col == n-1)    return 1;
            if(row >= m || col >= n)    return 0;
            if(dp[row][col] != -1)  return dp[row][col];
            int right = uniquePathsHelper(row, col + 1, m, n, dp);
            int bottom = uniquePathsHelper(row + 1, col, m, n, dp);
            return dp[row][col] = right + bottom;
        }

        public static int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for(int i=0;i<m;i++){
                Arrays.fill(dp[i], -1);
            }
            return uniquePathsHelper(0, 0, m, n, dp);        
        }
    */

    /*
        Optimal Solution
        DP Tabulation Method
        TC -> O(N x M)
        SC -> O(N x M)
        public static int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for(int i=m-1;i>=0;i--){
                for(int j=n-1;j>=0;j--){
                    if(i == m-1 || j == n-1){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i+1][j] + dp[i][j+1];
                    }
                }
            }
            return dp[0][0];
        }
    */

    /*
        Most Optimal Solution
        We can solve using the NCR approach also
        TC -> O(min(m, n))
        SC -> O(1)
    */
    public static int uniquePaths(int m, int n) {
        // int N = (m - 1) + (n - 1)
        int N = m + n - 2;
        int R;
        if(m < n)   R = m - 1;
        else    R = n - 1;
        // Now simply calculate the NCR
        long result = 1;
        for(int i=0;i<R;i++){
            result *= (N - i);
            result /= (i + 1);
        }
        return (int)result;
    }
    public static void main(String[] args) {
        int m1 = 3, n1 = 7;
        int m2 = 3, n2 = 2;
        System.out.println(uniquePaths(m1, n1));
        System.out.println(uniquePaths(m2, n2));
    }
}
