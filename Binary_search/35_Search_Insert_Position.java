package Binary_search;

/*
Problem Name:
35. Search Insert Position

Difficulty:
Easy

Approach:
- This problem is solved using Binary Search.
- The goal is to find the index where the target should be inserted
  in a sorted array so that order is maintained.

- At each step:
  1. Calculate the middle index.
  2. If nums[mid] is greater than or equal to target:
     - Move to the left half (high = mid - 1)
     - Because the correct position could be earlier.
  3. Otherwise:
     - Move to the right half (low = mid + 1)

- When the loop ends:
  - 'low' will point to the correct insert position.
  - This works because binary search narrows down to the first index
    where element is >= target (Lower Bound).

- This handles all cases:
  - Target exists → returns its index
  - Target smaller than all → returns 0
  - Target larger than all → returns n (end position)

Time Complexity:
O(log n)
- Binary search reduces the search space by half each time.

Space Complexity:
O(1)
- No extra space is used.
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
}

