package Trees;

import java.util.*;

class Node {
    Node left;
    int data;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class CREATING_BT {
    Scanner sc = new Scanner(System.in);

    Node createTree(){
        System.out.println("Enter the data for the node: ");
        int data = sc.nextInt();
        Node node = new Node(data);
        System.out.println("Does the left child of " + data + " exist? (true/false)");
        boolean leftExist = sc.nextBoolean();
        if(leftExist){
            node.left = createTree();
        }
        System.out.println("Does the right child of " + data + " exist? (true/false)");
        boolean rightExist = sc.nextBoolean();
        if(rightExist){
            node.right = createTree();
        }
        return node;
    }

    static void preOrder(Node root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static List<List<Integer>> levelOrder(Node root){
       List<List<Integer>> result = new ArrayList<>();
       
       if(root == null) 
            return result;

       Queue<Node> que = new LinkedList<>();
       que.add(root);

       while(!que.isEmpty()){
            int size = que.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i< size; i++){
                Node node = que.remove();
                level.add(node.data);
                if(node.left != null)
                    que.add(node.left); 
                if(node.right != null)
                    que.add(node.right);
            }
            result.add(level);
       }
       return result;
    }

    public static void main(String[] args) {
        CREATING_BT tree = new CREATING_BT();
        Node root = tree.createTree();
        System.out.println("Pre-order traversal:");
        preOrder(root);
        System.out.println("\nLevel-order traversal:");
        System.out.println(levelOrder(root));
    }
}
