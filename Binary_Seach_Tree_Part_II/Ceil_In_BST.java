/*
    Problem Name: Ceil in a BST
    Problem Link: https://www.naukri.com/code360/problems/ceil-from-bst_920464
*/

import java.util.LinkedList;
import java.util.Queue;

class Ceil_In_BST{
    /*
        Optimal Approach
        TC -> O(Height)
        SC -> O(Height){Recursion Stack Space}
    */
    public static int ceilInBST(TreeNode root, int X) {
        int ceil = -1;
        while(root != null){
            if(X <= root.val){
                ceil = root.val;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return ceil;
    }
    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {8, 5, 10, 2, 6, null, null, null, null, null, 7, null, null};
        Integer[] nums2 = {8, 5, 10, 2, 6, null, null, null, null, null, 7, null, null};
        int X1 = 4, X2 = 7;

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);

        System.out.println(ceilInBST(root1, X1));
        System.out.println(ceilInBST(root2, X2));
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