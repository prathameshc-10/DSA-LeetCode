package Stack;

/*
Problem Name:
Daily Temperatures

Difficulty:
Medium

Approach:
- The goal is to find, for each day, how many days you must wait
  until a warmer temperature occurs.
- If there is no future day with a warmer temperature,
  the answer for that day is 0.

- A brute force approach would check every next day,
  leading to O(n²) time complexity.
- To optimize this to O(n), we use a Monotonic Stack.

- Step 1: Maintain a stack that stores indices of days,
          NOT temperatures.
          This allows us to calculate the number of days difference.

- Step 2: The stack maintains indices in decreasing order
          of temperatures.
          That means temperatures[stack[0]] >= temperatures[stack[1]] >= ...

- Step 3: Iterate through each day (i from 0 to n-1):

          While:
              - The stack is not empty
              - The current temperature is greater than
                the temperature at the index stored on top of stack

          This means:
              → We have found a warmer day for the previous day.

          So:
              - Pop the previous index from the stack.
              - Calculate the difference:
                    result[prevIndex] = i - prevIndex
              - Continue checking for other previous colder days.

- Step 4: Push the current index onto the stack.
          This day now waits for a warmer temperature in future.

- Step 5: After the loop finishes:
          Any indices still remaining in the stack
          do not have a warmer future day.
          Their result remains 0 (default value).

- The key idea:
  Instead of looking forward for each day,
  we resolve previous colder days when we encounter
  a warmer temperature.

Time Complexity:
O(n) — Each index is pushed once and popped once.

Space Complexity:
O(n) — Stack may store up to n indices in worst case
       (when temperatures are strictly decreasing).
*/
import java.util.Stack;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}