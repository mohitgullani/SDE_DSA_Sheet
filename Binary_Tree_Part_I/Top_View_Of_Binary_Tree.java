/*
    Problem Name: Top View of Binary Tree
    Problem Link: https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
*/

import java.util.*;

public class Top_View_Of_Binary_Tree {
    /*
        BFS Approach or Level Order Traversal
        TC -> O(N)
        SC -> O(N)
    */
    public static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, 0));
        while(!que.isEmpty()){
            TreeNode node = que.peek().node;
            int vertical = que.peek().vertical;
            que.remove();
            
            if(!map.containsKey(vertical)){
                map.put(vertical, node.val);
            }
            if(node.left != null){
                que.add(new Pair(node.left, vertical - 1));
            }
            
            if(node.right != null){
                que.add(new Pair(node.right, vertical + 1));
            }
        }
        
        for(int key: map.keySet()){
            list.add(map.get(key));
        }
        
        return list;
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] nums2 = {1, 2, 3};
        Integer[] nums3 = {10, 20, 30, 40, 60, 90, 100};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(topView(root1));
        System.out.println(topView(root2));
        System.out.println(topView(root3));
    }

    public static class Pair{
        TreeNode node;
        int vertical;
        Pair(TreeNode node, int vertical){
            this.node = node;
            this.vertical = vertical;
        }
    }
    
    public static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode insertLevelOrder(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}