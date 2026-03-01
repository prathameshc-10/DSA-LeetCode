package Stack;

/*
Problem Name:
Valid Parentheses

Difficulty:
Easy

Approach:
- The goal is to determine whether the input string of brackets is valid.
- A string is valid if:
      → Every opening bracket has a corresponding closing bracket.
      → Brackets are closed in the correct order.
- We use a Stack data structure because it follows LIFO (Last In First Out),
  which naturally matches the bracket closing order requirement.

- Step 1: Initialize an empty stack to store opening brackets.

- Step 2: Traverse each character in the string:
          - If the character is an opening bracket
                ('(', '{', '[')
                → Push it onto the stack.
          - If the character is a closing bracket
                (')', '}', ']'):
                → First check if the stack is empty.
                      If empty → return false (no matching opening bracket).
                → Pop the top element from the stack.
                → Check if the popped opening bracket matches
                  the current closing bracket.
                      If it does not match → return false.

- Step 3: After processing all characters:
          - If the stack is empty → return true (all brackets matched).
          - If the stack is not empty → return false
            (some opening brackets were not closed).

- The stack ensures that brackets are validated in correct nested order.

Time Complexity:
O(n) — Each character is pushed and popped at most once.

Space Complexity:
O(n) — In the worst case, all characters are opening brackets
       and stored in the stack.
*/
import java.util.Stack; 
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else{
                if(stack.isEmpty())
                    return false;
                
                char top = stack.pop();
                if(ch == ')' && top != '('){
                    return false;
                } else if(ch == ']' && top != '['){
                    return false;
                } else if(ch == '}' && top != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}