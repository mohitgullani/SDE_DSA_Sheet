/*
    Problem Name: Reverse Linked List
    Problem Link: https://leetcode.com/problems/reverse-linked-list/description/
*/

public class Reverse_A_Linked_List {
    /*
        Iterative Approach
        TC -> O(N)
        SC -> O(1)
        public static ListNode reverseList(ListNode head){
            ListNode newHead = null;
            while(head != null){
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
        }
    */

    /*
        Recursion Approah
        TC -> O(N)
        SC -> Auxillary space of N
    */
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2};

        ListNode head1 = generateLinkedList(nums1);
        ListNode head2 = generateLinkedList(nums2);

        System.out.print("Before Reversing: ");
        display(head1);
        ListNode reverseHead1 = reverseList(head1);
        System.out.print("After Reversing: ");
        display(reverseHead1);

        System.out.print("Before Reversing: ");
        display(head2);
        ListNode reverseHead2 = reverseList(head2);
        System.out.print("After Reversing: ");
        display(reverseHead2);

        
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
