package Binary_search;

/*
Problem Name:
81. Search in Rotated Sorted Array II

Difficulty:
Medium

Approach:
- This problem is solved using a modified Binary Search.
- The array may contain duplicates, which makes it harder to determine the sorted half.
- At each recursive step:
  1. Find the middle element.
  2. If the middle element matches the target, return true.
  3. If elements at low, mid, and high are equal, we cannot determine the sorted half.
     - In this case, shrink the search space by moving both pointers inward.
  4. Otherwise, check which half (left or right) is sorted.
  5. Determine if the target lies within the sorted half.
  6. Recursively search only the relevant half and discard the other half.
- This handles both rotation and duplicate values.

Time Complexity:
- Average Case: O(log n)
  - Similar to standard binary search when duplicates are minimal.
- Worst Case: O(n)
  - When many duplicates exist (e.g., all elements same), we may shrink the array linearly.

Space Complexity:
O(log n)
- Due to recursive call stack.
*/


class Solution {
    public boolean search(int[] nums, int target) {
        return binarySearch(0, nums.length-1, nums, target);
    }

    public boolean binarySearch(int low, int high, int[] arr, int target){
        if(low > high){
            return false;
        }

        int mid = low + (high- low) /2;
        if(arr[mid] == target) return true;

        if(arr[low] == arr[mid] && arr[mid] == arr[high]){
            return binarySearch(low+1, high-1, arr, target);
        }

        if(arr[low] <= arr[mid]){
            if(arr[low] <= target && target <= arr[mid]){
                return binarySearch(low, mid-1, arr, target);
            } else{
                return binarySearch(mid+1, high, arr, target);
            }
        } else{
            if(arr[mid] <= target && target <= arr[high]){
                return binarySearch(mid+1, high, arr, target);
            } else {
                return binarySearch(low, mid-1, arr, target);
            }
        }
    }
}
