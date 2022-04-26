package DataStructures.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class AdjacencyListClass {

    public static void main(String[] args) {

        int vertices = 5;
        Set<Integer> adj[] = new HashSet[vertices];
        GraphEdit graphEdit = new GraphEdit();
        graphEdit.addEdge(adj, 0, 1);

    }

}

class GraphEdit{
    void addEdge(Set<Integer> adj[], int source, int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }
}

class Graph {
    int vertex;
    Set<Integer> list[];

    Graph(int vertex){
        this.vertex = vertex;
        list = new HashSet[vertex];
        for (int i = 0; i < vertex; i++) {
            list[i] = new HashSet<>();
        }
    }
    void addEdge(int source, int destination){
        list[source].add(destination);
    }

}