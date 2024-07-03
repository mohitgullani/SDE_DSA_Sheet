/*
    Problem Name: Add Two Numbers
    Problem Link: https://leetcode.com/problems/add-two-numbers/
*/

public class Add_Two_Numbers {
    /*
        Optimal Solution
        TC -> O(max(l1, l2))
        SC -> O(max(l1, l2))
    */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int sum = 0, carry = 0;
        while(l1 != null || l2 != null){
            sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode temp = new ListNode(sum % 10);
            current.next = temp;
            current = temp;
            carry = sum / 10;
        }
        if(carry > 0){
            ListNode temp = new ListNode(carry);
            current.next = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};

        int[] nums3 = {0};
        int[] nums4 = {0};

        int[] nums5 = {9, 9, 9, 9, 9, 9, 9};
        int[] nums6 = {9, 9, 9, 9};

        ListNode head1 = generateLinkedList(nums1);
        ListNode head2 = generateLinkedList(nums2);
        ListNode head3 = generateLinkedList(nums3);
        ListNode head4 = generateLinkedList(nums4);
        ListNode head5 = generateLinkedList(nums5);
        ListNode head6 = generateLinkedList(nums6);

        ListNode newHead1 = addTwoNumbers(head1, head2);
        display(newHead1);

        ListNode newHead2 = addTwoNumbers(head3, head4);
        display(newHead2);

        ListNode newHead3 = addTwoNumbers(head5, head6);
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
