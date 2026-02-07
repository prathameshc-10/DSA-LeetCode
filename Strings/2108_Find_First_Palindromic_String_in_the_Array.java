package Strings;

/*
Problem Name: First Palindromic String in the Array
Difficulty Level: Easy

Approach:
- Iterate through each word in the array.
- For every word, check whether it is a palindrome using a two-pointer technique.
- Start one pointer from the beginning and another from the end of the string.
- If all corresponding characters match, the word is a palindrome.
- Return the first word that satisfies the palindrome condition.
- If no palindrome is found, return an empty string.

Time & Space Complexity:
- Time Complexity: O(n * m), where n is the number of words and m is the average length of a word.
- Space Complexity: O(1), as only constant extra space is used.
*/

class Solution {
    public String firstPalindrome(String[] words) {
        boolean isPallindrome = false;
        for(int i = 0; i < words.length; i++){
            isPallindrome = checkPallindrome(words[i]);
            if(isPallindrome){
                return words[i];
            }
        }
        return "";
    }

    private boolean checkPallindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
