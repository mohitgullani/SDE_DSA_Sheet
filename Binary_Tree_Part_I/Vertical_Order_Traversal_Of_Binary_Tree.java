
/*
    Problem Name: Vertical Order Traversal of Binary Tree
    Problem Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
*/
import java.util.*;

public class Vertical_Order_Traversal_Of_Binary_Tree {
    /*
        BFS Approach or Level Order Traversal
        TC -> O(NlogN) As we are using TreeMap which takes O(logN) for each insertion and retrieval
        SC -> O(N)
    */
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, 0, 0));
        while(!que.isEmpty()){
            TreeNode node = que.peek().node;
            int vertical = que.peek().vertical;
            int level = que.peek().level;
            que.remove();
            
            if(!map.containsKey(vertical)){
                map.put(vertical, new TreeMap<>());
            }

            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level, new PriorityQueue<>());
            }

            map.get(vertical).get(level).add(node.val);

            if(node.left != null){
                que.add(new Pair(node.left, vertical - 1, level + 1));
            }

            if(node.right != null){
                que.add(new Pair(node.right, vertical + 1, level + 1));
            }
        }
        for(int vertical: map.keySet()){
            List<Integer> list = new ArrayList<>();
            for(int level: map.get(vertical).keySet()){
                PriorityQueue<Integer> pq = map.get(vertical).get(level);
                while(!pq.isEmpty()){
                    list.add(pq.remove());
                }
            }
            result.add(list);
        }
        
        return result;
    }

    public static class Pair{
        TreeNode node;
        int vertical;
        int level;
        Pair(TreeNode node, int vertical, int level){
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    public static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Test Cases
        Integer[] nums1 = {3, 9, 20, null, null, 15, 7};
        Integer[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] nums3 = {1, 2, 3, 4, 6, 5, 7};

        TreeNode root1 = insertLevelOrder(nums1);
        TreeNode root2 = insertLevelOrder(nums2);
        TreeNode root3 = insertLevelOrder(nums3);

        System.out.println(verticalTraversal(root1));
        System.out.println(verticalTraversal(root2));
        System.out.println(verticalTraversal(root3));
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
