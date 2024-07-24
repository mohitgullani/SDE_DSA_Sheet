/*
    Problem Name: Inorder Traversal of Binary Tree
    Problem Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
*/

import java.util.*;

public class Inorder_Traversal {
    /*
        Left : Root : Right
        TC -> O(N) {As we are visiting each node exactly once}
        SC -> O(N){In the worst case due to recursion stack} otherwise it's O(logN){Recursion Stack Space}
    */
    public static void inorderTraversalHelper(TreeNode root, List<Integer> list){
        if(root == null)    return;

        inorderTraversalHelper(root.left, list);
        list.add(root.val);
        inorderTraversalHelper(root.right, list);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);
        return list;
    }

    public static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1, null, 2, 3};
        Integer[] nums2 = {};
        Integer[] nums3 = {1};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(inorderTraversal(root1));
        System.out.println(inorderTraversal(root2));
        System.out.println(inorderTraversal(root3));
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