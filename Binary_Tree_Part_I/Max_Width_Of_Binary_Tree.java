/*
    Problem Name: Maximum Width of a Binary Tree
    Problem Link: https://leetcode.com/problems/maximum-width-of-binary-tree/
*/

import java.util.*;

public class Max_Width_Of_Binary_Tree {
    /*
        TC -> O(N)
        SC -> O(2^height)
    */
    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null)    return 0;
        Queue<Pair> que = new LinkedList<>();
        int maxWidth = 1;
        que.add(new Pair(root, 0));
        while(!que.isEmpty()){
            int n = que.size();
            int min = que.peek().index;
            int first = 0, last = 0;
            for(int i=0;i<n;i++){
                int currentId = que.peek().index - min;
                TreeNode node = que.remove().node;
                if(i == 0){
                    first = currentId;
                }
                if(i == n - 1){
                    last = currentId;
                }
                if(node.left != null){
                    que.add(new Pair(node.left, 2*currentId + 1));
                }
                if(node.right != null){
                    que.add(new Pair(node.right, 2*currentId + 2));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }

    public static class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1, 3, 2, 5, 3, null, 9};
        Integer[] nums2 = {1, 3, 2, 5, null, null, 9, 6, null, 7};
        Integer[] nums3 = {1, 3, 2, 5};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(widthOfBinaryTree(root1));
        System.out.println(widthOfBinaryTree(root2));
        System.out.println(widthOfBinaryTree(root3));
    }
    
    public static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
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
