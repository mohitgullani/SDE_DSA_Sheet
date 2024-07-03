/*
    Problem Name: Middle of the Linked List
    Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/description/
*/

public class Middle_Of_The_Linked_List {
    /*
        Brute Force Approach
        TC -> O(N) + O(N/2) -> O(N)
        TC -> O(1)
        public static ListNode middleNode(ListNode head) {
            int length = 0;
            ListNode current = head;
            while(current != null){
                current = current.next;
                length += 1;
            }
            current = head;
            for(int i=0;i<length/2;i++){
                current = current.next;
            }
            return current;
        }
    */

    /*
        Optimal Solution
        TC -> O(N/2) -> O(N)
        SC -> O(1)
    */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 4, 5, 6};

        ListNode head1 = generateLinkedList(nums1);
        ListNode head2 = generateLinkedList(nums2);

        System.out.print("Before Reversing: ");
        display(head1);
        ListNode middleNode1 = middleNode(head1);
        System.out.print("After Reversing: ");
        display(middleNode1);

        System.out.print("Before Reversing: ");
        display(head2);
        ListNode middleNode2 = middleNode(head2);
        System.out.print("After Reversing: ");
        display(middleNode2);

        
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
