package Strings;

/*
Problem Name:
String to Integer (atoi)

Difficulty:
Medium

Approach:
- The goal is to convert a given string into a 32-bit signed integer.
- Step 1: If the string is null or empty, return 0.
- Step 2: Skip all leading whitespace characters.
- Step 3: Check for optional sign character ('+' or '-').
          If '-' is found, set sign = -1. Otherwise, assume positive.
- Step 4: Use recursion to process numeric digits.
          - Base Case:
            If index is out of bounds OR current character is not a digit,
            return sign * result.
          - Recursive Case:
            Convert current character into digit.
            Before updating result, check for overflow using:
            result > (Integer.MAX_VALUE - digit) / 10
            If overflow occurs:
              return Integer.MAX_VALUE (if positive)
              return Integer.MIN_VALUE (if negative)
            Otherwise:
              Update result = result * 10 + digit
              Recursively call function for next index.
- Step 5: Final result is returned after recursion completes.

Time Complexity:
O(n) — Each character of the string is processed at most once.

Space Complexity:
O(n) — Due to recursion stack in the worst case (when the string contains only digits).
*/

class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int i = 0;
        int n = s.length();
        int sign = 1;

        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            if(s.charAt(i) == '-')
                sign = -1;
            i++;
        }

        return parseDigit(s, i, 0, sign);
    }

    private int parseDigit(String s, int i, int result, int sign){
        if(i >= s.length() || !Character.isDigit(s.charAt(i))){
            return sign * result;
        }

        int digit = s.charAt(i) - '0';
        if(result > (Integer.MAX_VALUE - digit) / 10){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        result = result * 10 + digit;
        return parseDigit(s, i+1, result, sign);
    }
}