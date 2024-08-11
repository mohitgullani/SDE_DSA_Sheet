/*
    Problem Name: Kth Smallest Element in a BST
    Problem Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
*/

import java.util.*;

public class Kth_Smallest_Element_In_BST {
    /*
        Brute Force Approach
        TC -> O(N){Traversal} + O(NlogN){Sorting}
        SC -> O(Height){Recursion Stack Space} + O(N){For Storing Elements in the List}
        public static int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            preorderTraversal(root, list);
            Collections.sort(list);
            return list.get(k-1);
        } 
        
        public static void preorderTraversal(TreeNode root, List<Integer> list){
            if(root == null){
                return;
            }
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    */ 

    /*
        Better Approach
        TC -> O(N){Traversal}
        SC -> O(Height){Recursion Stack Space} + O(N){For Storing Elements in the List}
        public static int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            inorderTraversal(root, list);
            return list.get(k-1);
        }

        public static void inorderTraversal(TreeNode root, List<Integer> list){
            if(root == null){
                return;
            }
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }
    */

    /*
        Optimal Solution
        TC -> O(N){For Traversal}
        SC -> O(Height){Recursion Stack Space}
    */
    public static int kthSmallest(TreeNode root, int k) {
        int[] result = new int[]{-1};
        int[] index = new int[1];
        kthSmallestHelper(root, k, result, index);
        return result[0];
    }

    public static void kthSmallestHelper(TreeNode root, int k, int[] result, int[] index){
        if(root == null){
            return;
        }
        kthSmallestHelper(root.left, k, result, index);
        if(result[0] != -1) return;
        index[0]++;
        if(index[0] == k){
            result[0] = root.val;
            return;
        }
        kthSmallestHelper(root.right, k, result, index);
    }
    
    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {3, 1, 4, null, 2};
        Integer[] nums2 = {5, 3, 6, 2, 4, null, null, 1};
        int k1 = 1, k2 = 3;

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);

        System.out.println(kthSmallest(root1, k1));
        System.out.println(kthSmallest(root2, k2));
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
