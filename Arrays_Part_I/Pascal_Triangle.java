// Problem Number & Name: 118. Pascal's Triangle
// Problem Link: https://leetcode.com/problems/pascals-triangle/description/
import java.util.*;

public class Pascal_Triangle {
    /*
        Brute Force Approach
        TC -> O(N) * O(N) * O(R) -> nearly O(N^3)
        SC -> (N) for the innerList, I am not including the list to my SC as I am using list to store the answer not to solve the problem
        public static int getNCR(int n, int r){
            int result = 1;
            for(int i=0;i<r;i++){
                result *= (n - i);
                result /= (i + 1);
            }
            return result;
        }
        public static List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list = new ArrayList<>();
            for(int i=1;i<=numRows;i++){
                List<Integer> innerList = new ArrayList<>();
                for(int j=1;j<=i;j++){
                    innerList.add(getNCR(i-1, j-1));
                }
                list.add(innerList);
            }
            return list;
        }
    */

    /*
        Optimal Solution
        TC -> O(N * N) -> O(N^2)
        SC -> O(N) for the list in getNthRow function
    */
    public static List<Integer> getNthRow(int n){
        List<Integer> list = new ArrayList<>();
        int result = 1;
        list.add(1);
        for(int i=0;i<n;i++){
            result *= (n - i);
            result /= (i + 1);
            list.add(result);
        }
        return list;
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            list.add(getNthRow(i-1));
        }
        return list;
    }
    public static void main(String[] args) {
        // Test Cases
        int n1 = 5, n2 = 1;
        System.out.println(generate(n1));
        System.out.println(generate(n2));
    }
}
