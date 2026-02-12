package Two_pointers;

/*
Problem Name:
Next Permutation

Difficulty:
Medium

Approach:
- The goal is to transform the given array into the next lexicographically greater permutation.
- Step 1: Traverse from right to left and find the first index 'i' such that nums[i] < nums[i + 1].
          This is called the breakpoint. It indicates where increasing order breaks.
- Step 2: If a breakpoint exists, traverse again from right to left and find the first element
          greater than nums[i]. Swap both elements.
- Step 3: Reverse the subarray from index i + 1 to the end.
          This ensures the smallest lexicographical order for the right half.
- If no breakpoint is found (array is in descending order),
  simply reverse the whole array to get the smallest permutation.

Time Complexity:
O(n) — We traverse the array at most three times (find breakpoint, find swap, reverse).

Space Complexity:
O(1) — The rearrangement is done in-place using constant extra memory.
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
