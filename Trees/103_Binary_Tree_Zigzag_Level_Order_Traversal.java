package Trees;

/*
Problem Name:
Binary Tree Zigzag Level Order Traversal

Difficulty Level:
Medium

Approach:
- Use Breadth First Search (BFS) with a Queue
  to traverse the tree level by level.
- Maintain a boolean flag `leftToRight`:
    - true  → insert nodes from left to right.
    - false → insert nodes from right to left.
- For every level:
    - Process all nodes currently in the queue.
    - Store node values in a list.
    - If traversing left to right, add at end.
    - Otherwise, add at beginning to create zigzag order.
- Add left and right children of each node into the queue.
- After processing a level:
    - Add the row to result.
    - Toggle traversal direction.

Time Complexity:
O(n)
- Each node is visited exactly once.

Space Complexity:
O(n)
- Queue stores nodes level by level.
- Result list also stores all node values.
*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean leftToRight = true;

        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> row = new LinkedList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = que.poll();

                if(leftToRight)
                    row.addLast(node.val);
                else
                    row.addFirst(node.val);

                if(node.left != null)
                    que.add(node.left);
                
                if(node.right != null)
                    que.add(node.right);
            }
            result.add(row);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
