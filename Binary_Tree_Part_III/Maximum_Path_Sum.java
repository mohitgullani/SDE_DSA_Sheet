/*
    Problem Name: Maximum Path Sum
    Problem Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
*/

import java.util.*;

public class Maximum_Path_Sum {
    /*
        TC -> O(N)
        SC -> O(Height){Recursion Stack Space}
    */
    public static int maxPathSum(TreeNode root) {
        int[] maxPath = new int[1];
        maxPath[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, maxPath);
        return maxPath[0];
    }

    public static int maxPathSumHelper(TreeNode root, int[] maxPath){
        if(root == null){
            return 0;
        }
        int left = Math.max(0, maxPathSumHelper(root.left, maxPath));
        int right = Math.max(0, maxPathSumHelper(root.right, maxPath));

        maxPath[0] = Math.max(maxPath[0], left + root.val + right);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1, 2, 3, 4, 5, 6, 7, null, 8};
        Integer[] nums2 = {1, 3, 2};
        Integer[] nums3 = {-10,9,20,null,null,15,7};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(maxPathSum(root1));
        System.out.println(maxPathSum(root2));
        System.out.println(maxPathSum(root3));
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