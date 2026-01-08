package Greedy;

/*
 Problem Name:
 Majority Element

 Difficulty Level:
 Easy

 Approach:
 Boyer–Moore Voting Algorithm.
 The idea is to maintain a candidate for the majority element and a counter.
 - If count becomes 0, pick the current element as the new candidate.
 - Increment count if the current element matches the candidate.
 - Decrement count otherwise.
 Since the majority element appears more than n/2 times, it will always remain
 as the final candidate after one complete pass.

 Time Complexity: O(n) 
 Space Complexity: O(1) 
*/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count += (nums[i] == candidate) ? 1 : -1;
        }

        return candidate;
    }
}

