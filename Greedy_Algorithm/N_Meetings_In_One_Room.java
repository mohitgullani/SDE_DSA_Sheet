/*
    Problem Name: N meetings in one room
    Problem Link: https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
*/

import java.util.*;

public class N_Meetings_In_One_Room {

    /*
        Optimal Solution
        TC -> O(N) + O(NlogN) + O(N) -> O(2N) + O(NlogN)
        SC -> O(3N)
    */
    public static int maxMeetings(int start[], int end[], int n)
    {
        Pair[] pair = new Pair[n];
        for(int i=0;i<n;i++){
            pair[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(pair, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p2.end < p1.end){
                    return 1;
                }else if(p2.end > p1.end){
                    return -1;   
                }else if(p1.start < p2.start){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        
        int count = 1, endTime = pair[0].end;
        for(int i=1;i<n;i++){
            if(pair[i].start > endTime){
                count += 1;
                endTime = pair[i].end;
            }
        }
        return count;
    }
    
    public static class Pair{
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args){
        // Test Cases
        int[] start1 = {1, 3, 0, 5, 8, 5}, end1 = {2, 4, 6, 7, 9, 9};
        int[] start2 = {10, 12, 20}, end2 = {20, 25, 30};
        int n1 = 6, n2 = 3;

        System.out.println(maxMeetings(start1, end1, n1));
        System.out.println(maxMeetings(start2, end2, n2));
    }
}
