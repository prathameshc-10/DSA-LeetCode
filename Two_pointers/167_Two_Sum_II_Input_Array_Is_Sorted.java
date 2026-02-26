package Two_pointers;
/*
Problem Name:
Two Sum II – Input Array Is Sorted

Difficulty:
Medium

Approach:
- The goal is to find two numbers in a sorted array whose sum equals the given target.
- Since the array is already sorted in non-decreasing order, we can use the two-pointer technique.
- Step 1: Initialize two pointers:
          left = 0 (start of array)
          right = n - 1 (end of array)
- Step 2: While left < right:
          - Calculate sum = numbers[left] + numbers[right].
          - If sum == target:
                → Return the indices (left + 1, right + 1).
                (Indices are 1-based as required by the problem.)
          - If sum > target:
                → Decrease right pointer to reduce the sum.
          - If sum < target:
                → Increase left pointer to increase the sum.
- Step 3: If no pair is found, throw an exception (though problem guarantees exactly one solution).

Time Complexity:
O(n) — Each element is visited at most once by either pointer.

Space Complexity:
O(1) — Uses constant extra space (only two pointers).
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1, right+1};
            } else if(sum > target){
                right--;
            } else{
                left++;
            }
        }
        throw new IllegalArgumentException("No Match Found");
    }
}