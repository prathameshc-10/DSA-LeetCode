package Trees;
/*
Problem Name:
Same Tree

Difficulty Level:
Easy

Approach:
- Use recursion to compare both trees node by node.
- If both nodes are null, they are identical at that position.
- If one node is null and the other is not, trees are different.
- Compare values of current nodes:
    - If values differ, return false.
- Recursively compare:
    - Left subtree of both trees.
    - Right subtree of both trees.
- Trees are same only if all corresponding nodes match.

Time Complexity:
O(n)
- Each node in both trees is visited exactly once.

Space Complexity:
O(n)
- O(n) recursion stack space in the worst case (skewed tree).
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;
        
        if(p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}