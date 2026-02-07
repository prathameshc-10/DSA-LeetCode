package Two_pointers;

/*
Problem Name:
75. Sort Colors

Difficulty Level:
Medium

Approach:
This problem is solved using the Dutch National Flag algorithm.
Three pointers are used:
- low to track the position for placing 0s
- mid to traverse the array
- high to track the position for placing 2s

The array is partitioned into four sections:
[0 ... low-1] -> all 0s
[low ... mid-1] -> all 1s
[mid ... high] -> unknown elements
[high+1 ... end] -> all 2s

Based on the value at nums[mid]:
- If it is 0, swap it with nums[low] and move both pointers
- If it is 1, simply move mid
- If it is 2, swap it with nums[high] and move high

This ensures the array is sorted in a single pass.

Time & Space Complexity:
Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
