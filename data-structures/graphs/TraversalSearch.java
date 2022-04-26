package DataStructures.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TraversalSearch {

    class Node {
        boolean visited;
        boolean marked;
        Set<Node> adj;
    }

    public static void main(String[] args) {

    }
    void breadthFirstSearch(Node root){
        Queue<Node> queue = new LinkedList<>();
        root.marked = true;
        queue.add(root);

        while (!queue.isEmpty()){
            Node r = queue.poll();
            for (Node node : r.adj) {
                if(node.marked == false){
                    node.marked = true;
                    queue.add(node);
                }
            }
        }

    }
    void depthFirstSearch(Node root){
        if(root == null) return;
        root.visited = true;
        for (Node node: root.adj) {
            if(!node.visited) {
                depthFirstSearch(node);
            }
        }
    }

}


