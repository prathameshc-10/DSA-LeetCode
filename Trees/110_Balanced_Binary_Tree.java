package Trees;

/*
Problem Name:
Balanced Binary Tree

Difficulty Level:
Easy

Approach:
- Use recursion to calculate the height of each subtree.
- A tree is balanced if the difference between the heights
  of left and right subtrees is not more than 1 for every node.
- The helper function returns:
    - Height of the subtree if balanced.
    - -1 if the subtree is unbalanced.
- If any subtree is unbalanced, immediately propagate -1 upward
  to avoid unnecessary calculations.

Time Complexity:
O(n)
- Each node is visited exactly once.

Space Complexity:
O(n)
- O(n) recursion stack space in the worst case (skewed tree).
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        return countHeight(root) != -1;    
    }

    static int countHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = countHeight(root.left);
        int rh = countHeight(root.right);

        if(lh == -1 || rh == -1) return -1;
        if(Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }
}
