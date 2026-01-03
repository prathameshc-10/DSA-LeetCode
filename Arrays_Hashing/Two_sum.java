/*
 LeetCode: Two Sum
 Difficulty: Easy
 Pattern: Hashing (Complement Lookup)

 Approach:
 1. Use a HashMap to store numbers and their indices.
 2. For each element, calculate the complement = target − current number.
 3. If the complement exists in the map, return both indices.
 4. Otherwise, store the current number with its index.
 5. Exactly one valid answer is guaranteed.

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            } else{
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No match found");
    }
}

