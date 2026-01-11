package Two_pointers;

/*
 Problem Name: Remove Element
 Difficulty: Easy

 Approach:
 - Use the two-pointer technique.
 - `fast` pointer iterates through the array to examine each element.
 - `slow` pointer tracks the position to place the next valid (non-val) element.
 - When `nums[fast]` is not equal to `val`, copy it to `nums[slow]` and increment `slow`.
 - This modifies the array in-place and keeps all valid elements at the front.
 - The value of `slow` represents the new length of the array after removal.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }
}
