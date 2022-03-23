import java.util.*;

public class DijstrasAlgorithm {
    static class Node {

        private String name; // Name or index of the node
        List<Node> shortestPathList = new LinkedList<>(); //Shortest path to start
        Integer distance = Integer.MAX_VALUE; // value of this distance
        Map<Node, Integer> adjNodes = new HashMap<>(); // Adjacent node

        public void addDestination(Node destinationNode, int distance){ // Add adjacent node
            adjNodes.put(destinationNode, distance);
        }
        public Node(String name){
            this.name = name;
        }

    }
    static class Graph {

        Set<Node> nodes = new HashSet<>();

        public void addNode(Node node){
            nodes.add(node);
        }

    }
    public static Graph calculateShortestPath(Graph graph, Node start){

        start.distance = 0; //Starting node distance 0

        Set<Node> visitedNodes = new LinkedHashSet<>(); //
        Set<Node> unresolvedNodes = new LinkedHashSet<>(); // Nodes to be calculated their distance to start

        unresolvedNodes.add(start);

        while(unresolvedNodes.size() != 0){

            Node currentNode = getLowestDistanceNode(unresolvedNodes); //current node to calculate distance
            unresolvedNodes.remove(currentNode);

            for(Map.Entry<Node, Integer> adjPair: currentNode.adjNodes.entrySet()){ // Goes through every pair set

                Node adjNode = adjPair.getKey();
                Integer edgeWeight = adjPair.getValue();

                if(!visitedNodes.contains(adjNode)){
                    calculateMinimumDistance(adjNode, edgeWeight, currentNode);
                    unresolvedNodes.add(adjNode);
                }
            }
            visitedNodes.add(currentNode);
        }
        return graph;

    }
    private static void calculateMinimumDistance(Node adjNode, Integer edgeWeight, Node sourceNode) {

        Integer sourceDistance = sourceNode.distance;
        int sumDistanceWeight = sourceDistance + edgeWeight;

        if(sumDistanceWeight < adjNode.distance){
            adjNode.distance = sumDistanceWeight;

            LinkedList<Node> newShortestPathList = new LinkedList<>(sourceNode.shortestPathList);
            newShortestPathList.add(sourceNode);

            adjNode.shortestPathList = newShortestPathList;
        }
    }
    private static Node getLowestDistanceNode(Set<Node> unresolvedNodes) {
        
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        
        for(Node node : unresolvedNodes){
            
            int nodeDistance = node.distance;
            
            if(nodeDistance < lowestDistance){
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public static void main(String[] args) {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = DijstrasAlgorithm.calculateShortestPath(graph, nodeA);

        for ( Node node: graph.nodes) {
            System.out.print(node.name);
        }

    }

}
