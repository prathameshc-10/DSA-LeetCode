package Trees;
import java.util.*;

/*
Problem Name:
Vertical Order Traversal of a Binary Tree

Difficulty Level:
Hard

Approach:
- Use Breadth First Search (BFS) with a Queue
  to traverse nodes along with their coordinates.
- Assign coordinates:
    - Root → (0, 0)
    - Left Child  → (x - 1, y + 1)
    - Right Child → (x + 1, y + 1)
- Use nested TreeMaps to maintain sorted order:
    - Outer TreeMap stores vertical columns (x-coordinate).
    - Inner TreeMap stores levels (y-coordinate).
- Use PriorityQueue to store node values:
    - Handles multiple nodes at same position.
    - Keeps values sorted in ascending order.
- Traverse the map column by column
  and collect values into the final result.

Data Structure Used:
TreeMap<x, TreeMap<y, PriorityQueue<nodeValues>>>

Time Complexity:
O(n log n)
- Each insertion into TreeMap/PriorityQueue takes log n time.

Space Complexity:
O(n)
- Queue, maps, and result store all tree nodes.
*/


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Tuple{
    TreeNode node;
    int x;
    int y;
    Tuple(TreeNode node, int row, int cloumn){
        this.node = node;
        this.x = row;
        this.y = cloumn;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> que = new LinkedList<>();

        que.offer(new Tuple(root, 0, 0));
        while(!que.isEmpty()){
            Tuple tuple = que.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                que.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right != null){
                que.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> yMap : map.values()){
            List<Integer> vertical = new ArrayList<>();
            for(PriorityQueue<Integer> val : yMap.values()){
                while(!val.isEmpty()){
                    vertical.add(val.poll());
                }
            }
            result.add(vertical);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = sol.verticalTraversal(root);
        System.out.println(result);
    }
}