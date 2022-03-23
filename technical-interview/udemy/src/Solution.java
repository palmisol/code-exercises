import java.util.*;

class Graph {
    int[][] graph;
    boolean[] visitedNodes;

    Graph(int nodes){
        this.graph = new int [nodes][nodes];
        this.visitedNodes = new boolean[nodes];
    }
    public void addEdge(int a, int b){
        graph[a][b] = 6;
    }

}

class Distance {

}

class Node {
    int node;
    Node(int n){ this.node = n; }
}


class Graph_ {

    private Map<Integer, List<Integer>> adjacentNodes;

    void addEdge(int n, int m){
        adjacentNodes.put(n, new ArrayList<>(m));
    }
}


public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        for(int i = 0; i < q; i++){

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            Graph graph = new Graph(n);

            for(int j = 0; j < m; j++){

                int a = scanner.nextInt();
                int b = scanner.nextInt();
                graph.addEdge(a - 1, b - 1);

            }

            int s = scanner.nextInt();

            int[] results = new int[n];
            Arrays.fill(results, -1);

            Distance distance = new Distance();
            //getDistance(g.adjList, results, s-1);

            // for(int k = 0; k < n; k++){
            //    if(k != s-1) System.out.print(results[k]+ " ");
            // }

            System.out.println();
        }
    }



}