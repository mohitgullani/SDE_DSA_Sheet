/*
    Problem Name: Convert Sorted Array to Binary Search Tree
    Problem Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
*/

import java.util.*;

public class Converted_Sorted_Array_To_BST {
    /*
        TC -> O(N)
        SC -> O(N){For Creating new node for each element} + O(Height){Recursion Stack Space}
    */
    public static TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode root = generateBST(nums, 0, n - 1);
        return root;
    }

    public static TreeNode generateBST(int[] nums, int low, int high){
        if(low > high){
            return null;
        }

        int mid = (low + high) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = generateBST(nums, low, mid - 1);
        root.right = generateBST(nums, mid + 1, high);
        return root;
    }
    
    public static void main(String[] args) {
        // Test Cases
        int[] nums1 = {-10, -3, 0, 5, 9};
        int[] nums2 = {1, 3};

        TreeNode root1 = sortedArrayToBST(nums1);
        TreeNode root2 = sortedArrayToBST(nums2);

        System.out.println(levelOrderTraversal(root1));
        System.out.println(levelOrderTraversal(root2));
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)    return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int n = que.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = que.remove();
                list.add(node.val);
                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
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