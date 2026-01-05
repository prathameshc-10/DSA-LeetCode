package Greedy;

/*
 LeetCode: 1975. Maximum Matrix Sum
 Difficulty: Medium
 Pattern: Greedy / Math

 Approach:
 1. Traverse the matrix once.
 2. Add absolute value of every element to `sum`.
 3. Count how many elements are negative.
 4. Track the smallest absolute value in the matrix.
 5. If number of negatives is even → all values can be made positive.
 6. If odd → one element must remain negative, so subtract
    2 × smallest absolute value from total sum.

 Time Complexity: O(n^2)
 Space Complexity: O(1)
*/

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        
        int count = 0;       
        long sum = 0;
        long smallestAbsoluteValue = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                long val = Math.abs(matrix[i][j]);
                sum += val;
                smallestAbsoluteValue = Math.min(smallestAbsoluteValue, val);
                if (matrix[i][j] < 0) count++;
            }
        }

        if(count % 2 == 0){
            return sum;
        } else{
            return sum - 2*smallestAbsoluteValue;
        }
    }
}