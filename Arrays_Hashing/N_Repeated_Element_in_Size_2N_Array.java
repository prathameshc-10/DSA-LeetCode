/* 
 LeetCode: N-Repeated Element in Size 2N Array
 Difficulty: Easy
 Pattern: HashSet

 Approach:
 1. Traverse the array and store elements in a HashSet
 2. If an element is already present in the set, return it immediately
    (problem guarantees exactly one element repeats N times)

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            } else{
                set.add(nums[i]);
            }
        }
        return -1;
    }
}