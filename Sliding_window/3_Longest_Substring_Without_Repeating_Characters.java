package Sliding_window;

/*
Problem Name:
Longest Substring Without Repeating Characters

Difficulty Level:
Medium

Approach:
- Use the Sliding Window technique with two pointers (left and right).
- Maintain a HashSet to store unique characters in the current window.
- Expand the window by moving the right pointer.
- If a duplicate character is found, shrink the window from the left
  until the duplicate is removed.
- Track the maximum window size during the process.

Time Complexity:
O(n)
- Each character is added to and removed from the set at most once.

Space Complexity:
O(min(n, k))
- k is the character set size (e.g., 128 for ASCII).
- In the worst case, the set stores all unique characters.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;                  // Left pointer of the sliding window
        int maxCount = 0;              // Stores the maximum length found
        Set<Character> set = new HashSet<>(); // Stores unique characters in the window

        for (int right = 0; right < s.length(); right++) {
            // If duplicate character is found, shrink window from the left
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to the set
            set.add(s.charAt(right));

            // Update maximum length
            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }
}
