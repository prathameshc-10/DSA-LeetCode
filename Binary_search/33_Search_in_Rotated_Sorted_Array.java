package Binary_search;

/*
Problem Name:
33. Search in Rotated Sorted Array

Difficulty:
Medium

Approach:
- This problem is solved using a modified Binary Search.
- Even though the array is rotated, at least one half of the array is always sorted.
- At each recursive step:
  1. Find the middle element.
  2. If the middle element matches the target, return its index.
  3. Check which half (left or right) is sorted.
  4. Decide whether the target lies in the sorted half.
  5. Recursively search only the valid half and discard the other half.
- This ensures logarithmic time complexity.

Time Complexity:
O(log n)
- The search space is halved at each recursive step.

Space Complexity:
O(log n)
- Due to recursive call stack in binary search.
*/

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    private int binarySearch(int start, int end, int[] arr, int key) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == key) {
            return mid;
        }

        // Check if left half is sorted
        if (arr[start] <= arr[mid]) {
            // Target lies in the left sorted half
            if (arr[start] <= key && key < arr[mid]) {
                return binarySearch(start, mid - 1, arr, key);
            } else {
                return binarySearch(mid + 1, end, arr, key);
            }
        }
        // Right half is sorted
        else {
            // Target lies in the right sorted half
            if (arr[mid] < key && key <= arr[end]) {
                return binarySearch(mid + 1, end, arr, key);
            } else {
                return binarySearch(start, mid - 1, arr, key);
            }
        }
    }
}