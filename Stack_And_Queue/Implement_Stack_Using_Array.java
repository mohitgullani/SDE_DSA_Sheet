/*
    Problem Name: Implement Stack using Arrays
    Problem Link: https://www.geeksforgeeks.org/problems/implement-stack-using-array/1
*/

import java.util.*;

public class Implement_Stack_Using_Array {
    public static class MyStack {
        private int[] arr;
        private int top;
    
        public MyStack() {
            arr = new int[1000];
            Arrays.fill(arr, -1);
            top = -1;
        }
    
        public void push(int x) {
            arr[++top] = x;
        }
        
        public int pop() {
            if(top != -1){
                int element = arr[top];
                arr[top--] = -1;
                return element;
            }else{
                return -1;   
            }
        }

        public int top(){
            return arr[top];
        }

        public int size(){
            return top + 1;
        }

        public int isEmpty(){
            return (top == -1) ? 1 : 0; 
        }
    }

    public static void main(String[] args){
        // Test Cases
        MyStack st = new MyStack();
        String[] operations = {"push", "push", "pop", "push", "pop", "top", "size", "isEmpty", "pop", "isEmpty"};
        int[] nums = {2, 3, -1, 4, -1, -1, -1, -1, -1, -1};
        int n = operations.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String operation = operations[i];
            if(operation.equals("push")){
                int value = nums[i];
                st.push(value);
            }else if(operation.equals("pop")){
                list.add(st.pop());
            }else if(operation.equals("top")){
                list.add(st.top());
            }else if(operation.equals("size")){
                list.add(st.size());
            }else if(operation.equals("isEmpty")){
                list.add(st.isEmpty());
            }
        }
        System.out.println("Result: " + list);
    }
}
