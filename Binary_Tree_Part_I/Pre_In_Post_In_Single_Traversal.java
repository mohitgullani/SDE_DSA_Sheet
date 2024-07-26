/*
    Problem Name: Preorder, Inorder & Postorder in a Single Traversal
    Problem Link: https://www.naukri.com/code360/problems/981269
*/

import java.util.*;

public class Pre_In_Post_In_Single_Traversal {
    /*
        TC -> O(3N)
        SC -> O(3N){For 3 list} + O(N){For Stack} -> O(4N)
    */
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while(!st.isEmpty()){
            Pair p = st.peek();
            if(p.num == 1){
                preOrder.add(p.node.val);
                p.num++;
                if(p.node.left != null){
                    st.push(new Pair(p.node.left, 1));
                }
            }else if(st.peek().num == 2){
                inOrder.add(p.node.val);
                p.num++;
                if(p.node.right != null){
                    st.push(new Pair(p.node.right, 1));
                }
            }else{
                postOrder.add(p.node.val);
                st.pop();
            }
        }
        
        result.add(inOrder);
        result.add(preOrder);
        result.add(postOrder);

        return result;
    }

    public static class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {1, 3, 4, 5, 2, 7, 6};
        Integer[] nums2 = {1, 2, 3, null, null, null, 6};
        Integer[] nums3 = {1, 2, 4, 5, 3, null, null};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(getTreeTraversal(root1));
        System.out.println(getTreeTraversal(root2));
        System.out.println(getTreeTraversal(root3));
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
