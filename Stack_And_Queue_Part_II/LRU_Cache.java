/*
    Problem Name: LRU Cache
    Problem Link: https://leetcode.com/problems/lru-cache/
*/

import java.util.*;

public class LRU_Cache {

    public static class Node{
        int key, value;
        Node prev = null, next = null;
        Node(){

        }
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static class LRUCache {
        int size, capacity;
        Node head, tail;
        HashMap<Integer, Node> map; 
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }
        
        // TC -> O(1)
        public int get(int key) {
            if(map.containsKey(key)){
                Node temp = map.get(key);
                int value = temp.value;
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;

                temp.next = head.next;
                head.next = temp;
                temp.prev = head;
                temp.next.prev = temp;

                return value;
            }else{
                return -1;
            }
        }

        public void deleteLastNode(){
            int keyToBeDeleted = tail.prev.key;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            map.remove(keyToBeDeleted);
            size -= 1;
        }
        
        // TC -> O(1)
        public void put(int key, int value) {
            if(!map.containsKey(key)){
                if(size >= capacity){
                    deleteLastNode();                
                }
                Node temp = new Node(key, value);
                map.put(key, temp);
                temp.next = head.next;
                head.next = temp;
                temp.prev = head;
                temp.next.prev = temp;
                size += 1;
            }else{
                Node node = map.get(key);
                node.value = value;
                node.prev.next = node.next;
                node.next.prev = node.prev;

                node.next = head.next;
                head.next = node;
                node.prev = head;
                node.next.prev = node;
            }
        }
    }


    public static void main(String[] args) {
        // Test Cases
        String[] actions = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] arr = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};
        int n = arr.length;
        List<String> list = new ArrayList<>();
        LRUCache lru = new LRUCache(arr[0][0]);
        list.add("null");
        for(int i=1;i<n;i++){
            String action = actions[i];
            if(action.equals("put")){
                lru.put(arr[i][0], arr[i][1]);
                list.add("null");
            }else{
                ;
                list.add(lru.get(arr[i][0]) + "");
            }
        }
        System.out.println(list);
    }
}