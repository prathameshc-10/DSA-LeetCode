package Two_pointers;

/*
 LeetCode: 283. Move Zeroes
 Difficulty: Easy
 Pattern: Two Pointers / Array

 Approach:
 1. Use a pointer `pos` to track the index where the next non-zero element should be placed.
 2. Traverse the array from left to right.
 3. Whenever a non-zero element is found, place it at index `pos` and increment `pos`.
 4. After moving all non-zero elements, fill the remaining positions with zeroes.
 5. This maintains the relative order of non-zero elements and modifies the array in place.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int  i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pos] = nums[i];
                pos++;
            }
        }
        for(int i = pos; i < nums.length; i++){
            nums[i] = 0;
        }
    }
} 
