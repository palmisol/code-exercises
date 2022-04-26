package dijstrasalgorithms;


import dijstrasalgorithms.Edge;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    // Represents a given vertex in the graph

    private String name;
    private boolean visited;
    private List<Edge> adjecencyList;
    private double distanceToStart;
    private Vertex predecessor;

    public Vertex(String name ){
        this.name = name;
        this.adjecencyList = new ArrayList<>();
        this.distanceToStart = Double.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getAdjecencyList() {
        return adjecencyList;
    }

    public void addNeighbour(Edge edge) {
        this.adjecencyList.add(edge);
    }

    public double getDistanceToStart() {
        return distanceToStart;
    }

    public void setDistanceToStart(double distanceToStart) {
        this.distanceToStart = distanceToStart;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public int compareTo(Vertex adjecentVertex) {
        //They are compared based on the distance parameter
        // v1 < v2 if v1.distance < v2.distance
        return Double.compare(this.distanceToStart, adjecentVertex.getDistanceToStart());
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }
}
