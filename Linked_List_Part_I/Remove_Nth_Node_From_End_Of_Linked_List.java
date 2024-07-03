/*
    Problem Name: Remove Nth Node From End of List
    Problem Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/

public class Remove_Nth_Node_From_End_Of_Linked_List {
    /*
        Optimal Solution
        TC -> O(N)
        SC -> O(1)
    */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        if(fast == null){
            return slow.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args){
        // Test Cases
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1};
        int[] nums3 = {1, 2};

        int n1 = 2, n2 = 1, n3 = 1;

        ListNode head1 = generateLinkedList(nums1);
        ListNode head2 = generateLinkedList(nums2);
        ListNode head3 = generateLinkedList(nums3);

        System.out.print("Before Deleting: ");
        display(head1);
        ListNode newHead1 = removeNthFromEnd(head1, n1);
        System.out.print("After Reversing: ");
        display(newHead1);        
        System.out.println("---------------------------------------");
        System.out.print("Before Deleting: ");
        display(head2);
        ListNode newHead2 = removeNthFromEnd(head2, n2);
        System.out.print("After Reversing: ");
        display(newHead2);
        System.out.println("---------------------------------------");
        System.out.print("Before Deleting: ");
        display(head3);
        ListNode newHead3 = removeNthFromEnd(head3, n3);
        System.out.print("After Reversing: ");
        display(newHead3);     
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
