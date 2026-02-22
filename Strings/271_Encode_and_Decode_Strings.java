package Strings;

/*
Problem Name:
Encode and Decode Strings

Difficulty Level:
Medium

Approach:
1. Encoding Process:
   - Use a StringBuilder to build the encoded string.
   - For each string in the list:
       a) Append the length of the string.
       b) Append a delimiter character '#'.
       c) Append the actual string.
   - This forms a pattern like:
       length + '#' + string
   - Example:
       ["Hello","World"]
       becomes
       "5#Hello5#World"

2. Why Length Prefix Instead of Delimiter Split?
   - Strings can contain any ASCII character (including '#').
   - So splitting directly by a delimiter is unsafe.
   - By storing the length first, we know exactly how many characters to read.

3. Decoding Process:
   - Traverse the encoded string using a pointer 'i'.
   - For each encoded block:
       a) Move another pointer 'j' until '#' is found.
       b) Extract the substring from index i to j.
          → This gives the length of the next string.
       c) Convert that substring into an integer.
       d) Move pointer past '#'.
       e) Extract the next 'length' characters.
       f) Add the extracted string to the result list.
       g) Move 'i' to the end of the extracted string.
   - Repeat until entire encoded string is processed.

4. This method works for:
   - Empty strings
   - Special characters
   - Any ASCII character set

Time & Space Complexity:
Time Complexity: O(N)
- N = total number of characters across all strings.
- Each character is processed once during encoding and decoding.

Space Complexity: O(N)
- Space used to store the encoded string and the decoded result list.
*/

import java.util.*;
class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(str.length())
              .append('#')
              .append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = i;

            while(str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            j++;

            String s = str.substring(j, j+length);
            result.add(s);

            i = j+length;
        }

        return result;
    }
}
