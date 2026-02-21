/*
Problem Name:
Longest Consecutive Sequence

Difficulty Level:
Medium

Approach:
1. Insert all elements from the array into a HashSet.
   - This removes duplicates automatically.
   - Allows O(1) average lookup time.
2. Iterate through each number in the set.
3. Only start counting when the number is the beginning of a sequence.
   - A number is considered the start if (num - 1) is NOT present in the set.
4. From the starting number, keep checking if (currentNum + 1) exists in the set.
   - Increment the count while consecutive numbers are found.
5. Update the maximum length found during the process.
6. Return the maximum length.

Time & Space Complexity:
Time Complexity: O(n)
- n = number of elements in nums
- Each element is inserted once and processed at most once.

Space Complexity: O(n)
- Extra space used by HashSet to store all elements.
*/

import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longest = 0;

        for(int num : set){

            if(!set.contains(num - 1)){
                int currentNum = num;
                int count = 1;

                while(set.contains(currentNum + 1)){
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}