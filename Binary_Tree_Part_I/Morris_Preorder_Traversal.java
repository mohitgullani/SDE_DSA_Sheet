/*
    Problem Name: Preorder Traversal of Binary Tree using Morris Traversal
    Problem Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
*/

import java.util.*;

public class Morris_Preorder_Traversal {
    /*
        Preorder using Morris Traversal
        TC -> O(N) + O(N) -> Approximately O(N)
        SC -> O(1)
    */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                preorder.add(current.val);
                current = current.right;
            }else{
                TreeNode prev = current.left;
                while(prev.right != null && prev.right != current){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = current;
                    preorder.add(current.val);
                    current = current.left;
                }else{
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return preorder;
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
