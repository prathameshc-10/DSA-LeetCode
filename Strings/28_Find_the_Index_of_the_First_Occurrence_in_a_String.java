package Strings;

/*
Problem Name:
LeetCode 28 – Implement strStr()

Difficulty:
Easy

Approach:
This solution uses a sliding window technique.
We iterate over the haystack string and for each possible starting index,
we extract a substring of length equal to the needle.
If the extracted substring matches the needle, we return the starting index.
If no match is found after checking all possible positions, we return -1.

Time Complexity:
O(n * m)
where n is the length of haystack and m is the length of needle.
This is because substring creation and string comparison both take O(m) time
and are executed for each valid starting position in the haystack.

Space Complexity:
O(m)
Extra space is used for creating substrings of length m during each comparison.
*/

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0, j = needle.length(); j <= haystack.length(); i++, j++) {
            if (haystack.substring(i, j).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
