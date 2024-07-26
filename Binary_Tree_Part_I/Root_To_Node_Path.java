/*
    Similar Problem Name: Print all the Root to Leaf Paths
    Similar Problem Link: https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
*/

import java.util.*;

public class Root_To_Node_Path {
    /*
        TC -> O(N)
        SC -> O(Height)
    */
    public static boolean getPathsHelper(TreeNode root, int node, List<Integer> list){
        if(root == null){
            return false;
        }
        
        list.add(root.val);
        
        if(root.val == node){
            return true;
        }

        if(getPathsHelper(root.left, node, list) || getPathsHelper(root.right, node, list)){
            return true;
        }

        list.remove(list.size() - 1);
        return false;
    }

    public static List<Integer> getPaths(TreeNode root, int node){
        List<Integer> list = new ArrayList<>();
        if(root == null)    return list;
        getPathsHelper(root, node, list);
        return list;
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Integer[] nums3 = {10, 20, 30, 40, 60, 90, 100};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(getPaths(root1, 6));
        System.out.println(getPaths(root2, 10));
        System.out.println(getPaths(root3, 90));
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
