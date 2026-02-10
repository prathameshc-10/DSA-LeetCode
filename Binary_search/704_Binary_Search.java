package Binary_search;

/*
Problem Name:
Binary Search

Difficulty:
Easy

Approach:
- This solution uses recursive Binary Search on a sorted array.
- At each step:
  1. Calculate the middle index.
  2. If the middle element matches the target, return its index.
  3. If the target is greater than the middle element, search the right half.
  4. Otherwise, search the left half.
- The search space is reduced by half on every recursive call.

Time Complexity:
O(log n)
- The array is divided into halves at each step.

Space Complexity:
O(log n)
- Due to recursive call stack.
*/

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    private int binarySearch(int start, int end, int[] nums, int key) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == key) {
            return mid;
        }

        if (nums[mid] < key)
            return binarySearch(mid + 1, end, nums, key);
        else
            return binarySearch(start, mid - 1, nums, key);
    }
}
