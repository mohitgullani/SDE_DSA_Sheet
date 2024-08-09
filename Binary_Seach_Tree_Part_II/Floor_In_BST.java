/*
    Problem Name: Floor in a BST
    Problem Link: https://www.naukri.com/code360/problems/floor-from-bst_920457
*/

import java.util.*;

public class Floor_In_BST {
    /*
        Optimal Approach
        TC -> O(Height)
        SC -> O(Height){Recursion Stack Space}
    */
    
    public static int floorInBST(TreeNode root, int X) {
        int floor = -1;
        while(root != null){
            if(root.val <= X){
                floor = root.val;
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return floor;

    }
    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {10, 5, 15, 2, 6, null, null, null, null, null, null};
        Integer[] nums2 = {2, 1, 3, null, null, null, null};
        int X1 = 7, X2 = 2;

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);

        System.out.println(floorInBST(root1, X1));
        System.out.println(floorInBST(root2, X2));
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
