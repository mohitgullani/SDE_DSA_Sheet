/*
    Problem Name: K-th Element of Two Sorted Arrays
    Problem Link: https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
*/

public class Kth_Element_In_2_Sorted_Array {
    /*
        Brute Force Approach
        TC -> O(N + M)
        SC -> O(N + M)
        public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
            int[] result = getMergedArray(arr1, arr2, n, m);
            return result[k - 1];
        }
        
        public static int[] getMergedArray(int[] arr1, int[] arr2, int n, int m){
            int i = 0, j = 0, k = 0;
            int[] result = new int[n + m];
            while(i < n && j < m){
                if(arr1[i] <= arr2[j]){
                    result[k++] = arr1[i++];
                }else{
                    result[k++] = arr2[j++];
                }
            }
            
            while(i < n){
                result[k++] = arr1[i++];
            }
            
            while(j < m){
                result[k++] = arr2[j++];
            }
            return result;
        }
    */

    /*
        Better Solution
        TC -> O(N + M)/2
        SC -> O(1)
        public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
            int i = 0, j = 0;
            int count = 0, element = -1;
            while(i < n && j < m){
                count += 1;
                if(arr1[i] <= arr2[j]){
                    if(count == k){
                        element = arr1[i];
                        break;
                    }
                    i++;
                }else{
                    if(count == k){
                        element = arr2[j];
                        break;
                    }
                    j++;
                }
                
            }
            
            while(i < n){
                count += 1;
                if(count == k){
                    element = arr1[i];
                    break;
                }
                i++;
            }
            
            while(j < m){
                count += 1;
                if(count == k){
                    element = arr2[j];
                    break;
                }
                j++;
            }
            return element;
        }
    */

    /*
        Optimal Solution
        TC -> O(Min(logN, logM))
        SC -> O(1)
    */
    public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n > m){
            return kthElement(arr2, arr1, m, n, k);
        }
        int low = Math.max(0, k - m), high = Math.min(k, n);
        while(low <= high){
            int mid1 = (low + high) >> 1;
            int mid2 = k - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            
            if(mid1 < n)    r1 = arr1[mid1];
            if(mid2 < m)    r2 = arr2[mid2];
            if(mid1 - 1 >= 0)   l1 = arr1[mid1 - 1];
            if(mid2 - 1 >= 0)   l2 = arr2[mid2 - 1];
            
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }else if(l1 > r2){
                high = mid1 - 1;
            }else{
                low = mid1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] arr1 = {2, 3, 6, 7, 9}, arr2 = {1, 4, 8, 10};
        int[] arr3 = {100, 112, 256, 349, 770}, arr4 = {72, 86, 113, 119, 265, 445, 892};
        int k1 = 5, k2 = 7;

        System.out.println(kthElement(arr1, arr2, arr1.length, arr2.length, k1));
        System.out.println(kthElement(arr3, arr4, arr3.length, arr4.length, k2));
    }
}
