/*
Problem Name:
Intersection of Two Arrays

Difficulty Level:
Easy

Approach:
1. Use a HashSet to store all elements of the first array (nums1).
2. Iterate through the second array (nums2) and check if each element
   exists in the first set.
3. Store common elements in another HashSet to avoid duplicates.
4. Convert the result set into an integer array and return it.

Time & Space Complexity:
Time Complexity: O(n + m)
- n = length of nums1
- m = length of nums2

Space Complexity: O(n)
- Extra space used by HashSet to store elements of nums1 and the result.
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }

        for(int j = 0; j < nums2.length; j++){
            if(set.contains(nums2[j])){
                result.add(nums2[j]);
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for(int num : result){
            arr[i++] = num;
        }
        return arr;
    }
}