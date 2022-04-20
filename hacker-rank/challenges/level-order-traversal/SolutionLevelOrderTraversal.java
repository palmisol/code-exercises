package Algorithms.LevelOrderTraversal;

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class SolutionLevelOrderTraversal {

    /*
    
    class Algorithms.LevelOrderTraversal.Node
        int data;
        Algorithms.LevelOrderTraversal.Node left;
        Algorithms.LevelOrderTraversal.Node right;
    */
    public static void levelOrder(Node root) {
        if (root == null) return;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root); // add element to the end

        while (!queue.isEmpty()) {
            Node current_node = queue.poll(); //removes and retrieve the element in the front

            System.out.print(current_node.data + " ");

            if (current_node.left != null) queue.add(current_node.left);
            if (current_node.right != null) queue.add(current_node.right);

        }

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}