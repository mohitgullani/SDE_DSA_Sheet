/*
    Problem Name: Validate Binary Search Tree
    Problem Link: https://leetcode.com/problems/validate-binary-search-tree/
*/

import java.util.*;

public class Validate_Binary_Search_Tree {
    /*
        TC -> O(N)
        SC -> O(Height){Recursion Stack Space}
    */
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBSTHelper(TreeNode root, long low, long high){
        if(root == null){
            return true;
        }

        if(root.val >= high || root.val <= low){
            return false;
        }

        return isValidBSTHelper(root.left, low, root.val) && isValidBSTHelper(root.right, root.val, high);
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {2, 1, 3};
        Integer[] nums2 = {5, 1, 4, null, null, 3, 6};
        Integer[] nums3 = {2, 2, 2};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(isValidBST(root1));
        System.out.println(isValidBST(root2));
        System.out.println(isValidBST(root3));
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