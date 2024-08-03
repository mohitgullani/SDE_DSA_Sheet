/*
    Problem Name: Construct Binary Search Tree from Preorder Traversal
    Problem Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
*/

import java.util.*;

public class Construct_BST_From_Preorder {
    /*
        Brute Force Approach
        TC -> O(N^Height)
        SC -> O(1)
        public static TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root = new TreeNode(preorder[0]);
            for(int i=1;i<preorder.length;i++){
                TreeNode current = root;
                int val = preorder[i];
                while(current != null){
                    if(val < current.val){
                        if(current.left != null){
                            current = current.left;
                        }else{
                            current.left = new TreeNode(val);
                            break;
                        }
                    }else{
                        if(current.right != null){
                            current = current.right;
                        }else{
                            current.right = new TreeNode(val);
                            break;
                        }
                    }
                }
            }
            return root;
        }
    */

    /*
        Better Approach
        TC -> O(2N) + O(NlogN) + (N) -> O(N) + O(NlogN)
        SC -> O(N){Inorder Array} + O(N){HashMap} + O(Height){Recursion Stack Space} -> O(N) Overall Space Complexity
        public static TreeNode bstFromPreorder(int[] preorder) {
            int n = preorder.length;
            int[] inorder = new int[n];
            for(int i=0;i<n;i++){
                inorder[i] = preorder[i];
            }
            Arrays.sort(inorder);
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<n;i++)    map.put(inorder[i], i);
            return generateBST(preorder, 0, n - 1, inorder, 0, n - 1, map);
        }

        public static TreeNode generateBST(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
            if(preStart > preEnd || inStart > inEnd)    return null;
            
            TreeNode root = new TreeNode(preorder[preStart]);
            
            int inRoot = map.get(root.val);
            int numLeft = inRoot - inStart;

            root.left = generateBST(preorder, preStart + 1, preStart + numLeft, inorder, inStart, inRoot - 1, map);
            root.right = generateBST(preorder, preStart + numLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);

            return root;
        }
    */

    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(Height){Recursion Stack Space}
    */
    public static TreeNode bstFromPreorder(int[] preorder) {
        return generateBST(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public static TreeNode generateBST(int[] preorder, int ub, int[] index){
        if(index[0] == preorder.length || preorder[index[0]] > ub){
            return null;
        }

        TreeNode root = new TreeNode(preorder[index[0]++]);

        root.left = generateBST(preorder, root.val, index);
        root.right = generateBST(preorder, ub, index);

        return root;
    }

    public static void main(String[] args) {
        // Test Cases
        int[] preorder1 = {8, 5, 1, 7, 10, 12};
        int[] preorder2 = {1, 3};

        TreeNode root1 = bstFromPreorder(preorder1);
        TreeNode root2 = bstFromPreorder(preorder2);

        List<Integer> inorder1 = new ArrayList<>();
        List<Integer> inorder2 = new ArrayList<>();
        inOrderTraversal(root1, inorder1);
        inOrderTraversal(root2, inorder2);
        System.out.println(inorder1);
        System.out.println(inorder2);
    }

    public static void inOrderTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
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