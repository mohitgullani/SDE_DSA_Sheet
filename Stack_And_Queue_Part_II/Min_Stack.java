/*
    Problem Name: Implement Minimum Stack
    Problem Link: https://leetcode.com/problems/min-stack/
*/

import java.util.*;

public class Min_Stack {
    /*
        Brute Force Approach
        TC -> O(1) for all operations
        SC -> O(2N)
        public static class MinStack {
            Stack<Pair> st;
            public MinStack() {
                st = new Stack<>();
            }
            
            public void push(int val) {
                if(!st.isEmpty()){
                    st.push(new Pair(val, Math.min(val, st.peek().minSoFar)));
                }else{
                    st.push(new Pair(val, val));
                }
            }
            
            public void pop() {
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            
            public int top() {
                return st.peek().value;
            }
            
            public int getMin() {
                return st.peek().minSoFar;
            }
        }
        
        public static class Pair{
            int value;
            int minSoFar;
            Pair(int value, int min){
                this.value = value;
                minSoFar = min;
            }
        }
    */

    /*
        Optimal Solution
        TC -> TC -> O(1) for all operations
        SC -> O(2N)
    */
    public static class MinStack {
        Stack<Long> st;
        Long mini;
        public MinStack() {
            st = new Stack<>();
            mini = Long.MAX_VALUE;
        }
        
        public void push(int value) {
            Long val = Long.valueOf(value);
            if(!st.isEmpty()){
                if(val < mini){
                    st.push(2*val - mini);
                    mini = val;
                }else{
                    st.push(val);
                }
            }else{
                mini = val;
                st.push(val);
            }
        }
        
        public void pop() {
            if(st.isEmpty())    return;

            Long val = st.pop();
            if(val < mini){
                mini = 2 * mini - val;
            }
        }
        
        public int top() {
            if(!st.isEmpty()){
                if(st.peek() < mini){
                    return mini.intValue();
                }else{
                    return st.peek().intValue();
                }
            }else{
                return -1;
            }
        }
        
        public int getMin() {
            return mini.intValue();
        }
    }
    public static void main(String[] args) {
        // Test Cases
        String[] operations = {"MinStack","push","push","push","getMin","pop","top","getMin"};
        int[][] values = {{},{-2},{0},{-3},{},{},{},{}};
        MinStack st = new MinStack();;
        List<String> result = new ArrayList<>();

        for(int i=0;i<operations.length;i++){
            String operation = operations[i];
            if(operation.equals("MinStack")){
                result.add("null");
            }else if(operation.equals("push")){
                st.push(values[i][0]);
                result.add("null");
            }else if(operation.equals("pop")){
                st.pop();
                result.add("null");
            }else if(operation.equals("top")){
                result.add(st.top()+"");
            }else if(operation.equals("getMin")){
                result.add(st.getMin()+"");
            }
        }
        System.out.println(result);
    }
}