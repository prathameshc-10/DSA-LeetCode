package Math;

/*
LeetCode: Four Divisors
Difficulty: Medium
Pattern: Number Theory

Approach:
A number has exactly 4 divisors only in two cases:
1. n = p³, where p is a prime number
   Divisors → 1, p, p², p³
2. n = p × q, where p and q are distinct primes
   Divisors → 1, p, q, p*q

For each number:
- Check if it is of form p³ using cube root
- Otherwise, find one divisor pair (p, q) up to √n
- If valid, directly add the sum of divisors

Time Complexity: O(n √n)
Space Complexity: O(1)
*/

class Solution {
    private boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for(int i = 0; i < nums.length; i++){
            //Case1 :- n = p^3
            int p = (int) Math.round(Math.cbrt(nums[i]));
            if(p*p*p == nums[i] && isPrime(p)){
                totalSum += (1 + p + p*p + p*p*p);
                continue;
            }

            //Case2 :- n = p*q
            for (int k = 2; k * k <= nums[i]; k++) {
                if (nums[i] % k == 0) {
                    int j = nums[i] / k;
                    if (k != j && isPrime(k) && isPrime(j)) {
                        totalSum += (1 + k + j + k*j);
                    }
                    break; 
                }
            }
        }

        return totalSum;
    }
}
