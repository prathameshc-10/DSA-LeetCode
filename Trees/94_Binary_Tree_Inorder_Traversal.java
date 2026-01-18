package Trees;

/*
Problem Name:
Binary Tree Inorder Traversal

Difficulty Level:
Easy

Approach:
- Use recursion to perform inorder traversal.
- In inorder traversal, nodes are visited in the order:
  Left → Root → Right.
- Maintain a list to store traversal results.
- Use a helper method to recursively traverse the tree.

Time Complexity:
O(n)
- Each node in the tree is visited exactly once.

Space Complexity:
O(n)
- O(n) for recursion stack in the worst case (skewed tree).
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
