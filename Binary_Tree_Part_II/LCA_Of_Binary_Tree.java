/*
    Problem Name: Lowest Common Ancestor of Binary Tree
    Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/

import java.util.*;

public class LCA_Of_Binary_Tree {
    /*
        Brute Force Approach
        TC -> 2N + O(Height)
        SC -> 2 * O(Height){For 2 list} + 2 * O(Height){Auxilliary Stack Space}
        public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
            List<TreeNode> list1 = new ArrayList<>();
            List<TreeNode> list2 = new ArrayList<>();
            getPath(root, p, list1);
            getPath(root, q, list2);
            int i = 0;
            while(i < list1.size() && i < list2.size() && list1.get(i) == list2.get(i)){
                i++;
            }
            return list1.get(i - 1);
        }

        public static boolean getPath(TreeNode root, int node, List<TreeNode> list){
            if(root == null){
                return false;
            }

            list.add(root);
            if(root.val == node){
                return true;
            }
            if(getPath(root.left, node, list) || getPath(root.right, node, list)){
                return true;
            }
            list.remove(list.size() - 1);
            return false;
        }
    */

    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(1)
    */
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

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Integer[] nums2 = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Integer[] nums3 = {1, 2};
        int p1 = 5, p2 = 5, p3 = 1, q1 = 1, q2 = 4, q3 = 2;
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
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
}
