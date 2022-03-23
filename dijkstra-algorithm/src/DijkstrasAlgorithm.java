import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {

    public void calculatePath(Vertex source){
        source.setDistanceToStart(0);

        PriorityQueue<Vertex> queue = new PriorityQueue<>(); // Natural ordering heap tree
        queue.add(source);

        while (!queue.isEmpty()){

            Vertex currentVertex = queue.poll(); // Retrieves and remove the head of this list

            for (Edge edge: currentVertex.getAdjecencyList()) {

                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();

                double currentDistance = currentVertex.getDistanceToStart() + edge.getWeight();

                if (currentDistance < v.getDistanceToStart()) {
                    queue.remove(v);
                    v.setDistanceToStart(currentDistance);
                    v.setPredecessor(currentVertex);
                    queue.add(v);
                }

            }
        }

    }
    public List<Vertex> getShortestPathTo(Vertex targetVertex){

        List<Vertex> path = new ArrayList<>();
        for(Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()){
            path.add(vertex);
        }
        Collections.reverse(path);

        return path;
    }

}
