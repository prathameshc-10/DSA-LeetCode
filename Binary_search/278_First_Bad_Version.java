package Binary_search;

/*
Problem Name:
278. First Bad Version

Difficulty Level:
Easy

Approach:
This problem is solved using Binary Search to find the first bad version.
The search space is from version 1 to version n.

At each step:
- Compute the mid version safely to avoid integer overflow
- If mid is a bad version, move the search to the left half (end = mid - 1)
- If mid is a good version, move the search to the right half (start = mid + 1)

This is a lower-bound binary search pattern.
When the loop ends, the start pointer points to the first bad version.

Time & Space Complexity:
Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}