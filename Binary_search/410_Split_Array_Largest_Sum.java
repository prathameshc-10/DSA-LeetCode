package Binary_search;

/*
Problem Name:
410. Split Array Largest Sum

Difficulty:
Hard

Approach:
- This problem is solved using Binary Search on Answer.
- We need to split the array into k subarrays such that the
  maximum subarray sum is minimized.

- Key Idea:
  - If we allow a smaller maximum sum → more subarrays are needed.
  - If we allow a larger maximum sum → fewer subarrays are needed.
  - This monotonic behavior allows binary search.

- Steps:
  1. Define Search Space:
     - Minimum possible value (low) = maximum element in array
       (because one element must be in a subarray)
     - Maximum possible value (high) = sum of all elements
       (entire array as one subarray)

  2. Apply Binary Search:
     - For each mid (candidate maximum subarray sum):
         → Count how many subarrays are needed so that
           no subarray sum exceeds mid.

     - If required subarrays > k:
         → mid is too small → increase low (low = mid + 1)

     - Else:
         → mid is valid → try smaller value (high = mid - 1)

  3. Return low:
     - At the end, low will be the minimum possible largest sum.

- Helper Function (countSubArray):
  - Greedily form subarrays:
     → Keep adding elements until sum exceeds limit (mid)
     → Then start a new subarray
  - Count how many subarrays are formed.

Time Complexity:
O(n * log(sum of array))
- Binary search runs log(sum) times
- Each check takes O(n)

Space Complexity:
O(1)
- No extra space is used.
*/

class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0; i < nums.length; i++){
            high += nums[i];
            low = Math.max(low, nums[i]);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            int subArray = countSubArray(nums, mid);
            if(subArray > k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    static int countSubArray(int[] arr, int val){
        int totalArray = 1;
        int totalVal = 0;
        for(int i = 0; i < arr.length; i++){
            if(totalVal + arr[i] > val){
                totalArray++;
                totalVal = arr[i];
            } else{
                totalVal += arr[i];
            }
        }
        return totalArray;
    }
}