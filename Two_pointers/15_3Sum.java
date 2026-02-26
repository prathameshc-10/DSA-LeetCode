package Two_pointers;
/*
Problem Name:
3Sum

Difficulty:
Medium

Approach:
- The goal is to find all unique triplets in the array whose sum equals zero.
- Step 1: Sort the array. Sorting helps in using the two-pointer technique
          and also makes it easy to skip duplicate elements.
- Step 2: Iterate through the array using index 'i' from 0 to n - 3.
          Treat nums[i] as the fixed element.
- Step 3: Skip duplicate values for index 'i' to avoid repeated triplets.
- Step 4: For each fixed element, use two pointers:
          left = i + 1
          right = n - 1
- Step 5: While left < right:
          - Calculate sum = nums[i] + nums[left] + nums[right].
          - If sum == 0:
                → Add the triplet to the result list.
                → Skip duplicate values for left and right.
                → Move both pointers inward.
          - If sum < 0:
                → Move left pointer forward to increase sum.
          - If sum > 0:
                → Move right pointer backward to decrease sum.
- This ensures all unique triplets are found efficiently.

Time Complexity:
O(n²) — Sorting takes O(n log n), and the two-pointer traversal runs in O(n²).
Overall dominant complexity is O(n²).

Space Complexity:
O(1) auxiliary space (excluding result storage).
The sorting is done in-place and only constant extra variables are used.
*/

import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                } else if(sum < 0){
                    left++;
                } else{
                    right--;
                }
            }
        }
        return result;
    }
}
