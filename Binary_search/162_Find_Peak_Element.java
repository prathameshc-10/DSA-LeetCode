package Binary_search;

/*
Problem Name:
162. Find Peak Element

Difficulty:
Medium

Approach:
- This problem is solved using Binary Search.
- A peak element is an element that is strictly greater than its neighbors.

- Key Observation:
  - If we are on an increasing slope → peak lies on the right.
  - If we are on a decreasing slope → peak lies on the left.
  - There is always at least one peak in the array.

- Steps:
  1. Handle edge cases:
     - If array has only one element → return index 0.
     - If first element is greater than second → return 0.
     - If last element is greater than second last → return n-1.
  2. Apply Binary Search between indices 1 and n-2.
  3. For each mid:
     - If nums[mid] is greater than both neighbors → it's a peak.
  4. Otherwise:
     - If nums[mid] > nums[mid-1] → move right (ascending slope).
     - Else → move left (descending slope).
  5. Continue until peak is found.

Time Complexity:
O(log n)
- Binary search reduces the search space by half each time.

Space Complexity:
O(1)
- Iterative approach, no extra space used.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int low = 1;
        int high = n-2;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;

            if(nums[mid] > nums[mid-1])
                low = mid+1;
            else
                high = mid-1;
        } 
        return -1;
    }
}