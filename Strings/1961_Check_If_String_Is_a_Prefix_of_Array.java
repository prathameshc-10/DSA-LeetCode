package Strings;

/*
Problem Name:
Check If String Is a Prefix of Array

Difficulty Level:
Easy

Approach:
- Initialize an empty string `result`.
- Iterate through the `words` array.
- Concatenate each word to `result` step by step.
- After each concatenation, compare `result` with the target string `s`.
- If at any point `result` equals `s`, return true.
- If the loop completes without a match, return false.

Time Complexity:
O(n * k)
- n = number of words
- k = average length of words
- Each string concatenation creates a new string, making it costly.

Space Complexity:
O(n * k)
- Extra space is used for the concatenated string `result`.

*/
class Solution {
    public boolean isPrefixString(String s, String[] words) {
        String result = "";
        for(int i = 0; i < words.length; i++){
            result += words[i];
            if(s.equals(result)){
                return true;
            }
        }
        return false;
    }
}

