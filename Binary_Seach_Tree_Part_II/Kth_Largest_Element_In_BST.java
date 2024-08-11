/*
    Problem Name: Kth Largest Element in BST
    Problem Link: https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
*/

import java.util.*;

public class Kth_Largest_Element_In_BST {
    /*
        Brute Force Approach
        TC -> O(N){Traversal} + O(NlogN){Sorting}
        SC -> O(Height){Recursion Stack Space} + O(N){For Storing Elements in the List}
        public static int kthLargest(TreeNode root,int K)
        {
            List<Integer> list = new ArrayList<>();
            preorderTraversal(root, list);
            Collections.sort(list);
            return list.get(list.size() - K);
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
        public static int kthLargest(TreeNode root,int K)
        {
            List<Integer> list = new ArrayList<>();
            inorderTraversal(root, list);
            return list.get(list.size() - K);
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
        TC -> O(N){Traversal}
        SC -> O(Height){Recursion Stack Space}
    */
    public static int kthLargest(TreeNode root,int K)
    {   
        int[] index = new int[1];
        int[] result = new int[]{-1};
        kthLargestHelper(root, K, index, result);
        return result[0];
    }
    
    public static void kthLargestHelper(TreeNode root, int K, int[] index, int[] result){
        if(root == null){
            return;
        }
        
        kthLargestHelper(root.right, K, index, result);
        if(result[0] != -1) return;
        index[0]++;
        if(index[0] == K){
            result[0] = root.val;
            return;
        }
        kthLargestHelper(root.left, K, index, result);
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {3, 1, 4, null, 2};
        Integer[] nums2 = {5, 3, 6, 2, 4, null, null, 1};
        int k1 = 1, k2 = 3;

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);

        System.out.println(kthLargest(root1, k1));
        System.out.println(kthLargest(root2, k2));
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
