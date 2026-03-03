package Stack;

/*
Problem Name:
Largest Rectangle in Histogram

Difficulty:
Hard

Approach:
- The goal is to find the largest rectangular area that can be formed
  within a histogram represented by an array of bar heights.

- Each bar has:
      → Height = heights[i]
      → Width = 1 unit

- The rectangle can extend left and right as long as the bars are
  greater than or equal to the current height.

- We use a Monotonic Increasing Stack (stores indices, not heights)
  to efficiently calculate the maximum area.

------------------------------------------------------------

- Step 1: Initialize:
          → An empty stack to store indices of histogram bars.
          → A variable maxArea = 0 to track the maximum rectangle area.

- Step 2: Traverse through the histogram from i = 0 to heights.length.
          (We go one step extra to handle remaining stack elements.)

          For each index i:

          → If i == heights.length:
                Set currentHeight = 0
                (This forces stack to empty at the end.)

          → Otherwise:
                currentHeight = heights[i]

------------------------------------------------------------

- Step 3: While:
          The stack is NOT empty AND
          currentHeight < height of bar at top index of stack

          This means:
          We found the right boundary for the bar at stack top.

          Inside while loop:

          → Pop the top index from the stack.
          → Get its height using heights[index].
          → Calculate width:

                If stack becomes empty:
                    width = i
                    (Rectangle extends from index 0 to i-1)

                Else:
                    width = i - st.peek() - 1
                    (Rectangle extends between
                     previous smaller element and current index)

          → Calculate area = height × width
          → Update maxArea if needed.

------------------------------------------------------------

- Step 4: After processing smaller heights,
          push current index i into the stack.

          This maintains increasing order of heights.

------------------------------------------------------------

- Step 5: After loop ends,
          return maxArea.

------------------------------------------------------------

Why We Store Indices Instead of Heights:
- We need indices to calculate width.
- Width depends on distance between boundaries,
  not just height values.

------------------------------------------------------------

Time Complexity:
O(n) — Each index is pushed and popped at most once.

Space Complexity:
O(n) — In worst case (strictly increasing heights),
       all indices are stored in stack.
*/
import java.util.Stack;
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= heights.length; i++){
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while(!st.isEmpty() && currentHeight < heights[st.peek()]){
                int height = heights[st.pop()];
                int width;
                if(st.isEmpty()){
                    width = i;
                } else{
                    width = i - st.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i); 
        }
        return maxArea;
    }
}
