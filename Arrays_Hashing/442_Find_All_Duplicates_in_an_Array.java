/*
 Problem Name:
 Find All Duplicates in an Array

 Difficulty Level:
 Medium

 Approach:
 - Use the input array itself to mark visited numbers (in-place hashing).
 - For each element:
     - Take the absolute value to handle already-negated numbers.
     - Convert the value to an index using (num - 1).
     - If the value at that index is already negative, the number is a duplicate.
     - Otherwise, negate the value at that index to mark it as visited.
 - Collect all duplicate numbers in a list and return it.

 Time Complexity:
 O(n), where n is the length of the array.

 Space Complexity:
 O(1) extra space (excluding the output list), since no additional data structures are used.
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {  
        List<Integer> list = new ArrayList<>(); 
        for(int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]);
            int index = num - 1;
            if(nums[index] < 0){
                list.add(num);
            }
            nums[index] *= -1;
        }
        return list;
    }
}
