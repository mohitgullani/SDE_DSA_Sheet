/*
    Problem Name: Sliding Window Maximum
    Problem Link: https://leetcode.com/problems/sliding-window-maximum/
*/

import java.util.*;

public class Sliding_Window_Maximum {
    /*
        Brute Force Approach
        TC -> O(N * k)
        SC -> O(1), I'm not including result array into my Space Complexity as I'm not using it to solve the probvlem , I'm just using to store the answer that's it and return it
        public static int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] result = new int[n - k + 1];
            for(int i=0;i<=n-k;i++){
                int max = nums[i];
                for(int j=i;j<i+k;j++){
                    if(nums[j] > max)max = nums[j];
                }
                result[i] = max;
            }
            return result;
        }
    */

    /*
        Optimal Solution
        TC -> O(N) + O(N) -> O(2N)
        SC -> O(K)
    */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, index = 0;
        int[] result = new int[n - k + 1];
        Deque<Integer> que = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!que.isEmpty() && que.peek() == i - k){
                que.poll();
            }

            while(!que.isEmpty() && nums[que.peekLast()] <= nums[i]){
                que.pollLast();
            }
            que.offer(i);
            if(i >= k-1){
                result[index++] = nums[que.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7}, nums2 = {1}, nums3 = {1, 3, 1, 2, 0, 5};
        int k1 = 3, k2 = 1, k3 = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums1, k1)));
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2)));
        System.out.println(Arrays.toString(maxSlidingWindow(nums3, k3)));
    }
}
