/*
    Problem Name: Construct Binary Tree from Preorder and Inorder Traversal
    Problem Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
*/

import java.util.*;

public class Construct_Binary_Tree_From_Inorder_And_Preorder {
    /*
        TC -> O(N)
        SC -> O(N){Hashing} + O(N){Recursion Stack Space}
    */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numLeft = inRoot - inStart;
        
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + numLeft, inorder, inStart, inRoot - 1, map);
        root.right = buildTreeHelper(preorder, preStart + numLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);

        return root;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] preorder1 = {3,9,20,15,7}, preorder2 = {-1};
        int[] inorder1 = {9,3,15,20,7}, inorder2 = {-1};

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