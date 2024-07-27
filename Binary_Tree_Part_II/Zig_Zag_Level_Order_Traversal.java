/*
    Problem Name: Zig Zag Level Order Traversal
    Problem Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
*/

import java.util.*;

public class Zig_Zag_Level_Order_Traversal {
    /*
        TC -> O(N)
        SC -> O(2^height)
    */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)    return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean flag = true;
        while(!que.isEmpty()){
            int n = que.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = que.remove();
                if(flag){
                    list.add(node.val);
                }else{
                    list.add(0, node.val);
                }

                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }
            result.add(list);
            flag = !flag;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1, 2, 3, 4, 5, 6, 7, null, 8};
        Integer[] nums2 = {1, 3, 2};
        Integer[] nums3 = {10, 20, 30, 40, 60};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(zigzagLevelOrder(root1));
        System.out.println(zigzagLevelOrder(root2));
        System.out.println(zigzagLevelOrder(root3));
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