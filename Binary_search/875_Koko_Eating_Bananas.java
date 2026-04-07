package Binary_search;

/*
Problem Name:
Koko Eating Bananas

Difficulty:
Medium

Approach:
- This solution uses Binary Search on Answer.
- The eating speed k lies between 1 and max(piles).
- At each step:
  1. Calculate mid (possible eating speed).
  2. Compute total hours required to eat all piles using:
     hours = ceil(pile / mid)
  3. If total hours <= h:
     - This is a valid speed, so try to minimize k (move left).
  4. Otherwise:
     - Speed is too slow, increase k (move right).
- Continue until we find the minimum valid k.

Time Complexity:
O(n * log(max(piles)))
- Binary search runs in log(max) time.
- Each check takes O(n) to traverse piles.

Space Complexity:
O(1)
- No extra space used.
*/

class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int totalHours = 0;

        for (int pile : piles) {
            totalHours += (pile + k - 1) / k;
        }

        return totalHours <= h;
    }

    private int getMax(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}