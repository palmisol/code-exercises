package Algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SolutionBreathFirstSearch {
    public static class Graph{
        private  Node[] nodes;
        private final int EDGE_DISTANCE = 6;

        public Graph(int size){
            nodes = new Node[size + 1];
            for (int i = 1; i < size; i++) {
                nodes[i] = new Node(i);
            }

        }
        private class Node{
            private int id;
            public LinkedList<Integer> neighbours;

            private Node (int id){
                this.id = id;
                neighbours = new LinkedList<>();
            }
        }
        private Node getNode(int id) {
            return nodes[id];
        }
        public void addEdge(int source, int destination){
            Node s = getNode(source);
            //Node d = getNode(destination);
            s.neighbours.add(destination);
            //s.adjecent(d);
        }
        public int[] shortestPath(int startId){
            LinkedList<Integer> queue = new LinkedList<>();

            LinkedList<Integer> result = new LinkedList<>();

            queue.add(startId);

            boolean[] visited = new boolean[nodes.length];
            int[] distances = new int[nodes.length];

            Arrays.fill(distances, -1);
            distances[startId] = 0;

            while(!queue.isEmpty()){

                int node = queue.poll();

                for (int neighbour : nodes[node].neighbours){
                    if(distances[neighbour] < 0){
                        distances[neighbour] = EDGE_DISTANCE;
                        queue.add(neighbour);
                    } else if (distances[neighbour] > 0){
                        distances[neighbour] = distances[node] + EDGE_DISTANCE;
                        queue.add(neighbour);
                    }
                }
            }
            return distances;
        }
    }
    private static Graph graph;

    public static void main(String[] args) {
        input();
    }
    private static void input(){
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        for(int i = 0; i < q; i++){

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            Graph graph = new Graph(n);

            for(int j = 0; j < m; j++){

                int a = scanner.nextInt();
                int b = scanner.nextInt();

                graph.addEdge(a - 1, b- 1);

            }
            int s = scanner.nextInt();

            System.out.println("PATH" + Arrays.toString(graph.shortestPath(s - 1)));
        }
    }

}
