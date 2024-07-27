/*
    Problem Name: Balanced Binary Tree
    Problem Link: https://leetcode.com/problems/balanced-binary-tree/
*/

import java.util.LinkedList;
import java.util.Queue;

public class Balanced_Binary_Tree {
    /*
        Brute Force Approach
        TC -> O(N^2)
        SC -> O(Height)
        public static boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            int lh = getHeight(root.left);
            int rh = getHeight(root.right);

            if(Math.abs(lh - rh) > 1){
                return false;
            }

            boolean left = isBalanced(root.left);
            if(!left)   return false;
            boolean right = isBalanced(root.right);
            if(!right)   return false;
            return true;
        }

        public static int getHeight(TreeNode root){
            if(root == null){
                return 0;
            }
            int lh = getHeight(root.left);
            int rh = getHeight(root.right);
            return 1 + Math.max(lh, rh);
        }
    */

    /*
        Optimal Approach
        TC -> O(N)
        SC -> O(Height)
    */
    public static boolean isBalanced(TreeNode root) {
        return check(root) == -1 ? false : true;
    }

    public static int check(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = check(root.left);
        if(lh == -1)    return -1;
        int rh = check(root.right);
        if(rh == -1)    return -1;

        if(Math.abs(lh - rh) > 1){
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {3, 9, 20, null, null, 15, 7};
        Integer[] nums2 = {1, 2, 2, 3, 3, null, null, 4, 4, null, null};
        Integer[] nums3 = {};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(isBalanced(root1));
        System.out.println(isBalanced(root2));
        System.out.println(isBalanced(root3));
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
