/*
    Problem Name: Delete Node in a Linked List
    Problem Link: https://leetcode.com/problems/delete-node-in-a-linked-list/description/ 
*/

public class Delete_Node_In_A_Linked_List {
    /*
        Optimal Solution
        TC -> O(1)
        SC -> O(1)
    */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args){
        // Test Cases
        int[] nums1 = {4, 5, 1, 9};
        int[] nums2 = {4, 5, 1, 9};
        
        ListNode head1 = generateLinkedList(nums1);
        ListNode head2 = generateLinkedList(nums2);

        ListNode node1 = head1, node2 = head2;
        for(int i=0;i<1;i++)    node1 = node1.next;
        for(int i=0;i<2;i++)    node2 = node2.next;

        System.out.print("Before Deleting: ");
        display(head1);
        deleteNode(node1);
        System.out.print("After Deleting: ");
        display(head1);

        System.out.print("Before Deleting: ");
        display(head2);
        deleteNode(node2);
        System.out.print("After Deleting: ");
        display(head2);

        
    }

    public static ListNode generateLinkedList(int[] nums){
        ListNode head = new ListNode(-1);
        ListNode current = head;
        for(int i=0;i<nums.length;i++){
            ListNode temp = new ListNode(nums[i]);
            current.next = temp;
            current = temp;
        }
        return head.next;
    }

    public static void display(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}