import java.util.*;

public class Graphs {

    private static HashMap<Integer, List<Integer>> adjacentNodes;

    public static void main(String[] args) {

        adjacentNodes = new HashMap<Integer, List<Integer>>();

        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(4, 5);
        addEdge(1, 2);

        System.out.println("Finished");

    }
    private static void addEdge(int n, int m){

        adjacentNodes.putIfAbsent(n, new ArrayList<>());
        adjacentNodes.get(n).add(m);

        adjacentNodes.putIfAbsent(m, new ArrayList<>());
        adjacentNodes.get(m).add(n);
    }


}
