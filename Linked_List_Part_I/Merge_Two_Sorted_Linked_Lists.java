/*
    Problem Name: Merge Two Sorted Lists
    Problem Link: https://leetcode.com/problems/merge-two-sorted-lists/description/
*/

public class Merge_Two_Sorted_Linked_Lists {
    /*
        Approach 1
        TC -> O(N1 + N2)
        SC -> O(N1 + N2)
        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummyNode = new ListNode(-1);
            ListNode current = dummyNode;
            while(list1 != null && list2 != null){
                if(list1.val <= list2.val){
                    ListNode temp = new ListNode(list1.val);
                    current.next = temp;
                    current = temp;
                    list1 = list1.next;
                }else{
                    ListNode temp = new ListNode(list2.val);
                    current.next = temp;
                    current = temp;
                    list2 = list2.next;
                }
            }

            while(list1 != null){
                ListNode temp = new ListNode(list1.val);
                current.next = temp;
                current = temp;
                list1 = list1.next;
            }

            while(list2 != null){
                ListNode temp = new ListNode(list2.val);
                current.next = temp;
                current = temp;
                list2 = list2.next;
            }
            return dummyNode.next;
        }
    */

    /*
        Approach 2
        In Place Merging just by changing the links between nodes
        TC -> O(N1 + N2)
        SC -> O(1)
    */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)   return list2;
        if(list2 == null)    return list1;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        if(list1.val > list2.val){
            // Swapping
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        current.next = list1;
        while(list1 != null && list2 != null){
            while(list1 != null && list1.val <= list2.val){
                current = list1;
                list1 = list1.next;
            }
            current.next = list2;
            // Swapping
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        return dummyNode.next;
    }

    public static void main(String[] args){
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};

        int[] nums3 = {};
        int[] nums4 = {};

        int[] nums5 = {};
        int[] nums6 = {0};

        ListNode head1 = generateLinkedList(nums1);
        ListNode head2 = generateLinkedList(nums2);
        ListNode head3 = generateLinkedList(nums3);
        ListNode head4 = generateLinkedList(nums4);
        ListNode head5 = generateLinkedList(nums5);
        ListNode head6 = generateLinkedList(nums6);

        ListNode mergesHead1 = mergeTwoLists(head1, head2);
        display(mergesHead1);

        ListNode mergesHead2 = mergeTwoLists(head3, head4);
        display(mergesHead2);

        ListNode mergesHead3 = mergeTwoLists(head5, head6);
        display(mergesHead3);
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
