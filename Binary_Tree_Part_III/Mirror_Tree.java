/*
    Problem Name: Generate Mirror of Given Binary Tree
    Problem Link: https://www.geeksforgeeks.org/problems/mirror-tree/1
*/

import java.util.*;

public class Mirror_Tree {
    /*
        Resursive Approach
        TC -> O(N)
        SC -> O(Height)
    */
    public static void mirror(TreeNode node) {
        if(node == null){
            return;
        }
        // Swapping
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        // Preorder Traversal
        mirror(node.left);
        mirror(node.right);
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1, 2, 3};
        Integer[] nums2 = {10, 20, 30, 40, 60};
        Integer[] nums3 = {-10,9,20,null,null,15,7};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println("Before Mirror -> " + levelOrderTraversal(root1));
        mirror(root1);
        System.out.println("After Mirror -> " + levelOrderTraversal(root1)+"\n");
        System.out.println("Before Mirror -> " + levelOrderTraversal(root2));
        mirror(root2);
        System.out.println("After Mirror -> " + levelOrderTraversal(root2)+"\n");
        System.out.println("Before Mirror -> " + levelOrderTraversal(root3));
        mirror(root3);
        System.out.println("After Mirror -> " + levelOrderTraversal(root3)+"\n");
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
