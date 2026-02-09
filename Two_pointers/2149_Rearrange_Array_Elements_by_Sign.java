package Two_pointers;

/*
Problem Name:
Rearrange Array Elements by Sign

Difficulty:
Medium

Approach:
- The problem guarantees an equal number of positive and negative integers.
- The required arrangement is: positive at even indices and negative at odd indices.
- We create a result array of the same size.
- Use two pointers:
    - `pos` starts at index 0 for placing positive numbers
    - `neg` starts at index 1 for placing negative numbers
- Traverse the input array once:
    - If the number is positive, place it at `pos` and move `pos` by 2
    - If the number is negative, place it at `neg` and move `neg` by 2
- This avoids using extra lists and keeps the solution efficient.

Time Complexity:
O(n) — Single pass through the array

Space Complexity:
O(n) — Result array used for rearranging elements
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int pos = 0, neg = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result[pos] = nums[i];
                pos += 2;
            } else{
                result[neg] = nums[i];
                neg += 2;
            }
        }
        return result; 
    }
}