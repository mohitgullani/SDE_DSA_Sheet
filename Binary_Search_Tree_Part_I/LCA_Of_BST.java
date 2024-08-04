/*
    Problem Name: Lowest Common Ancestor of a Binary Search Tree
    Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
*/

import java.util.*;

public class LCA_Of_BST {
    /*
        Brute Force Approach
        TC -> O(N)
        SC -> O(Height){Recursion Stack Space}
        public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
            if(root == null || root.val == p || root.val == q){
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left == null){
                return right;
            }else if(right == null){
                return left;
            }else{
                return root;
            }
        }
    */

    /*
        Optimal Solution
        TC -> O(Height)
        SC -> O(Height){Recursion Stack Space}
    */
    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null){
            return root;
        }

        if(p < root.val && q < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p > root.val && q > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        Integer[] nums2 = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        Integer[] nums3 = {2, 1};
        int p1 = 2, p2 = 2, p3 = 2;
        int q1 = 8, q2 = 4, q3 = 1;

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(lowestCommonAncestor(root1, p1, q1).val);
        System.out.println(lowestCommonAncestor(root2, p2, q2).val);
        System.out.println(lowestCommonAncestor(root3, p3, q3).val);
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