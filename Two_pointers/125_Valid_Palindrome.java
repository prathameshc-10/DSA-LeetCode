package Two_pointers;

/*
Problem Name:
Valid Palindrome

Difficulty Level:
Easy

Approach:
- Use the Two Pointer technique to compare characters from both ends.
- Initialize two pointers: one at the start (left) and one at the end (right).
- Skip all non-alphanumeric characters using Character.isLetterOrDigit().
- Compare characters in a case-insensitive manner using Character.toLowerCase().
- If all valid characters match, the string is a palindrome.

Time Complexity:
O(n)
- Each character is visited at most once.

Space Complexity:
O(1)
- No extra space is used; comparison is done in-place.
*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;                     // Pointer starting from the beginning
        int right = s.length() - 1;       // Pointer starting from the end

        while (left < right) {

            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move both pointers inward
            left++;
            right--;
        }

        return true; // All valid characters matched
    }
}

