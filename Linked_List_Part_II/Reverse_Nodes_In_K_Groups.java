/*
    Problem Name: Reverse Nodes in k-Group
    Problem Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
*/

public class Reverse_Nodes_In_K_Groups {
    /*
        Optimal Solution
        TC -> O(N) + O(N) -> O(2N)
        SC -> O(1)
    */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;
        while(temp != null){
            ListNode kthNode = getKthNode(temp, k);
            if(kthNode == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(temp == head){
                head = kthNode;
            }else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    public static ListNode getKthNode(ListNode head, int k){
        while(head != null && k > 1){
            head = head.next;
            k -= 1;
        }
        return head;
    }
    
    public static void reverse(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
    }

    public static void main(String[] args){
        /*
            Test Case 1
            head -> 1 -> 2 -> 3 -> 4 -> 5 -> null
        */
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        ListNode head1 = generateLinkedList(nums1);
        System.out.print("Before Reversing in K-Groups: ");
        display(head1);
        head1 = reverseKGroup(head1, k1);
        System.out.print("After Reversing in K-Groups: ");
        display(head1);

        /*
            Test Case 2
            head -> 1 -> 2 -> 3 -> 4 -> 5 -> null
        */
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 3;
        ListNode head2 = generateLinkedList(nums2);
        System.out.print("Before Reversing in K-Groups: ");
        display(head2);
        head2 = reverseKGroup(head2, k2);
        System.out.print("After Reversing in K-Groups: ");
        display(head2);

        /*
            Test Case 3
            head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> null
        */
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int k3 = 3;
        ListNode head3 = generateLinkedList(nums3);
        System.out.print("Before Reversing in K-Groups: ");
        display(head3);
        head3 = reverseKGroup(head3, k3);
        System.out.print("After Reversing in K-Groups: ");
        display(head3);
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
