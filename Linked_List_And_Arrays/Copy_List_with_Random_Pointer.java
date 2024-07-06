/*
    Problem Name: Copy List with Random Pointer
    Problem Link: https://leetcode.com/problems/copy-list-with-random-pointer/
*/

public class Copy_List_with_Random_Pointer {
    /*
        Brute Force Approach
        TC -> O(N) + O(N)
        SC -> O(N){for hashmap} + O(N){for creating deep copy and I can't avoid this as its required in the problem}
        public static Node copyRandomList(Node head) {
            HashMap<Node, Node> map = new HashMap<>();
            Node temp = head;
            while(temp != null){
                Node newNode = new Node(temp.val);
                map.put(temp, newNode);
                temp = temp.next;
            }
            
            temp = head;
            while(temp != null){
                Node copiedNode = map.get(temp);
                copiedNode.next = map.get(temp.next);
                copiedNode.random = map.get(temp.random);
                temp = temp.next;
            }
            return map.get(head);
        }
    */

    /*
        Optimal Solution
        TC -> O(N) + O(N) + O(N) -> O(3N)
        SC -> O(N){for  creating the deep copy of the list}
    */
    public static Node copyRandomList(Node head) {
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        temp = head;
        while(temp != null){
            Node copiedNode = temp.next;
            if(temp.random != null)
                copiedNode.random = temp.random.next;
            else
                copiedNode.random = null;
            temp = temp.next.next;
        }

        temp = head;
        Node dummyNode = new Node(-1);
        Node result = dummyNode;
        while(temp != null){
            result.next = temp.next;
            temp.next = temp.next.next;
            result = result.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }

    public static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
