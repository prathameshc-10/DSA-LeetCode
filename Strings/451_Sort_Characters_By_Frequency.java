package Strings;

/*
Problem Name:
Sort Characters By Frequency

Difficulty:
Medium

Approach:
- This solution uses a HashMap to store the frequency of each character.
- First, traverse the string and count occurrences of every character.
- Store all unique characters in a list.
- Sort the list using a custom comparator based on frequency in descending order.
- Traverse the sorted list and append each character to the result as many times as its frequency.
- StringBuilder is used to efficiently build the final string.

Time Complexity:
O(n log n)
- Counting frequency takes O(n).
- Sorting unique characters takes O(k log k), where k is number of unique characters.
- In worst case k = n, so overall complexity becomes O(n log n).

Space Complexity:
O(n)
- HashMap stores up to n unique characters.
- List stores unique characters.
- StringBuilder stores the final result of length n.
*/
import java.util.*;
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder result = new StringBuilder();

        for (char ch : list) {
            int freq = map.get(ch);
            while (freq > 0) {
                result.append(ch);
                freq--;
            }
        }

        return result.toString();
    }
}
