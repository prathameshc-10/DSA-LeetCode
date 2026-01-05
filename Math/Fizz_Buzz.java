package Math;

/*
 LeetCode: Fizz Buzz
 Difficulty: Easy
 Pattern: Math

 Approach:
 1. Iterate from 1 to n.
 2. If the number is divisible by both 3 and 5, add "FizzBuzz".
 3. If divisible by only 3, add "Fizz".
 4. If divisible by only 5, add "Buzz".
 5. Otherwise, add the number itself as a string.

 Time Complexity: O(n)
 Space Complexity: O(n)  
*/

import java.util.*;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz");
            } else if(i % 3 == 0){
                result.add("Fizz");
            } else if(i % 5 == 0){
                result.add("Buzz");
            } else{
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}