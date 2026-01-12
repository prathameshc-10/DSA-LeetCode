/*
 LeetCode: Find Lucky Integer in an Array
 Difficulty: Easy
 Pattern: HashMap / Frequency Counting

 Approach:
 1. Use a HashMap to count the frequency of each integer in the array.
 2. Traverse the array and update the count of each number using getOrDefault.
 3. Initialize luckyNum as -1 to handle the case when no lucky integer exists.
 4. Iterate over the HashMap entries.
 5. For each entry, check if the number (key) is equal to its frequency (value).
 6. If it is a lucky number, update luckyNum with the maximum value found so far.
 7. Return luckyNum as the final answer.

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int luckyNum = -1;
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey().equals(entry.getValue())){
                luckyNum = Math.max(luckyNum, entry.getValue());
            }
        }
              
        return luckyNum;
    }
}
