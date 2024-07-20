/*
    Problem Name: Next Greater Element I
    Problem Link: https://leetcode.com/problems/next-greater-element-i/
*/

import java.util.*;

public class Next_Greater_Element_I {
    /*
        Brute Force Approach
        TC -> O(M^2) + (N)
        SC -> O(2N){For HashMap, I'm not including nge array as I'm not using is to solve the problem}
        Where M = No. of elements in nums2 and N = No. of elements in nums1
        public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int n1 = nums1.length, n2 = nums2.length;
            for(int i=0;i<n2;i++){
                boolean flag = false;
                for(int j=i+1;j<n2;j++){
                    if(nums2[j] > nums2[i]){
                        map.put(nums2[i], nums2[j]);
                        flag = true;
                        break;
                    }
                }
                if(!flag)   map.put(nums2[i], -1);
            }
            int[] nge = new int[n1];
            for(int i=0;i<n1;i++){
                nge[i] = map.get(nums1[i]);
            }
            return nge;
        }
    */

    /*
        Optimal Solution
        TC -> O(N + N) + O(M)
        SC -> O(2N){For HashMap} + O(N){For Stack} -> O(3N)
        Where N = nums2.length and M = nums1.length
    */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n1 = nums1.length, n2 = nums2.length;
        for(int i=n2-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                map.put(nums2[i], -1);
            }
            else{
                map.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }
        int[] nge = new int[n1];
        for(int i=0;i<n1;i++){
            nge[i] = map.get(nums1[i]);
        }
        return nge;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        int[] nums3 = {2, 4}, nums4 = {1, 2, 3, 4};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(nextGreaterElement(nums3, nums4)));
    }
}
