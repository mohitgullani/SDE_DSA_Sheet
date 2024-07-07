/*
    Problem Name: Trapping Rain Water
    Problem Link: https://leetcode.com/problems/trapping-rain-water/
*/

public class Trapping_Rain_Water {
    /*
        Brute Force Approach
        TC -> O(N^2)
        SC -> O(1)
        public static int trap(int[] height) {
            int result = 0;
            int n = height.length;
            for(int i=0;i<n;i++){
                int leftMax = getLeftMax(i, height);
                int rightMax = getRightMax(i, height);
                result += Math.min(leftMax, rightMax) - height[i];
            }
            return result;
        }

        public static int getLeftMax(int end, int[] height){
            int leftMax = 0;
            for(int i=0;i<=end;i++){
                if(height[i] > leftMax){
                    leftMax = height[i];
                }
            }
            return leftMax;
        }

        public static int getRightMax(int start, int[] height){
            int rightMax = 0;
            for(int i=start;i<height.length;i++){
                if(height[i] > rightMax){
                    rightMax = height[i];
                }
            }
            return rightMax;
        }
    */

    /*
        Better Solution
        TC -> O(N) + O(N) + O(N) -> O(3N) -> Similar to O(N)
        SC -> O(N) + O(N) -> O(2N)
        public static int trap(int[] height) {
            int n = height.length;
            int leftMax = 0, rightMax = 0;
            int[] left = new int[n];
            int[] right = new int[n];
            // Calculating Left Max
            for(int i=0;i<n;i++){
                leftMax = Math.max(height[i], leftMax);
                left[i] = leftMax;
            }
            // Calculating Right Max
            for(int i=n-1;i>=0;i--){
                rightMax = Math.max(height[i], rightMax);
                right[i] = rightMax;
            }
            int result = 0;
            for(int i=0;i<n;i++){
                result += Math.min(left[i], right[i]) - height[i];
            }
            return result;
        }
    */

    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(1)
    */
    public static int trap(int[] height) {
        int result = 0;
        int n = height.length;
        int left = 0, right = n-1;
        int leftMax = 0, rightMax = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    result += leftMax - height[left];
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    result += rightMax - height[right];
                }
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};

        System.out.println(trap(height1));
        System.out.println(trap(height2));
    }
}
