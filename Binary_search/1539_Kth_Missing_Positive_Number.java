package Binary_search;

/*
Problem Name:
1539. Kth Missing Positive Number

Difficulty:
Easy

Approach:
- This problem is solved using Binary Search on index.

- Key Idea:
  - In a perfect array [1,2,3,...], the value at index i should be (i + 1).
  - If elements are missing, we can calculate how many numbers are missing
    before index i using:
        missing = arr[i] - (i + 1)

- Steps:
  1. Apply Binary Search:
     - For each mid:
         → Calculate missing numbers till mid.
     - If missing < k:
         → Move right (low = mid + 1)
     - Else:
         → Move left (high = mid - 1)

  2. After loop:
     - 'low' represents the position where kth missing number fits.

  3. Final Answer:
     - kth missing number = low + k

- Why low + k?
  - 'low' tells how many elements are present before the answer.
  - Adding k gives the actual missing number.

Time Complexity:
O(log n)
- Binary search over the array.

Space Complexity:
O(1)
- No extra space used.
*/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return low + k;
    }
}