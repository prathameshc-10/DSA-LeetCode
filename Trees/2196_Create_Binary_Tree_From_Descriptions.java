package Trees;

import java.util.HashMap;
import java.util.HashSet;

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

class Solution{
    public TreeNode createBinaryTree(int[][] descriptions){
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int[] desc: descriptions){
            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];

            map.putIfAbsent(parentVal, new TreeNode(parentVal));
            map.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = map.get(parentVal);
            TreeNode child = map.get(childVal);

            if(isLeft == 1){
                parent.left = child;
            } else {
                parent.right = child;
            }

            set.add(childVal);
        }

        for(int val : map.keySet()){
            if(!set.contains(val)){
                return map.get(val);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] descriptions = {{1,2,1},{1,3,0},{2,4,1}};
        TreeNode root = sol.createBinaryTree(descriptions);
        System.out.println(root.val); // Output: 1
    }
}