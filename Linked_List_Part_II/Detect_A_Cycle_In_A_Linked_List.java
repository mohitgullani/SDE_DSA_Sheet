/*
    Problem Name: Detect a cycle in Linked List
    Problem Link: https://leetcode.com/problems/linked-list-cycle/description/
*/

import java.util.HashSet;

public class Detect_A_Cycle_In_A_Linked_List {
    /*
        Brute Force Approach
        TC -> O(N)
        SC -> O(N)
        public static boolean hasCycle(ListNode head) {
            HashSet<ListNode> set = new HashSet<>();
            ListNode current = head;
            while(current != null){
                if(set.contains(current)){
                    return true;
                }
                set.add(current);
                current = current.next;
            }
            return false;
        }
    */

    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(1)
    */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        /*
            Test Case 1
            3 -> 2 -> 0 -> -4
                 ^          |
                 | <-  <-  <-     
        */
        int[] nums1 = {3, 2, 0, -4};
        int pos1 = 1;
        ListNode head1 = generateLinkedList(nums1);        
        ListNode temp1 = null, temp2 = null;
        temp1 = head1;
        while(temp1 != null && temp1.next != null){
            temp1 = temp1.next;
        }
        temp2 = head1;
        for(int i=0;i<pos1;i++) temp2 = temp2.next;
        temp1.next = temp2; 

        System.out.println(hasCycle(head1));
        
        /*
            Test Case 2
            1 -> 2
            ^    |
            |  <- 
        */
        int[] nums2 = {1, 2};
        int pos2 = 0;
        temp1 = null;
        temp2 = null;
        ListNode head2 = generateLinkedList(nums2);
        temp1 = head2;
        while(temp1 != null && temp1.next != null){
            temp1 = temp1.next;
        }
        temp2 = head2;
        for(int i=0;i<pos1;i++) temp2 = temp2.next;
        temp1.next = temp2; 
        System.out.println(hasCycle(head2));
        
        // Test Case 3
        //  1 -> null
        int[] nums3 = {1};
        temp1 = null;
        temp2 = null;
        ListNode head3 = generateLinkedList(nums3);
        System.out.println(hasCycle(head3));
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

    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}