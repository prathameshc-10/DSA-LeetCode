package Math;

/*
Problem Name:
1492. The Kth Factor of n

Difficulty Level:
Medium

Approach:
The factors of a number n appear in pairs (i, n / i).
To avoid generating all factors, we iterate only up to sqrt(n).

First pass:
- Iterate from 1 to sqrt(n)
- For every divisor i, decrement k
- If k becomes 0, return i (smaller factors come first)

Second pass:
- Iterate from sqrt(n) down to 1
- For every divisor i, compute the paired factor (n / i)
- Skip the square root factor to avoid duplicates
- Decrement k and return when k reaches 0

This ensures factors are processed in increasing order
without storing them in extra space.

Time & Space Complexity:
Time Complexity: O(sqrt(n))
Space Complexity: O(1)
*/

class Solution {
    public int kthFactor(int n, int k) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0)
                    return i;
            }
        }

        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            if (n % i == 0) {
                int factor = n / i;
                if (factor != i) {
                    k--;
                    if (k == 0)
                        return factor;
                }
            }
        }
        return -1;
    }
}
