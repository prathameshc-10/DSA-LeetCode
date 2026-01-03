package Greedy;
/*
 LeetCode: Best Time to Buy and Sell Stock
 Difficulty: Easy
 Pattern: Greedy / Single Pass

 Approach:
 1. Track the minimum price (bestBuy) seen so far.
 2. For each day, calculate profit if we sell on that day.
 3. Update maximum profit when a higher profit is found.
 4. If a lower price appears, update bestBuy.
 5. Return the maximum profit at the end.

 Time Complexity: O(n)
 Space Complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        int bestBuy = prices[0];
        int maxSell = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] > bestBuy){
                maxSell = Math.max(maxSell, prices[i] - bestBuy);
            } else{
                bestBuy = prices[i];
            }
        }
        return maxSell;
    }
}