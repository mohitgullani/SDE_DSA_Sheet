/*
    Problem Name: Online Stock Span
    Problem Link: https://leetcode.com/problems/online-stock-span/
*/

import java.util.*;

public class Online_Stock_Span {
    /*
        public static class StockSpanner {
            List<Integer> list;
            public StockSpanner() {
                list = new ArrayList<>();
            }
            
            Brute Force Approach
            TC -> O(N^2)
            SC -> O(N)
            public int next(int price) {
                list.add(price);
                int count = 1;
                for(int i=list.size() - 2;i>=0;i--){
                    if(list.get(i) <= price){
                        count++;
                    }else{
                        break;
                    }
                }
                return count;
            }
        }
    */

    public static class StockSpanner {
        Stack<Pair> st;
        int index = -1;
        public StockSpanner() {
            index = -1;
            st = new Stack<>();
        }
        
        /*
            Optimal Approach
            TC -> O(2N)
            SC -> O(N)
        */
        public int next(int price) {
            while(!st.isEmpty() && st.peek().price <= price){
                st.pop();
            }
            index += 1;
            int ans = (st.isEmpty()) ? index - (-1) : index - st.peek().index;
            st.push(new Pair(price, index));
            return ans;
        }
    }
    
    public static class Pair{
        int price;
        int index;
        Pair(int price, int index){
            this.price = price;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        // Test Cases
        StockSpanner sp = new StockSpanner();
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        for(int i=0;i<arr.length;i++){
            System.out.print(sp.next(arr[i]) + ", ");
        }
    }
}