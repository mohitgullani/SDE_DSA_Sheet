/*
    Problem Name: Implement Queue using stacks
    Problem Link: https://leetcode.com/problems/implement-queue-using-stacks/
*/

import java.util.*;

public class Implement_Queue_Using_Stack {
    /*
        Brute Force Approach
        public static class MyQueue {
            Stack<Integer> st1, st2;
            public MyQueue() {
                st1 = new Stack<>();
                st2 = new Stack<>();
            }
            
            TC ->O(2N)
            Step 1: st1 -> st2
            Step 2: x -> st1
            Step 3: st2 -> st1
            public void push(int x) {
                while(!st1.isEmpty()){
                    st2.push(st1.pop());
                }
                st1.push(x);
                while(!st2.isEmpty()){
                    st1.push(st2.pop());
                }
            }
            
            TC -> O(1)
            public int pop() {
                if(!st1.isEmpty()){
                    return st1.pop();
                }else{
                    return -1;
                }
            }
            
            TC -> O(1)
            public int peek() {
                if(!st1.isEmpty()){
                    return st1.peek();
                }else{
                    return -1;
                }
            }
            
            TC -> O(1)
            public boolean empty() {
                return st1.isEmpty();
            }
        }
    */

    /*
        Optimal Solution
        Amortized O(1) Method
    */
    public static class MyQueue {
        Stack<Integer> st1, st2;
        public MyQueue() {
            st1 = new Stack<>();
            st2 = new Stack<>();
        }
        
        public void push(int x) {
            st1.push(x);
        }
        
        public int pop() {
            if(!st2.isEmpty()){
                return st2.pop();
            }else{
                while(!st1.isEmpty()){
                    st2.push(st1.pop());
                }
                return st2.isEmpty() ? -1 : st2.pop();
            }
        }
        
        public int peek() {
            if(!st2.isEmpty()){
                return st2.peek();
            }else{
                while(!st1.isEmpty()){
                    st2.push(st1.pop());
                }
                return st2.isEmpty() ? -1 : st2.peek();
            }
        }
        
        public boolean empty() {
            return st1.isEmpty() && st2.isEmpty();
        }
    }

    public static void main(String[] args) {
        // Test Cases
        MyQueue que = new MyQueue();
        String[] operations = {"push", "push", "peek", "pop", "empty"};
        int[] nums = {1, 2, -1, -1, -1};
        int n = operations.length;
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String operation = operations[i];
            if(operation.equals("push")){
                int value = nums[i];
                que.push(value);
                list.add("null");
            }else if(operation.equals("pop")){
                list.add(que.pop()+"");
            }else if(operation.equals("peek")){
                list.add(que.peek()+"");
            }else if(operation.equals("empty")){
                list.add(que.empty()+"");
            }
        }
        System.out.println("Result: " + list);
    }    
}