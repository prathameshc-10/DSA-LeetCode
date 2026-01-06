package Trees;

/*
 LeetCode: 1161. Maximum Level Sum of a Binary Tree
 Difficulty: Medium
 Pattern: Breadth-First Search (Level Order Traversal)

 Approach:
 1. Use a queue to perform level-order traversal.
 2. For each level:
    - Calculate the sum of all node values at that level.
 3. Track the maximum sum encountered so far.
 4. If the current level sum is greater than maxSum,
    update maxSum and store the current level number.
 5. Return the level that has the maximum sum.

 Time Complexity: O(n)
 Space Complexity: O(n)
*/

class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;
        int currentLevel = 1;
        int resultLevel = 0;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int sum = 0;
            int size = que.size();
            while(size-- > 0){
                TreeNode temp = que.remove();
                sum += temp.val;
                if(temp.left != null){
                    que.add(temp.left);
                }
                if(temp.right != null){
                    que.add(temp.right);
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                resultLevel = currentLevel;
            }
            currentLevel++;
        }

        return resultLevel;
    }
}
