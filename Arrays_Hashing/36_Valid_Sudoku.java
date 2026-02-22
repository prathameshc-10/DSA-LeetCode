/*
Problem Name:
Valid Sudoku

Difficulty Level:
Medium

Approach:
1. Create three 2D boolean arrays:
   - rows[9][9] → tracks digits present in each row.
   - cols[9][9] → tracks digits present in each column.
   - boxes[9][9] → tracks digits present in each 3x3 sub-box.

2. Traverse the board using nested loops (i = row, j = column).

3. Skip empty cells ('.') since only filled cells need validation.

4. Convert the digit character ('1' to '9') into a 0-based index:
   - int num = board[i][j] - '1';
   - This maps:
       '1' → 0
       '2' → 1
       ...
       '9' → 8

5. Compute the 3x3 box index using:
   - int boxIndex = (i / 3) * 3 + (j / 3);
   - This ensures each cell maps to one of the 9 sub-boxes.

6. Check if the number already exists in:
   - the current row → rows[i][num]
   - the current column → cols[j][num]
   - the current box → boxes[boxIndex][num]

   If any of them is true → duplicate found → return false.

7. Otherwise, mark the number as seen in:
   - rows[i][num] = true
   - cols[j][num] = true
   - boxes[boxIndex][num] = true

8. If the entire board is processed without duplicates,
   return true.

Time & Space Complexity:
Time Complexity: O(9 × 9) = O(1)
- The board size is fixed (81 cells).

Space Complexity: O(9 × 9) = O(1)
- We use fixed-size boolean arrays (constant space).
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(board[i][j] == '.') continue;

                int num = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + (j / 3);

                if(rows[i][num] || cols[j][num] || boxes[boxIndex][num])
                    return false;

                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}