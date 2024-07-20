/*
    Problem Name: Implement Queue using Arrays
    Problem Link: https://www.geeksforgeeks.org/problems/implement-queue-using-array/1
*/

import java.util.*;

public class Implement_Queue_Using_Array {
    public static class MyQueue {
        int front, rear, count, n;
        int arr[];
    
        MyQueue(){
            n = 100005;
            arr = new int[n];
            front=0;
            rear=0;
            count=0;
        }
        
        void push(int x){
            if(count < n){
                arr[rear % n] = x;
                rear++;
                count++;
            }else{
                System.out.println("Queue is full, so can't insert " + x);
            }
        } 
    
        int pop(){
            if(count != 0){
                int element = arr[front % n];
                arr[front % n] = -1;
                front++;
                count--;
                return element;
            }else{
                return -1;
            }
        } 
        
        int size(){
            return count;
        }
        
        int isEmpty(){
            return count == 0 ? 1 : 0;
        }
        
        int top(){
            if(count != 0){
                return arr[front % n];
            }else{
                return -1;
            }
        }
    }
    public static void main(String[] args) {
        // Test Cases
        MyQueue que = new MyQueue();
        String[] operations = {"push", "push", "pop", "push", "pop", "top", "size", "isEmpty", "pop", "isEmpty"};
        int[] nums = {2, 3, -1, 4, -1, -1, -1, -1, -1, -1};
        int n = operations.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String operation = operations[i];
            if(operation.equals("push")){
                int value = nums[i];
                que.push(value);
            }else if(operation.equals("pop")){
                list.add(que.pop());
            }else if(operation.equals("top")){
                list.add(que.top());
            }else if(operation.equals("size")){
                list.add(que.size());
            }else if(operation.equals("isEmpty")){
                list.add(que.isEmpty());
            }
        }
        System.out.println("Result: " + list);
    }
}
