/*
    Problem Name: Implement Stack using 2 Queues
    Problem Link: https://leetcode.com/problems/implement-stack-using-queues/
*/

import java.util.*;

public class Implement_Stack_Using_Two_Queue {
    public static class MyStack {
        Queue<Integer> que1, que2;
        public MyStack() {
            que1 = new ArrayDeque<>();
            que2 = new ArrayDeque<>();
        }
        
        // TC -> O(No. of Elements in the Queue)
        public void push(int x) {
            que2.add(x);
            while(!que1.isEmpty()){
                que2.add(que1.remove());
            }
            Queue<Integer> temp = que1;
            que1 = que2;
            que2 = temp;
        }
        
        // TC -> O(1)
        public int pop() {
            if(!que1.isEmpty()){
                return que1.remove();
            }else{
                return -1;
            }
        }
        
        // TC -> O(1)
        public int top() {
            if(!que1.isEmpty()) return que1.peek();
            else    return -1;
        }
        
        // TC -> O(1)
        public boolean empty() {
            return que1.isEmpty();
        }
    }
    public static void main(String[] args) {
        // Test Cases
        MyStack st = new MyStack();
        String[] operations = {"push", "push", "top", "pop", "empty"};
        int[] nums = {1, 2, -1, -1, -1};
        int n = operations.length;
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String operation = operations[i];
            if(operation.equals("push")){
                int value = nums[i];
                st.push(value);
                list.add("null");
            }else if(operation.equals("pop")){
                list.add(st.pop()+"");
            }else if(operation.equals("top")){
                list.add(st.top()+"");
            }else if(operation.equals("empty")){
                list.add(st.empty()+"");
            }
        }
        System.out.println("Result: " + list);
    }
}
