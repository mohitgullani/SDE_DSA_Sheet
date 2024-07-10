/*
    Problem Name: Assign Cookies
    Problem Link: https://leetcode.com/problems/assign-cookies/
*/

import java.util.Arrays;

public class Assign_Cookies {
    /*
        Optimal Solution
        TC -> O(NlogN) + O(MlogM) + O(M)
        SC -> O(1)
    */
    public static int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0, n = g.length, m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i < n && j < m){
            if(s[j] >= g[i]){
                i += 1;
            }
            j += 1;
        }
        return i;
    }
    
    public static void main(String[] args) {
        // Test Cases
        int[] g1 = {1, 2, 3}, s1 = {1, 1};
        int[] g2 = {1, 2}, s2 = {1, 2, 3};
        
        System.out.println(findContentChildren(g1, s1));
        System.out.println(findContentChildren(g2, s2));
    }
}
