/*
    Problem Name: Palindrome Linked List
    Problem Link: https://leetcode.com/problems/palindrome-linked-list/
*/

import java.util.*;

public class Palindrome_Linked_List {
    /*
        Brute Force Approach
        TC -> O(N) + O(N) -> O(2N)
        SC -> O(N)
        public static boolean isPalindrome(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while(head != null){
                list.add(head.val);
                head = head.next;
            }
            int left = 0;
            int right = list.size() - 1;
            while(left < right){
                if(list.get(left) != list.get(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    */

    /*
        Optimal Solution
        TC -> O(N/2) + O(N/2) + O(N/2) + O(N/2) -> O(2N)
        SC -> O(1)
    */
    public static boolean isPalindrome(ListNode head) {
        if(head == null)    return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        ListNode list1 = head;
        ListNode list2 = slow.next;
        while(list2 != null){
            if(list1.val != list2.val){
                slow.next = reverse(slow.next);
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        slow.next = reverse(slow.next);
        return true;
    }
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args){
        // Test Cases
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {1, 2, 3, 2, 1};
        int[] nums3 = {1, 2};
        int[] nums4 = {1, 2, 3, 4, 5};

        ListNode head1 = generateLinkedList(nums1);
        ListNode head2 = generateLinkedList(nums2);
        ListNode head3 = generateLinkedList(nums3);
        ListNode head4 = generateLinkedList(nums4);

        System.out.println(isPalindrome(head1));
        System.out.println(isPalindrome(head2));
        System.out.println(isPalindrome(head3));
        System.out.println(isPalindrome(head4));
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
