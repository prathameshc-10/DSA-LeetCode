package Sliding_window;

/*
 Problem Name:
 Find Maximum Number of Consecutive 1s

 Difficulty Level:
 Easy

 Approach:
 - Use a variable `count` to track the current number of consecutive 1s.
 - Use another variable `maxOne` to store the maximum consecutive 1s found so far.
 - Traverse the array:
     - If the current element is 1, increment `count` and update `maxOne`.
     - If the current element is 0, reset `count` to 0.
 - Return `maxOne` as the final answer.

 Time Complexity: O(n) 
 Space Complexity: O(1)
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxOne = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
                maxOne = Math.max(maxOne, count);
            } else {
                count = 0;
            }
        }
        return maxOne;
    }
}
