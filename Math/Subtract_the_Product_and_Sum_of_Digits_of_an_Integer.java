package Math;

/*
 LeetCode: Subtract the Product and Sum of Digits of an Integer
 Difficulty: Easy
 Pattern: Math

 Approach:
 1. Initialize product to 1 and sum to 0.
 2. Extract each digit of the number using modulo and division.
 3. Update product and sum accordingly.
 4. Return the difference between product and sum.

 Time Complexity: O(d) where d is the number of digits in n
 Space Complexity: O(1)  
*/

class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }

        return product-sum;
    }
}
