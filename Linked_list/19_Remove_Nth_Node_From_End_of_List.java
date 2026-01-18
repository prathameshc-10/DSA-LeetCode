package Linked_list;

/*
Problem Name:
Remove Nth Node From End of List

Difficulty Level:
Medium

Approach:
- Use the Two Pointer technique with a dummy node.
- Create a dummy node pointing to the head to handle edge cases
  (e.g., removing the first node).
- Move the right pointer (n + 1) steps ahead to maintain a fixed gap.
- Move both left and right pointers together until right reaches null.
- The left pointer will then be just before the node to be removed.
- Update pointers to remove the target node.

Time Complexity: O(n)
Space Complexity: O(1)

*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) { 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode right = dummy;
        ListNode left = dummy;
        while((n+1) > 0){
            right = right.next;
            n--;
        }
        while(right != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        
        return dummy.next;
    }
}
