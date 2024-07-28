/*
    Problem Name: Boundary Traversal of Binary Tree
    Problem Link: https://www.naukri.com/code360/problems/boundary-traversal_790725
*/

import java.util.*;

public class Boundary_Traversal_Of_Binary_Tree {
    /*
        TC -> O(H){Left Boundary} + O(H){Right Boundary} + O(N){For Leafs} -> O(N) Approximately
        SC -> O(H){Auxilliary Space}
    */
    public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(!isLeaf(root))   list.add(root.val);
        getLeftBoundary(root, list);
        addLeafNodes(root, list);
        getRightBoundary(root, list);
        return list;
    }

    public static boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null){
            return true;
        }
        return false;
    }
    public static void getLeftBoundary(TreeNode root, List<Integer> list){
        TreeNode current = root.left;
        while(current != null){
            if(!isLeaf(current)){
                list.add(current.val);
            }
            
            if(current.left != null)    current = current.left;
            else    current = current.right;
        }
    }

    public static void addLeafNodes(TreeNode root, List<Integer> list){
        if(root == null)    return;
        if(isLeaf(root)){
            list.add(root.val);
            return;
        }
        addLeafNodes(root.left, list);
        addLeafNodes(root.right, list);
    }

    public static void getRightBoundary(TreeNode root, List<Integer> list){
        Stack<Integer> st = new Stack<>();
        TreeNode current = root.right;
        while(current != null){
            if(!isLeaf(current)){
                st.push(current.val);
            }
            if(current.right != null)   current = current.right;
            else    current = current.left;
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }
    }
      public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {10, 5, 20, 3, 8, 18, 25, null, null, 7, null};
        Integer[] nums2 = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Integer[] nums3 = {1, 2};
        
        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(traverseBoundary(root1));
        System.out.println(traverseBoundary(root2));
        System.out.println(traverseBoundary(root3));
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
