package Algorithms.SwapNodes;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */
    static class Node {

        HashMap<Integer, HashMap> hashMap = new HashMap<>();

        Node childLeft;
        Node childRight;
        int data;

        Node(int data) {
            this.data = data;
            childLeft = null;
            childRight = null;
        }
    }
    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        // Write your code here
        //public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries)

        Node root = new Node(1);


        for (int i = 0; i < 7; i++) {

            root = insert(root, i, true);
            root = insert(root,  i + 1, false);

        }
        return null;
    }
    public static Node insert(Node parent, int data, boolean left ){



        return parent;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        List<List<Integer>> indexes = new LinkedList<>();
        List<Integer> queries = new LinkedList<>();

        Result.swapNodes(indexes, queries);
    }
}
