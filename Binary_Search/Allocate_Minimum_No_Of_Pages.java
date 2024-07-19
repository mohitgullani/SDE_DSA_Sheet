/*
    Problem Name: Allocate Minimum Number of Pages
    Problem Link: https://www.naukri.com/code360/problems/allocate-books_1090540
*/

import java.util.*;

public class Allocate_Minimum_No_Of_Pages {
    /*
        Brute Force Approach
        TC -> O(sum - max + 1) * O(N)
        SC -> O(1)
        public static int findPages(ArrayList<Integer> arr, int n, int m) {
            if(m > n){
                return -1;
            }
            int low = 0, high = 0;
            for(int num: arr){
                low = Math.max(low, num);
                high += num;
            }
            for(int pages=low;pages<=high;pages++){
                int student = getPossibleStudents(arr, pages);
                if(student == m){
                    return pages;
                }
            }
            return -1;
        }

        public static int getPossibleStudents(ArrayList<Integer> arr, int pages){
            int student = 1, studentPages = 0;
            for(int num: arr){
                if(studentPages + num <= pages){
                    studentPages += num;
                }else{
                    student += 1;
                    studentPages = num;
                }
            }
            return student;
        }
    */

    /*
        Optimal Solution
        TC -> O(log(sum - max + 1)) * O(N)
        SC -> O(1)
    */
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m > n){
            return -1;
        }
        int low = 0, high = 0;
        for(int num: arr){
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high){
            int mid = (low + high) >> 1;
            int student = getPossibleStudents(arr, mid);
            if(student <= m){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static int getPossibleStudents(ArrayList<Integer> arr, int pages){
        int student = 1, studentPages = 0;
        for(int num: arr){
            if(studentPages + num <= pages){
                studentPages += num;
            }else{
                student += 1;
                studentPages = num;
            }
        }
        return student;
    }

    public static void main(String[] args) {
        // Test Cases
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int m1 = 2, m2 = 4;
        
        System.out.println(findPages(arr1, arr1.size(), m1));
        System.out.println(findPages(arr2, arr2.size(), m2));
    }
}
