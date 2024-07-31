/*
    Problem Name: Symmetric Tree
    Problem Link: https://leetcode.com/problems/symmetric-tree/
*/

import java.util.*;

public class Symmetric_Tree {
    /*
        Optimal Approach
        TC -> O(N)
        SC -> O(Height)
    */
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root, root);
    }

    public static boolean isSymmetricHelper(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null){
            return (root1 == root2);
        }
        if(root1.val != root2.val){
            return false;
        }
        return isSymmetricHelper(root1.left, root2.right) && isSymmetricHelper(root1.right, root2.left);
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1,2,2,3,4,4,3};
        Integer[] nums2 = {1,2,2,null,3,null,3};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);

        System.out.println(isSymmetric(root1));
        System.out.println(isSymmetric(root2));
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