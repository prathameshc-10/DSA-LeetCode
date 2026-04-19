package Binary_search;

/*
Problem Name:
1283. Find the Smallest Divisor Given a Threshold

Difficulty:
Medium

Approach:
- This problem is solved using Binary Search on Answer.
- We need to find the smallest divisor such that the sum of
  ceil(nums[i] / divisor) for all elements is ≤ threshold.

- Key Idea:
  - If we choose a smaller divisor → division results are larger → sum increases.
  - If we choose a larger divisor → division results are smaller → sum decreases.
  - This monotonic behavior allows binary search.

- Steps:
  1. Define Search Space:
     - Minimum divisor = 1
     - Maximum divisor = max element in the array

  2. Apply Binary Search:
     - For each mid (candidate divisor):
         → Calculate sum = Σ ceil(nums[i] / mid)
     - If sum ≤ threshold:
         → Try smaller divisor (high = mid - 1)
     - Else:
         → Increase divisor (low = mid + 1)

  3. Return low:
     - At the end, low points to the smallest valid divisor.

- Ceiling Calculation Trick:
  - Instead of using Math.ceil, use:
      (num + divisor - 1) / divisor
  - This avoids floating point operations.

Time Complexity:
O(n * log(max(nums)))
- Binary search runs log(max value) times
- Each iteration computes sum in O(n)

Space Complexity:
O(1)
- No extra space is used apart from variables.
*/

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int num : nums){
            high = Math.max(high, num);
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            if(sumByDivisor(nums, mid) <= threshold){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return low;
    }

    static int sumByDivisor(int[] arr, int d){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += (arr[i]+d-1)/d;
        }
        return sum;
    }
}