package DataStructures.BinaryTree;

public class Solution {
    static class Node {
        boolean leftTree = false;
        int index;
        int depth;
        Node left, right;

        Node(int index, int depth){
            this.index = index;
            left = right = null;
        }
        public void swapNodes(int K){
            if(left == null && right == null) return;

            if((depth + 1) % K == 0){
               Node temp = left;
               left = right;
               right = temp;
            }

            left.swapNodes(K);
            right.swapNodes(K);
        }
        public void inOrder(Node node){
            if(node == null) return;
            inOrder(left);
            System.out.print(index + " ");
            inOrder(right);
        }
        public void addNode(int l, int r){

            if(left == null ) {
                left = l != -1 ? new Node(l, depth + 1) : null;
                if (right == null) {
                    right = r != -1 ? new Node(r, depth + 1) : null;
                }
            } else {


            }





            if(left == null){
                left = l != -1 ? new Node(l, depth + 1) : null;
                if(right == null){
                    right = r != - 1 ? new Node(r, depth + 1) : null;
                }
            } else {
                left.addNode(l, r);
            }
            

        }
    }
    public static void main(String[] args) {
        
        Node node = new Node(1, 1);

        node.addNode(2, 3);
        node.addNode(-1, 4);
        node.addNode(-1, 5);
        node.addNode(6, -1);
        node.addNode(7, 8);

        node.addNode(9, -1);
        node.addNode(-1, -1);
        node.addNode(11, 10);
        node.addNode(-1, -1);
        node.addNode(-1, -1);
        node.addNode(-1, -1);
    }

}
