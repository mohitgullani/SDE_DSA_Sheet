/*
    Problem Name: Left View of Binary Tree
    Problem Link: https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
*/

import java.util.*;

public class Left_View_Of_Binary_Tree {
    /*
        TC -> O(N)
        SC -> O(Height){Recursion Stack Space}
    */
    public static ArrayList<Integer> leftView(TreeNode root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        leftViewHelper(root, list, 0);
        return list;
    }
    
    public static void leftViewHelper(TreeNode root, ArrayList<Integer> list, int level){
        if(root == null){
            return;
        }
        if(level == list.size()){
            list.add(root.val);
        }
        leftViewHelper(root.left, list, level + 1);
        leftViewHelper(root.right, list, level + 1);
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
        Integer[] nums1 = {1, 2, 3, 4, 5, 6, 7, null, 8};
        Integer[] nums2 = {1, 3, 2};
        Integer[] nums3 = {10, 20, 30, 40, 60};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(leftView(root1));
        System.out.println(leftView(root2));
        System.out.println(leftView(root3));
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
