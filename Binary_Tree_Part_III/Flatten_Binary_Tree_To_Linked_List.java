/*
    Problem Name: Flatten Binary Tree to Linked List
    Problem Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
*/

import java.util.*;

public class Flatten_Binary_Tree_To_Linked_List {
    /*
        Brute Forch Approach
        TC -> O(N * Height)
        SC -> (1)
        public static void flatten(TreeNode root) {
            TreeNode current = root;
            while(current != null){
                TreeNode rightMostNode = current.left;
                while(rightMostNode != null && rightMostNode.right != null){
                    rightMostNode = rightMostNode.right;
                }
                if(rightMostNode != null){
                    rightMostNode.right = current.right;
                    current.right = current.left;
                    current.left = null;
                }
                current = current.right;
            }
        }
    */

    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(Height)
    */
    public static TreeNode prev = null;
    public static void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1, 2, 3, 4, 5, 6, 7, null, 8};
        Integer[] nums2 = {1, 3, 2};
        Integer[] nums3 = {-10,9,20,null,null,15,7};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        flatten(root1);
        prev = null;
        flatten(root2);
        prev = null;
        flatten(root3);

        System.out.println(levelOrderTraversal(root1));
        System.out.println(levelOrderTraversal(root2));
        System.out.println(levelOrderTraversal(root3));
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
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
}
