package Two_pointers;

/*
Problem Name:
Trapping Rain Water

Difficulty:
Hard

Approach:
- The goal is to compute how much water can be trapped between bars after raining.
- Instead of using extra arrays for leftMax and rightMax, we use an optimized
  two-pointer technique to achieve O(1) space.

- Step 1: Initialize two pointers:
          left = 0 (start of array)
          right = n - 1 (end of array)

- Step 2: Initialize two variables:
          leftmax = height[left]
          rightmax = height[right]
          These track the maximum height seen so far from both ends.

- Step 3: While left < right:
          - If leftmax < rightmax:
                → Move left pointer forward.
                → Update leftmax = max(leftmax, height[left]).
                → Water trapped at this position is:
                      leftmax - height[left]
                → Add it to totalWater.
          - Else:
                → Move right pointer backward.
                → Update rightmax = max(rightmax, height[right]).
                → Water trapped at this position is:
                      rightmax - height[right]
                → Add it to totalWater.

- The logic works because water is always limited by the smaller boundary.
  If leftmax < rightmax, the left side determines the water level.
  Otherwise, the right side determines it.

Time Complexity:
O(n) — Each element is processed at most once by either pointer.

Space Complexity:
O(1) — Uses only constant extra variables (no additional arrays).
*/

class Solution {
    public int trap(int[] height) {
        int left = 0; 
        int right = height.length - 1;
        int leftmax = height[left];
        int rightmax = height[right];
        int totalWater = 0;

        while(left < right){
            if(leftmax < rightmax){
                left++;
                leftmax = Math.max(leftmax, height[left]);
                totalWater += leftmax - height[left];
            } else{
                right--;
                rightmax = Math.max(rightmax, height[right]);
                totalWater += rightmax - height[right];
            }
        }
        return totalWater;
    }
}