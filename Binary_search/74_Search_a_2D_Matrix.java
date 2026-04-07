package Binary_search;
/*
Problem Name:
Search a 2D Matrix

Difficulty:
Medium

Approach:
- The matrix has the following properties:
    → Each row is sorted in ascending order.
    → The first element of each row is greater than the last element of the previous row.
- Because of this property, the entire matrix can be treated as a single sorted 1D array.
- Instead of searching row by row, we perform Binary Search on the virtual 1D array.

Steps:
1. Let rows = number of rows and cols = number of columns.
2. Treat the matrix as an array of size rows * cols.
3. Perform Binary Search between index 0 and rows*cols - 1.
4. Convert the 1D mid index back to 2D indices:
       row = mid / cols
       col = mid % cols
5. Compare matrix[row][col] with target:
       → If equal, return true.
       → If smaller, search right half.
       → If larger, search left half.
6. If not found after the loop, return false.

Time Complexity:
O(log(m * n))
Binary search over all elements of the matrix.

Space Complexity:
O(1)
No extra space is used.
*/
 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int row = mid / cols;
            int col = mid % cols;

            int value = matrix[row][col];
            if(value == target){
                return true;
            }
            if(value < target){
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        return false;
    }
}
