/*
    Problem Name: Search in Binary Search Tree(BST)
    Problem Link: https://leetcode.com/problems/search-in-a-binary-search-tree/
*/

import java.util.*;

public class Search_In_BST {
    /*
        TC -> O(logN)
        SC -> O(1)
    */
    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;
        while(current != null && current.val != val){
            current = (val < current.val) ? current.left : current.right; 
        }
        return current;
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {4, 2, 7, 1, 3};
        Integer[] nums2 = {4, 2, 7, 1, 3};
        int val1 = 2, val2 = 5;

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);

        TreeNode node1 = searchBST(root1, val1);
        TreeNode node2 = searchBST(root2, val2);
        if(node1 != null)   System.out.println(node1.val);
        else    System.out.println(node1);

        if(node2 != null)   System.out.println(node2.val);
        else    System.out.println(node2);
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

    public static class TreeNode{
        int val;
        TreeNode left, right, next;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
}