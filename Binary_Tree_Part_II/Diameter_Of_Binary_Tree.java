/*
    Problem Name: Diameter of Binary Tree
    Problem Link: https://leetcode.com/problems/diameter-of-binary-tree/
*/

import java.util.*;

public class Diameter_Of_Binary_Tree {
    /*
        Brute Force Approach
        TC -> O(N^2)
        SC -> O(Height)
        public static int diameterOfBinaryTree(TreeNode root) {
            int[] diameter = new int[1];
            diameterOfBinaryTreeHelper(root, diameter);
            return diameter[0];
        }

        public static void diameterOfBinaryTreeHelper(TreeNode root, int[] diameter){
            if(root == null){
                return;
            }

            int lh = getHeight(root.left);
            int rh = getHeight(root.right);
            diameter[0] = Math.max(diameter[0], lh + rh);
            diameterOfBinaryTreeHelper(root.left, diameter);
            diameterOfBinaryTreeHelper(root.right, diameter);
        }

        public static int getHeight(TreeNode root){
            if(root == null){
                return 0;
            }
            int lh = getHeight(root.left);
            int rh = getHeight(root.right);
            return 1 +Math.max(lh, rh);
        }
    */

    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(Height)
    */
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameterOfBinaryTreeHelper(root, diameter);
        return diameter[0];
    }

    public static int diameterOfBinaryTreeHelper(TreeNode root, int[] diameter){
        if(root == null){
            return 0;
        }
        int lh = diameterOfBinaryTreeHelper(root.left, diameter);
        int rh = diameterOfBinaryTreeHelper(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1, 2, 3, 4, 5};
        Integer[] nums2 = {1, 3, 2};
        Integer[] nums3 = {10, 20, 30, 40, 60};
        Integer[] nums4 = {1, 2};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);
        TreeNode root4 = insertLevelOrder(nums4);

        System.out.println(diameterOfBinaryTree(root1));
        System.out.println(diameterOfBinaryTree(root2));
        System.out.println(diameterOfBinaryTree(root3));
        System.out.println(diameterOfBinaryTree(root4));
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
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
}