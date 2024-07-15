/*
    Problem Name: M Coloring Problem
    Problem Link: https://leetcode.com/problems/flower-planting-with-no-adjacent/
*/

import java.util.*;

public class M_Color {
    /*
        TC -> O(4^N)*N
        SC -> O(N){for result or color array} + O(N){Recursion Stack Space}
        I am not including Adjancy List creation to my TC & SC
    */
    public static int[] gardenNoAdj(int n, int[][] paths, int m) {
        List<List<Integer>> adj = getAdjancyList(paths, n);
        int[] result = new int[n];
        solve(1, adj, result, n, m);
        return result;
    }

    public static boolean solve(int node, List<List<Integer>> adj, int[] result, int n, int m){
        if(node == n + 1){
            return true;
        }

        for(int col=1;col<=m;col++){
            if(isPossible(node, col, adj, result)){
                result[node - 1] = col;
                if(solve(node + 1, adj, result, n, m)){
                    return true;
                }
                result[node - 1] = 0;
            }
        }
        return false;
    }

    public static boolean isPossible(int node, int col, List<List<Integer>> adj, int[] result){
        for(int it: adj.get(node)){
            if(result[it - 1] == col){
                return false;
            }
        }
        return true;
    }

    public static List<List<Integer>> getAdjancyList(int[][] paths, int n){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] path: paths){
            adj.get(path[0]).add(path[1]);
            adj.get(path[1]).add(path[0]);
        }
        return adj;
    }

    public static void main(String[] args) {
        // Test Cases
        int[][] paths1 = {{1, 2}, {2, 3}, {3, 1}};
        int[][] paths2 = {{1, 2}, {3, 4}};
        int[][] paths3 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}};
        int n1 = 3, n2 = 4, n3 = 4;
        int m1 = 4, m2 = 4, m3 = 4;
        
        int[] color1 = gardenNoAdj(n1, paths1, m1);
        int[] color2 = gardenNoAdj(n2, paths2, m2);
        int[] color3 = gardenNoAdj(n3, paths3, m3);

        System.out.println(Arrays.toString(color1));
        System.out.println(Arrays.toString(color2));
        System.out.println(Arrays.toString(color3));
    }
}
