package Two_pointers;
/*
LeetCode: Remove Duplicates from Sorted Array
Difficulty: Easy
Pattern: Two Pointers

Approach:
1. Use two pointers: low for last unique element, high to scan the array
2. If nums[low] == nums[high], move high
3. If different, increment low and copy nums[high] to nums[low]
4. Continue until end of array

Time Complexity: O(n)
Space Complexity: O(1)

*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int low = 0;
        int high = 1;
        while(high < nums.length){
            if(nums[low] == nums[high]){
                high++;
            } else {
                low++;
                nums[low] = nums[high++];
            }
        }
        return low+1;
    }
}