package Binary_search;

/*
Problem Name:
Find Minimum in Rotated Sorted Array

Difficulty:
Medium

Approach:
- This solution uses Recursive Binary Search to find the minimum element
  in a rotated sorted array.
- The idea is based on the observation that in a rotated sorted array,
  at least one half is always sorted.

- Step 1: Base Case
  If start >= end, it means only one element is left.
  That element is the minimum, so return nums[start].

- Step 2: Find Mid
  Calculate mid = start + (end - start) / 2
  This avoids integer overflow.

- Step 3: Decide Search Space
  - If nums[mid] > nums[end],
    it means the minimum element lies in the right half.
    So recursively search from mid + 1 to end.
  - Otherwise,
    the minimum lies in the left half (including mid).
    So recursively search from start to mid.

- The recursion keeps reducing the search space by half
  until the minimum element is found.

Time Complexity:
O(log n)
- At each recursive call, the search space is reduced by half.

Space Complexity:
O(log n)
- Due to recursive call stack space.
*/

class Solution {
    public int findMin(int[] nums) {
        return minElement(0, nums.length-1, nums);
    }

    private int minElement(int start, int end, int[] nums){
        if(start >= end){
            return nums[start];
        }

        int mid = start + (end - start) / 2;
        if(nums[mid] > nums[end]){
            return minElement(mid + 1, end, nums);
        } else{
            return minElement(start, mid, nums);
        }
    }
}