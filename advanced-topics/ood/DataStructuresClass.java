package OOD;

import java.util.*;

public class DataStructuresClass {
    public static void main(String[] args) {

        Set<String> hashSet = new HashSet<>(); // much faster & unordered
        Set<String> treeSet = new TreeSet<>(); // ordered
        Set<String> linkedHashSet = new LinkedHashSet<>(); //insertion ordered is as fast as HashSet

        List<String> arrayList = new ArrayList<>(); //Constant time positional access
        List<String> linkedList = new LinkedList<>(); //Add, delete and iterate constant time vs linear time on ArrayList

        Map<Integer, String> hashMap = new HashMap<>(); // Max speed
        Map<Integer, String> treeMap = new TreeMap<>(); //Key-ordered
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // Insertion-order iteration

        Queue<String> queue = new LinkedList<>(); //FIFO
        Queue<String> priorityQueue = new PriorityQueue<>(); // Natural ordering or imposed by user

        Deque<String> stack = new ArrayDeque<>(); //LIFO >> STACK



    }
}
