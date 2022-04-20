public class Main {
    public static void main(String[] args) {

        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");

        vertexA.addNeighbour(new Edge(3, vertexA, vertexB));
        vertexA.addNeighbour(new Edge(5, vertexA, vertexC));

        vertexB.addNeighbour(new Edge(4, vertexB, vertexC));

        vertexC.addNeighbour(new Edge(15, vertexC, vertexD));

        vertexD.addNeighbour(new Edge(10, vertexD, vertexA));

        DijkstrasAlgorithm dijkstrasAlgorithm = new DijkstrasAlgorithm();
        dijkstrasAlgorithm.calculatePath(vertexA);
        System.out.println( dijkstrasAlgorithm.getShortestPathTo(vertexD));

    }
}
