package DataStructures.BinaryTree;

import java.util.*;

public class Main {

    static class Node {

        int depth;
        int index;
        boolean leftLeaf = false;
        Node right, left;

        Node(int index, int depth){
            this.depth = depth;
            this.index = index;
            left = right = null;
        }
        public void add(int valueLeft, int valueRight){
          if(left != null && right != null){
              if(!leftLeaf){
                  left.add(valueLeft, valueRight);
                  leftLeaf = true;
              } else {
                  right.add(valueLeft, valueRight);
                  leftLeaf = false;
              }
          } else {
              left = new Node(valueLeft, depth + 1);
              right = new Node(valueRight, depth + 1);
          }
        }
        public void addEdit(int l, int r){


            if(left != null){
                left.addEdit(l, r);
            } else {
                if(l != -1){
                    left = new Node(l, depth + 1);
                }
            }


            if(right != null){
                right.addEdit(l, r);
            } else {
                if(r != -1){
                    right = new Node(r, depth + 1);
                }
            }

        }
        public void swapNodes(){

        }
        public boolean contains(int value){
            if(value == index) {
                return true;
            } else if (value < index){
                if(left == null){
                    return false;
                } else {
                    return left.contains(value);
                }
            } else {
                if(right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            }
        }
        public void printInTraversal(){

            Stack<Integer> leftStack = new Stack<>();
            Stack<Integer> rightStack = new Stack<>();

            if(!leftLeaf){
                if(left.index != -1){
                    left.printInTraversal();

                } else {

                    System.out.println();
                }

            } else {
                if(right.index != -1){
                    right.printInTraversal();
                }
            }


        }
        public void printInOrder() {

        }
    }
    public static void main(String[] args) {

        Node node = new Node(1, 1);

        node.addEdit(2, 3); //depth 2
        node.addEdit(-1, 4); // depth 3
        node.addEdit(-1, 5); // depth 3
        node.addEdit(6, -1); // depth 3
        node.addEdit(7, 8); // depth 3

        node.addEdit(9, -1);
        node.addEdit(-1, -1);
        node.addEdit(11, 10);
        node.addEdit(-1, -1);
        node.addEdit(-1, -1);
        node.addEdit(-1, -1);




    }
}
