package Arrays;

/*
Problem Name:
Monotonic Array

Difficulty:
Easy

Approach:
- Traverse the array once and compare adjacent elements.
- Use two boolean flags:
  1. increasing → becomes true if any arr[i] < arr[i+1]
  2. decreasing → becomes true if any arr[i] > arr[i+1]
- If both flags become true, the array is not monotonic.
- If only one (or none) is true, the array is monotonic.
- Arrays with all equal elements are also considered monotonic.

Time Complexity:
O(n), where n is the length of the array (single traversal).

Space Complexity:
O(1), constant extra space.
*/

class Solution {
    public boolean isMonotonic(int[] arr) {
        boolean increasing = false;
        boolean decreasing = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                increasing = true;
            } else if (arr[i] > arr[i + 1]) {
                decreasing = true;
            }
        }

        if (increasing && decreasing)
            return false;
        else if (!increasing && !decreasing)
            return true;
        else if (increasing)
            return increasing;
        else
            return decreasing;
    }
}

