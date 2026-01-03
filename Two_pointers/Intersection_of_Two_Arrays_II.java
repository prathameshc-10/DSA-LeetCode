package Two_pointers;

/*
 LeetCode: Intersection of Two Arrays II
 Difficulty: Easy
 Pattern: Two Pointers
 Approach:
 1. Sort both arrays
 2. Use two pointers to compare elements
 3. If equal → add to result and move both pointers
 4. Else move the pointer pointing to smaller value

 Time Complexity: O(n log n + m log m)
 Space Complexity: O(min(n, m)) for output list
*/

import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> temp = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                temp.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[temp.size()];
        for (int k = 0; k < temp.size(); k++) {
            result[k] = temp.get(k);
        }

        return result;
    }
}
