package Trees;

/*
Problem Name:
Diameter of Binary Tree

Difficulty Level:
Easy

Approach:
- Use recursion to calculate the height of each subtree.
- For every node, the diameter passing through that node is:
    left subtree height + right subtree height.
- Maintain a global variable `diameter` to store the maximum
  diameter found during traversal.
- The helper function returns the height of the current subtree.
- Height of a node = 1 + maximum height of its left and right subtrees.

Time Complexity:
O(n)
- Each node in the tree is visited exactly once.

Space Complexity:
O(n)
- O(n) recursion stack space in the worst case (skewed tree).
*/

class Solution {
    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        countHeight(root);
        return diameter;
    }

    int countHeight(TreeNode root){
        if(root == null)
            return 0;
        int lh = countHeight(root.left);
        int rh = countHeight(root.right);
        diameter = Math.max(diameter, lh + rh); 
        return 1 + Math.max(lh,rh);
    }
}


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