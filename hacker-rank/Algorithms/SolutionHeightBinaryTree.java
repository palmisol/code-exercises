package Algorithms;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SolutionHeightBinaryTree {

    class Node {
        int data;
        Node left;
        Node right;
    }

    public static int getHeight(Node root){
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 0;
        else if (root.left != null & root.right == null) {
            return 1 + getHeight(root.left);
        } else if (root.left == null && root.right != null){
            return 1 + getHeight(root.right);
        } else {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }

    }

    public static void main(String[] args) {

        input();
    }

    private static void input(){

        Scanner scanner = new Scanner(System.in);

        try {
            int size = scanner.nextInt();
            int[] nodes = new int[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please use only numbers 0 - 9");
        }


    }
}
