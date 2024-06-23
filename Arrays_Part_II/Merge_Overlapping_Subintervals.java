/*
    Problem Name: Merge Intervals
    Problem Link: https://leetcode.com/problems/merge-intervals/
*/

import java.util.*;

public class Merge_Overlapping_Subintervals {

    public static class Pair{
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    /*
        Optimal Solution
        TC -> O(NlogN) + O(N) + O(N) -> o(NlogN) + O(2N)
        SC -> O(N)
    */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0]){
                    return arr1[1] - arr2[1];
                }else{
                    return arr1[0] - arr2[0];
                }
            }
        });
        Stack<Pair> st = new Stack<>(); 
        for(int[] arr: intervals){
            if(st.isEmpty() || st.peek().end < arr[0]){
                st.push(new Pair(arr[0], arr[1]));
                continue;
            }
            if(arr[0] <= st.peek().end){
                st.peek().end = Math.max(st.peek().end, arr[1]);
            }
        }

        int[][] result = new int[st.size()][2];
        int index = st.size() - 1;
        while(!st.isEmpty()){
            result[index][0] = st.peek().start;
            result[index][1] = st.peek().end;
            index--;
            st.pop();
        }
        return result;
    }

    public static void main(String[] args){
        // Test Cases
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals2 = {{1,4},{4,5}};
        int[][] intervals3 = {{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};
        int[][] mergedArray1 = merge(intervals1);
        int[][] mergedArray2 = merge(intervals2);
        int[][] mergedArray3 = merge(intervals3);
        display(mergedArray1);
        display(mergedArray2);
        display(mergedArray3);
    }

    public static void display(int[][] intervals){
        for(int[] arr: intervals){
            System.out.print(Arrays.toString(arr) + ", ");
        }
        System.out.println();
        System.out.println("-----------------------------------------");
    }
}
