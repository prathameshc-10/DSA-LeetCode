package Trees;

/*
Problem Name:
Binary Tree Maximum Path Sum

Difficulty Level:
Hard

Approach:
- Use recursion to calculate the maximum path sum for each subtree.
- At every node:
    - Compute maximum contribution from left subtree.
    - Compute maximum contribution from right subtree.
- Ignore negative path sums using Math.max(0, pathSum)
  because negative paths decrease the total sum.
- The maximum path passing through the current node is:
    left contribution + right contribution + current node value.
- Maintain a global variable `sum` to store the maximum
  path sum found so far.
- Return the maximum single path contribution to the parent:
    current node value + max(left contribution, right contribution).

Time Complexity:
O(n)
- Each node in the tree is visited exactly once.

Space Complexity:
O(n)
- O(n) recursion stack space in the worst case (skewed tree).
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return sum;
    }

    int maxPath(TreeNode root){
        if(root == null)
            return 0;

        int leftSum = Math.max(0, maxPath(root.left));
        int rightSum = Math.max(0, maxPath(root.right));

        sum = Math.max(sum, leftSum + rightSum + root.val);

        return root.val + Math.max(leftSum, rightSum);
    }
}