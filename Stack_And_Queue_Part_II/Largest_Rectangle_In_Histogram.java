/*
    Problem Name: Largest Rectangle in a Histogram
    Problem Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
*/

import java.util.Stack;

public class Largest_Rectangle_In_Histogram {
    /*
        Brute Force Approach
        TC -> O(N){For Outer Loop} * O(2N){For calculating left & right smaller} -> O(N^2)
        SC -> O(1)
        public static int largestRectangleArea(int[] heights) {
            int n = heights.length, max = 0;
            for(int i=0;i<n;i++){
                int rightSmallerIndex = n, leftSmallerIndex = 0;
                for(int j=i+1;j<n;j++){
                    if(heights[j] < heights[i]){
                        rightSmallerIndex = j;
                        break;
                    }
                }

                for(int j=i-1;j>=0;j--){
                    if(heights[j] < heights[i]){
                        leftSmallerIndex = j + 1;
                        break;
                    }
                }

                max = Math.max(max, (rightSmallerIndex - leftSmallerIndex) * heights[i]);
            }
            return max;
        }
    */

    /*
        Optimal Solution
        TC -> O(2N){For computing left smaller Array} + O(2N){For computing right smaller Array} + O(N){for computing the max rectangle using left and right smaller array}
        SC -> O(N){For Left Smaller Array} + O(N){For Right Smaller Array} -> O(2N)
    */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        int[] left = getLeftSmallerArray(heights);
        int[] right = getRightSmallerArray(heights);
        for(int i=0;i<n;i++){
            max = Math.max(max, (right[i] - left[i]) * heights[i]);
        }
        return max;
    }

    public static int[] getLeftSmallerArray(int[] heights){
        int n = heights.length;
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                left[i] = st.peek()+1;
            }else{
                left[i] = 0;
            }
            st.push(i);
        }
        return left;
    }

    public static int[] getRightSmallerArray(int[] heights){
        int n = heights.length;
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                right[i] = st.peek();
            }else{
                right[i] = n;
            }
            st.push(i);
        }
        return right;
    }
    public static void main(String[] args) {
        // Test Cases
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        int[] heights2 = {2, 4};

        System.out.println(largestRectangleArea(heights1));
        System.out.println(largestRectangleArea(heights2));
    }
}