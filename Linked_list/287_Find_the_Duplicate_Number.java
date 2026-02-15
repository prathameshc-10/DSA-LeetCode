/*
Problem Name:
Find the Duplicate Number

Difficulty:
Medium

Approach:
- The array contains n + 1 integers where each number is between 1 and n.
- We treat the array like a linked list:
  Index = Node
  Value = Next pointer
- Since one number is duplicated, it creates a cycle in this virtual linked list.
- We use Floyd’s Cycle Detection Algorithm (Tortoise & Hare).

Step 1: Detect Cycle
- Initialize two pointers slow and fast starting from nums[0].
- Move slow one step at a time: slow = nums[slow]
- Move fast two steps at a time: fast = nums[nums[fast]]
- When slow == fast, a cycle is confirmed.

Step 2: Find Entry Point of Cycle
- Reset slow to nums[0].
- Move both slow and fast one step at a time.
- The point where they meet again is the duplicate number.

Time Complexity:
O(n)

Space Complexity:
O(1)

*/

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
