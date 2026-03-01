package Stack;

/*
Problem Name:
Evaluate Reverse Polish Notation

Difficulty:
Medium

Approach:
- The goal is to evaluate an arithmetic expression given
  in Reverse Polish Notation (Postfix Notation).

- In Reverse Polish Notation:
      - Operands (numbers) come first.
      - Operator comes after its two operands.
      - No parentheses are needed.
  Example:
      ["2","1","+","3","*"]
      → ((2 + 1) * 3)

- A stack is the ideal data structure for this problem.

- Step 1: Create a stack of integers.
          This will store operands and intermediate results.

- Step 2: Iterate through each token in the input array.

          Case 1: If the token is an operator (+, -, *, /):
              - Pop the top element → this is the second operand (num1).
              - Pop the next element → this is the first operand (num2).
              - Perform the operation:
                    num2 operator num1
                (Order matters for '-' and '/')
              - Push the result back onto the stack.

          Case 2: If the token is a number:
              - Convert it from String to Integer.
              - Push it onto the stack.

- Step 3: After processing all tokens,
          the stack will contain exactly one element,
          which is the final result.
          Return stack.pop().

- Important Detail:
  Division between two integers truncates toward zero.
  Java integer division automatically handles this behavior.

- Why stack works:
  Reverse Polish Notation naturally fits the stack pattern,
  because each operator consumes the last two operands
  and produces a new result.

Time Complexity:
O(n) — Each token is processed exactly once.

Space Complexity:
O(n) — Stack may store up to n elements in worst case.
*/
import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String ch = tokens[i];
            if(ch.equals("+") || ch.equals("-") || ch.equals("/") || ch.equals("*")){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                if(ch.equals("+")){
                    stack.push(num1 + num2);
                } else if(ch.equals("-")){
                    stack.push(num2 - num1);
                } else if(ch.equals("*")){
                    stack.push(num2 * num1);
                } else if(ch.equals("/")){
                    stack.push(num2 / num1);
                }
            } else{
                int num = Integer.parseInt(ch);
                stack.push(num);
            }
        }
        return stack.pop();
    }
}
