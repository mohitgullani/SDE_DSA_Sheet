/*
    Problem Name: Children Sum in a Binary Tree
    Problem Link: https://www.geeksforgeeks.org/problems/children-sum-parent/1
*/

import java.util.*;

public class Child_Sum_Property {
    /*
        TC -> O(N)
        SC -> O(Height){Recursion Stack Space}
    */
    public static int isSumProperty(TreeNode root){
        if(root == null){
            return 1;
        }
        
        if(root.left == null && root.right == null){
            return 1;
        }
        
        int leftChild = (root.left != null) ? root.left.val : 0;
        int rightChild = (root.right != null) ? root.right.val : 0;
        if(leftChild + rightChild != root.val){
            return 0;
        }
        
        if(isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1){
            return 1;
        }else{
            return 0;
        }
    }  

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {35, 20, 15, 15, 5, 10, 5};
        Integer[] nums2 = {1, 4, 3, 5, null};
        Integer[] nums3 = {-10,9,20,null,null,15,7};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(isSumProperty(root1));
        System.out.println(isSumProperty(root2));
        System.out.println(isSumProperty(root3));
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