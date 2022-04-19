package Algorithms;

// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClassDijkstras {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }

            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.dijkstra(V, adj, S);

            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.

    class Node {
        boolean visited = false;
        int index;
        int startToNodeWeight = 0;

        Node(int index){
            this.index = index;
        }
    }
    class Edge{
        int weight;
        Node source;
        Node destination;
        Edge(Node source, Node destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    class Graph {

    }

    static void shortestDistance(int start){

    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        ArrayList<Node> nodes = new ArrayList<>(V);
        Set<Integer> visited = new HashSet<>(V);

        // while vertices remain univisted
            // Visiti unvisited vertext with smallest known distance from start veretx
            //FOR EACH unvisited neighbour of the current vertex
                //calculate the distance from start vertex
                // If the calculated distance is this vertex is less than the known distance
                    // Update shortest distance to this vertex
                    // Update the previous vertext with the current vertex
                //End if
            //NEXT unvisted neghbour
            // Add the current vertes to the list of visited vertice s
        //END WHILE


        // Write your code here
        return null;
    }
}

