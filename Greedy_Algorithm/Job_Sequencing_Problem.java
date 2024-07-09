/*
    Problem Name: Job Sequencing Problem
    Problem Link: https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
*/

import java.util.Arrays;
import java.util.Comparator;

public class Job_Sequencing_Problem {
    /*
        TC -> O(NlogN) + O(N) + O(N * maxDeadline)
        SC -> O(maxDeadline)
    */
    public static int[] JobScheduling(Job arr[], int n){
        int maxProfit = 0, count = 0, maxDeadline = -1;
        Arrays.sort(arr, new Comparator<Job>(){
            @Override
            public int compare(Job j1, Job j2){
                if(j1.profit < j2.profit){
                    return 1;
                }else if(j1.profit > j2.profit){
                    return -1;
                }else if(j1.deadline < j2.deadline){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        for(Job job: arr){
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        int[] dead = new int[maxDeadline + 1];
        Arrays.fill(dead, -1);
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(dead[j] == -1){
                    count += 1;
                    maxProfit += arr[i].profit;
                    dead[j] = arr[i].id;
                    break;
                }
            }
        }
        
        return new int[]{count, maxProfit};
    }

    public static void main(String[] args) {
        // Test Cases
        int[] deadline1 = {4, 1, 1, 1}, deadline2 = {2, 1, 2, 1, 1};
        int[] profit1 = {20, 10, 40, 30}, profit2 = {100, 19, 27, 25, 15};
        int n1 = 4, n2 = 5;
        
        Job[] arr1 = new Job[n1];
        Job[] arr2 = new Job[n2];

        for(int i=0;i<n1;i++){
            arr1[i] = new Job(i+1, deadline1[i], profit1[i]);
        }

        for(int i=0;i<n2;i++){
            arr2[i] = new Job(i+1, deadline2[i], profit2[i]);
        }
        int[] result1 = JobScheduling(arr1, n1);
        int[] result2 = JobScheduling(arr2, n2);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    public static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z; 
        }
    }
}
