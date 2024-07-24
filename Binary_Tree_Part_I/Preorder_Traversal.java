/*
    Problem Name: Preorder Traversal
    Problem Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
*/

import java.util.*;

public class Preorder_Traversal {
    /*
        Root : Left : Right
        TC -> O(N) {As we are visiting each node exactly once}
        SC -> O(N){In the worst case due to recursion stack} otherwise it's O(logN){Recursion Stack Space}
    */
    public static void preorderTraversalHelper(TreeNode root, List<Integer> list){
        if(root == null)    return;

        list.add(root.val);
        preorderTraversalHelper(root.left, list);
        preorderTraversalHelper(root.right, list);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalHelper(root, list);
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

        System.out.println(preorderTraversal(root1));
        System.out.println(preorderTraversal(root2));
        System.out.println(preorderTraversal(root3));
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