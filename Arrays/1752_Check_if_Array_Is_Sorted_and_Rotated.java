package Arrays;

/*
Problem Name:
1752. Check if Array Is Sorted and Rotated

Difficulty Level:
Easy

Approach:
An array that is sorted in non-decreasing order and then rotated
can have at most one position where the order breaks.

We iterate through the array and count how many times:
nums[i] > nums[(i + 1) % n]

The modulo operator is used to compare the last element with the first,
handling the circular nature of rotation.

If the count of such descending pairs exceeds 1, the array cannot be
a sorted and rotated array.

If the count is 0 or 1, the array is valid.

Time & Space Complexity:
Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
