package Greedy;

/*
 LeetCode: Car Fleet
 Difficulty: Medium
 Pattern: Greedy + Sorting

 Approach:
 1. Pair each car's position and speed into a 2D array so we can sort them together.
 2. Sort the cars in descending order based on position (closest to target first).
 3. For each car, calculate the time required to reach the target:
        time = (target - position) / speed
 4. Traverse from closest to farthest car:
        - If current car’s time is greater than previous fleet time,
          it cannot catch up → forms a new fleet.
        - Otherwise, it catches up and joins the existing fleet.
 5. Count how many new fleets are formed.

 Key Insight:
 Cars are processed from nearest to farthest because a car behind
 can only merge into the fleet ahead — it cannot pass it.

 Time Complexity: O(n log n)  // due to sorting
 Space Complexity: O(n)       // for storing position-speed pairs
*/
import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> b[0] - a[0]);

        int fleets = 0;
        double prevTime = 0.0;
        for (int i = 0; i < n; i++) {
            double time = (double)(target - cars[i][0]) / cars[i][1];
            if (time > prevTime) {
                fleets++;
                prevTime = time;
            }
        }

        return fleets;
    }
}