/*
    Problem Name: Linked List Cycle II
    Problem Link: https://leetcode.com/problems/linked-list-cycle-ii/
*/

import java.util.HashSet;
import java.util.Set;

public class Linked_List_Cycle_II {
    /*
        Brute Force Approach
        TC -> O(N)
        SC -> O(N)
        public static ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while(head != null){
                if(!set.add(head)){
                    return head;
                }
                head = head.next;
            }
            return null;
        }
    */

    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(1)
    */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;    
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

        ListNode firstNode1 = detectCycle(head1);
        if(firstNode1 != null){
            System.out.println(firstNode1.val);
        }else{
            System.out.println("No Cycle Detected!");
        }
        
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
        ListNode firstNode2 = detectCycle(head2);
        if(firstNode2 != null){
            System.out.println(firstNode2.val);
        }else{
            System.out.println("No Cycle Detected!");
        }
        
        // Test Case 3
        //  1 -> null
        int[] nums3 = {1};
        temp1 = null;
        temp2 = null;
        ListNode head3 = generateLinkedList(nums3);
        ListNode firstNode3 = detectCycle(head3);
        if(firstNode3 != null){
            System.out.println(firstNode3.val);
        }else{
            System.out.println("No Cycle Detected!");
        }
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
