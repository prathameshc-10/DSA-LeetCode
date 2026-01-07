package Prefix_Suffix;

/*
 LeetCode: Product of Array Except Self
 Difficulty: Medium
 Pattern: Prefix & Suffix Product (Arrays)

 Approach:
 1. Create a result array where result[i] stores the product of all elements to the LEFT of index i.
 2. Initialize result[0] = 1 since there are no elements before the first index.
 3. Traverse from left to right and build prefix products using:
    result[i] = result[i - 1] * nums[i - 1]
 4. Traverse from right to left while maintaining a running rightProduct.
 5. Multiply result[i] with rightProduct to include product of elements to the RIGHT of index i.
 6. Update rightProduct by multiplying it with nums[i] after each step.

 Time Complexity: O(n)
 Space Complexity: O(1) extra space (output array excluded)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for(int i = 1; i < n; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        int rightProduct = 1;
        for(int i = n-1; i >= 0; i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}