/*
    Problem Name: Same Tree
    Problem Link: https://leetcode.com/problems/same-tree/
*/

import java.util.*;

public class Same_Tree {
    /*
        TC -> O(N)
        SC -> O(Height){Auxilliary Space}
    */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return (p == q);
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1, 2, 3, 4, 5};
        Integer[] nums2 = {1, 2, 3, 4, 5};
        Integer[] nums3 = {10, 20};
        Integer[] nums4 = {10, null, 20};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);
        TreeNode root4 = insertLevelOrder(nums4);

        System.out.println(isSameTree(root1, root2));
        System.out.println(isSameTree(root3, root4));
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
