/*
    Problem Name: Rotate a Linked List
    Problem Link: https://leetcode.com/problems/rotate-list/
*/

public class Rotate_Linked_List_By_K_Places {
    /*
        Optimal Solution
        TC -> O(N) + O(N) -> O(2N)
        SC -> O(1)
    */
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int length = getLength(head);
        k = k % length;

        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<k;i++){
            fast = fast.next;
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public static int getLength(ListNode head){
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            length += 1;
        }
        return length;
    }

    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {0, 1, 2};
        int k1 = 2, k2 = 4;
        ListNode head1 = generateLinkedList(nums1);
        ListNode head2 = generateLinkedList(nums2);

        System.out.print("Before Rotating: ");
        display(head1);
        ListNode newHead1 = rotateRight(head1, k1);
        System.out.print("After Rotating: ");
        display(newHead1);

        System.out.print("Before Rotating: ");
        display(head2);
        ListNode newHead2 = rotateRight(head2, k2);
        System.out.print("After Rotating: ");
        display(newHead2);   
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
