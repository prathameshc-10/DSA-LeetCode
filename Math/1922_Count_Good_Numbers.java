package Math;

/*
Problem Name:
Count Good Numbers

Difficulty:
Medium

Approach:
- A digit string is considered "good" if:
    - Digits at even indices (0-based) are even numbers → {0, 2, 4, 6, 8} → 5 choices.
    - Digits at odd indices are prime numbers → {2, 3, 5, 7} → 4 choices.
- Step 1: Count how many even and odd positions exist in a string of length n.
    - Even positions = (n + 1) / 2
    - Odd positions = n / 2
- Step 2: Total good strings =
    (5 ^ evenCount) × (4 ^ oddCount) % (10^9 + 7)
- Step 3: Since n can be very large (up to 10^15), we use Binary Exponentiation
          to compute powers efficiently in O(log n) time.
- Binary Exponentiation works by:
    - Multiplying result when exponent is odd.
    - Squaring the base each step.
    - Dividing exponent by 2 using right shift.

Time Complexity:
O(log n)
- Binary exponentiation reduces the exponent by half in each iteration.

Space Complexity:
O(1)
- Iterative implementation uses constant extra space.
*/
class Solution {

    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {

        long evenCount = (n + 1) / 2;  // Count of even index positions
        long oddCount = n / 2;        // Count of odd index positions

        long evenPart = power(5, evenCount);  // 5 choices for even indices
        long oddPart = power(4, oddCount);    // 4 choices for odd indices

        return (int)((evenPart * oddPart) % MOD);
    }

    private long power(long base, long exp) {

        long result = 1;
        base = base % MOD;

        while (exp > 0) {

            if ((exp & 1) == 1) {     // If exponent is odd
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;  // Square the base
            exp = exp >> 1;              // Divide exponent by 2
        }

        return result;
    }
}