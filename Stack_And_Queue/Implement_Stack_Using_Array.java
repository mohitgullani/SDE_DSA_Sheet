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
    
        /*
            Push Operation
            TC -> O(1)
            SC -> O(1)
        */
        public void push(int x) {
            arr[++top] = x;
        }
        
        /*
            Pop Operation
            TC -> O(1)
            SC -> O(1)
        */
        public int pop() {
            if(top != -1){
                int element = arr[top];
                arr[top--] = -1;
                return element;
            }else{
                return -1;   
            }
        }
    }

    public static void main(String[] args){
        // Test Cases
        MyStack st = new MyStack();
        String[] operations = {"push", "push", "pop", "push", "pop"};
        int[] nums = {2, 3, -1, 4, -1};
        int n = operations.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String operation = operations[i];
            if(operation.equals("push")){
                int value = nums[i];
                st.push(value);
            }else if(operation.equals("pop")){
                list.add(st.pop());
            }
        }
        System.out.println("Popped Elements: " + list);
    }
}
