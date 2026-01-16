/*
Problem Name: Beautiful Array (LeetCode 932)

Difficulty Level: Medium

Approach:
This solution uses a constructive divide-and-conquer approach.
A beautiful array is defined such that for any i < k < j,
2 * A[k] != A[i] + A[j].

Steps:
1. Start with a base beautiful array [1].
2. Iteratively build a new array by applying:
   - Odd transformation: 2*x - 1
   - Even transformation: 2*x
3. Only include values that are <= n.
4. Odd and even transformations preserve the beautiful property.
5. Repeat until the array size reaches n.

This guarantees all numbers from 1 to n appear exactly once
and no arithmetic progression is formed.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        while(ans.size() < n){
            List<Integer> temp = new ArrayList<>();
            //for odd
            for(int ele : ans){
                if(2*ele - 1 <= n){
                    temp.add(2*ele-1);
                }
            }
            //for even
            for(int ele : ans){
                if(2*ele <= n){
                    temp.add(2*ele);
                }
            }
            ans = temp;
        }
        int[] result = new int[ans.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = ans.get(i);
        }
        return result;        
    }
}