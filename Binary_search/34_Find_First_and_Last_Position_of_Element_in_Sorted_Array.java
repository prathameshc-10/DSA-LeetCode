package Binary_search;

/*
Problem Name:
34. Find First and Last Position of Element in Sorted Array

Difficulty:
Medium

Approach:
- This problem is solved using Binary Search with two separate functions:
  1. Lower Bound → to find the first occurrence of the target.
  2. Upper Bound → to find the last occurrence of the target.

- First Position (Lower Bound):
  - Find the first index where element is greater than or equal to target.
  - Move left (high = mid - 1) to get the earliest occurrence.

- Last Position (Upper Bound):
  - Find the first index where element is strictly greater than target.
  - Subtract 1 from that index to get the last occurrence.
  - If no element is greater than target, last occurrence is at the end of array.

- Edge Case Handling:
  - After finding first position, check if target actually exists.
  - If not found, return [-1, -1].

- This approach avoids linear scanning and ensures efficient search.

Time Complexity:
O(log n)
- Two binary searches are performed, each taking logarithmic time.

Space Complexity:
O(1)
- No extra space is used apart from variables.
*/

class Solution {
    static int firstPosition(int[] nums, int x){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high- low)/2;
            if(nums[mid] >= x){
                ans = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return ans;
    }

    static int lastPosition(int[] nums, int x){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high- low)/2;
            if(nums[mid] > x){
                ans = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return (ans == -1) ? nums.length - 1 : ans - 1;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = firstPosition(nums, target);

        if(first == -1 || nums[first] != target){
            return new int[]{-1, -1};
        }

        int last = lastPosition(nums, target);
        int[] ans = {first, last};
        return ans;
    }
}