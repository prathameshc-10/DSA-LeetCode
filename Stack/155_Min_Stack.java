package Stack;

/*
Problem Name:
Min Stack

Difficulty:
Medium

Approach:
- The goal is to design a stack that supports push, pop, top,
  and retrieving the minimum element in constant time O(1).
- A normal stack cannot return the minimum in O(1) time,
  so we use an additional stack to track minimum values.

- Step 1: Maintain two stacks:
          1) stack → stores all elements normally.
          2) minStack → stores the minimum value at each level.

- Step 2: Push Operation:
          - Push the value into the main stack.
          - If minStack is empty OR the new value is smaller
            than the current minimum:
                → Push the new value into minStack.
          - Otherwise:
                → Push the current minimum again into minStack.
          This ensures minStack always keeps track of the
          minimum value up to that point.

- Step 3: Pop Operation:
          - Pop from both stack and minStack.
          - Since minStack mirrors stack size,
            the minimum updates automatically.

- Step 4: Top Operation:
          - Return the top element of the main stack.

- Step 5: getMin Operation:
          - Return the top element of minStack.
          - This represents the minimum element in the stack
            at the current state.

- The idea works because minStack maintains the minimum
  value corresponding to every element in the main stack.
  So retrieving the minimum becomes an O(1) operation.

Time Complexity:
O(1) — All operations (push, pop, top, getMin) run in constant time.

Space Complexity:
O(n) — An extra stack is used to store minimum values
       corresponding to each element.
*/

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.add(val);
        
        if(minStack.isEmpty() || val < minStack.peek()){
            minStack.push(val);
        } else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
