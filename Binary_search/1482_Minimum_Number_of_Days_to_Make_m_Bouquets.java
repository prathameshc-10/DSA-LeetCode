package Binary_search;

/*
Problem Name:
1482. Minimum Number of Days to Make m Bouquets

Difficulty:
Medium

Approach:
- This problem is solved using Binary Search on Answer.
- Instead of searching indices, we search the minimum number of days required.

- Key Idea:
  - Each flower blooms on a specific day.
  - We need to check: "Can we make m bouquets on a given day?"
  - Each bouquet requires k adjacent bloomed flowers.

- Steps:
  1. Edge Case:
     - If m * k > total flowers, it's impossible → return -1.

  2. Define Search Space:
     - Minimum possible day = minimum value in bloomDay array.
     - Maximum possible day = maximum value in bloomDay array.

  3. Apply Binary Search:
     - For a given mid (day), check if it's possible to make m bouquets.
     - If possible:
         → Try smaller days (high = mid - 1)
     - Else:
         → Increase days (low = mid + 1)

  4. Feasibility Check (isPossible):
     - Traverse the array and count consecutive flowers bloomed by 'day'.
     - Every k consecutive flowers form 1 bouquet.
     - Reset count when a flower hasn't bloomed yet.
     - Check if total bouquets ≥ m.

- This ensures we find the minimum day efficiently.

Time Complexity:
O(n * log(maxDay - minDay))
- Binary search runs log(range) times
- Each check takes O(n)

Space Complexity:
O(1)
- No extra space is used apart from variables.
*/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m * k > n) return -1;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int d : bloomDay){
            low = Math.min(low, d);
            high = Math.max(high, d);
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(bloomDay, mid, m, k)){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return low;
    }

    static boolean isPossible(int[] arr, int day, int m, int k){
        int count = 0;
        int noBoq = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= day)
                count++;
            else{
                noBoq += (count / k);
                count = 0;
            }
        }
        noBoq += (count / k);
        return noBoq >= m;
    }
}
