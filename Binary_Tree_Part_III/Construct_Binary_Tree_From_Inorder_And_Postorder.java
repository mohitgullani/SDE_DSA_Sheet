/*
    Problem Name: Construct Binary Tree from Inorder and Postorder Traversal
    Problem Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
*/

import java.util.*;

public class Construct_Binary_Tree_From_Inorder_And_Postorder {
    /*
        TC -> O(N)
        SC -> O(N){Hashing} + O(N){Recursion Stack Space}
    */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTreeHelper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public static TreeNode buildTreeHelper(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int inRoot = map.get(postorder[postEnd]);
        int numLeft = inRoot - inStart;

        root.left = buildTreeHelper(postorder, postStart, postStart + numLeft - 1, inorder, inStart, inRoot - 1, map);
        root.right = buildTreeHelper(postorder, postStart + numLeft, postEnd - 1, inorder, inRoot + 1, inEnd, map);

        return root;
    }
    public static void main(String[] args) {
        // Test Cases
        int[] preorder1 = {9,3,15,20,7}, preorder2 = {-1};
        int[] inorder1 = {9,15,7,20,3}, inorder2 = {-1};

        TreeNode root1 = buildTree(preorder1, inorder1);
        TreeNode root2 = buildTree(preorder2, inorder2);

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

    public static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
}
