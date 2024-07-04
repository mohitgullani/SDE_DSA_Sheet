/*
    Problem Name: Intersection of Two Linked Lists
    Problem Link: https://leetcode.com/problems/intersection-of-two-linked-lists/description/
*/

import java.util.HashSet;

public class Intersection_Of_Two_Linked_Lists {
    /*
        Brute Force Approach
        TC -> O(N1 + N2)
        SC -> O(N1)
        Where N1 & N2 are the no. of nodes in headA & headB list
        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<>();
            while(headA != null){
                set.add(headA);
                headA = headA.next;
            }
            while(headB != null){
                if(set.contains(headB)){
                    break;
                }
                headB = headB.next;
            }
            return headB;
        }
    */

    /*
        Optimal Solution
        TC -> O(max(N1, N2))
        SC -> O(1)
        Where N1 & N2 are the no. of nodes in headA & headB list
    */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while(l1 != l2){
            l1 = l1.next;
            l2 = l2.next;
            if(l1 == l2){
                return l1;
            }
            if(l1 == null)  l1 = headB;
            if(l2 == null)  l2 = headA;
        }
        return l1;
    }

    public static void main(String[] args){
        // Test Cases
        int[] nums1 = {4, 1, 8, 4, 5};
        int[] nums2 = {5, 6, 1};

        int[] nums3 = {1, 9, 1, 2, 4};
        int[] nums4 = {3};

        int[] nums5 = {2, 6, 4};
        int[] nums6 = {1, 5};

        /*
                 4 -> 1 -> 8 -> 4 -> 5
                           ^                
            5 -> 6 -> 1 -> |
        */
        ListNode head1 = generateLinkedList(nums1);
        ListNode head2 = generateLinkedList(nums2);
        ListNode temp1 = head1;
        for(int i=0;i<2;i++)    temp1 = temp1.next;
        ListNode temp2 = head2;
        while(temp2.next != null)   temp2 = temp2.next;
        temp2.next = temp1;
        
        /*
            1 -> 9 -> 1 -> 2 -> 4
                           ^
                      3 -> | 
        */
        ListNode head3 = generateLinkedList(nums3);
        ListNode head4 = generateLinkedList(nums4);
        temp1 = head3;
        for(int i=0;i<3;i++)    temp1 = temp1.next;
        head4.next = temp1;

        /*
            2 -> 6 -> 4
            1 -> 5
        */
        ListNode head5 = generateLinkedList(nums5);
        ListNode head6 = generateLinkedList(nums6);
        ListNode intersectedNode1 = getIntersectionNode(head1, head2);

        if(intersectedNode1 != null)    System.out.println(intersectedNode1.val);
        else    System.out.println("No Intersection");

        ListNode intersectedNode2 = getIntersectionNode(head3, head4);
        if(intersectedNode2 != null)    System.out.println(intersectedNode2.val);
        else    System.out.println("No Intersection");

        ListNode intersectedNode3 = getIntersectionNode(head5, head6);
        if(intersectedNode3 != null)    System.out.println(intersectedNode3.val);
        else    System.out.println("No Intersection");
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
