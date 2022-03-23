import java.util.*;

public class Dijkstras {

    public Dijkstras(int[][] input) {

        //SPT with the size of input
        //noSTP with the size of input
        // weighted vertices ?
        // loop This
        // looks for adjacent vertices and calculate the weight
        // add the minimum to SPT
        // then calculate the adjacent vertices
        // Select the minimum vertices not in SPT
        // Then calculate distance to adjacent vertices
        // LOOP

        Stack SPTStack = new Stack();
        HashSet<Integer> visitedNodes = new HashSet<>();

        int minWeight = Integer.MAX_VALUE;


        int x = 0;
        int nextIndex = 0;
        int lastIndex = 0;

        visitedNodes.add(x);

        for (int[] node: input) {

            for (int y = x + 1; y < node.length; y++) {

                if (node[y] != 0) {

                    if (node[y] < minWeight) {

                        minWeight = input[x][y];
                        nextIndex = y;

                    }
                }
            }
            minWeight = Integer.MAX_VALUE;
            System.out.println(x);
            visitedNodes.add(x);
            x = nextIndex;
        }
    }

}
