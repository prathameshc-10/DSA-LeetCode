package Binary_search;

/*
Problem Name:
540. Single Element in a Sorted Array

Difficulty:
Medium

Approach:
- This problem is solved using Binary Search on a sorted array.
- Every element appears exactly twice except one element that appears only once.
- Key Observation:
  - In a properly paired array:
    - First occurrence of a pair is at even index.
    - Second occurrence is at odd index.
  - After the single element, this pattern breaks.

- Steps:
  1. Handle edge cases:
     - If array size is 1 → return that element.
     - If first element is unique → return nums[0].
     - If last element is unique → return nums[n-1].
  2. Apply Binary Search between indices 1 and n-2.
  3. For each mid:
     - If nums[mid] is not equal to its neighbors → it is the answer.
  4. Otherwise, check pairing pattern:
     - If mid is odd and matches previous OR
       mid is even and matches next → move right.
     - Else → move left.
  5. Continue until the single element is found.

Time Complexity:
O(log n)
- Binary search reduces the search space by half each time.

Space Complexity:
O(1)
- No extra space used (iterative approach).
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int low = 1;
        int high = nums.length - 2;

        while(low <= high){
            int mid = low + (high -low)/2;
            if((nums[mid] != nums[mid-1]) && (nums[mid] != nums[mid+1])){
                return nums[mid];
            }

            if((mid % 2 == 1 && nums[mid] == nums[mid-1]) || 
                (mid % 2 == 0 && nums[mid] == nums[mid+1])){
                    low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return -1;
    }
}