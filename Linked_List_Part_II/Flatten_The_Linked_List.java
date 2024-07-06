/*
    Problem Name: Flattening of a LinkedList
    Problem Link: https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
*/

public class Flatten_The_Linked_List {
    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(1)
    */

    public static Node flatten(Node root) {
        if(root == null || root.next == null){
            return root;
        }
        
        root.next = flatten(root.next);
        mergeTwoList(root, root.next);
        return root;
    }

    public static Node mergeTwoList(Node l1, Node l2){
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                current.bottom = l1;
                current = current.bottom;
                l1 = l1.bottom;
            }else{
                current.bottom = l2;
                current = current.bottom;
                l2 = l2.bottom;
            }
            current.next = null;
        }
        
        if(l1 == null)  current.bottom = l2;
        else    current.bottom = l1;
        return dummyNode.bottom;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 8, 30};
        int[] nums2 = {10, 20};
        int[] nums3 = {19, 22, 50};
        int[] nums4 = {28, 35, 40, 45};

        Node head1 = generateLinkedList(nums1);
        Node head2 = generateLinkedList(nums2);
        Node head3 = generateLinkedList(nums3);
        Node head4 = generateLinkedList(nums4);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        /*
            5 -> 10 -> 19 -> 28
            |     |     |     | 
            7     20    22   35
            |           |     | 
            8          50    40
            |                 | 
            30               45
        */
        flatten(head1);
        display(head1);
    }

    public static Node generateLinkedList(int[] nums){
        Node head = new Node(-1);
        Node current = head;
        for(int i=0;i<nums.length;i++){
            Node temp = new Node(nums[i]);
            current.bottom = temp;
            current = temp;
        }
        return head.bottom;
    }

    public static void display(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.bottom;
        }
        System.out.println();
    }

    public static class Node{
        int data;
        Node next;
        Node bottom;
        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }
}
