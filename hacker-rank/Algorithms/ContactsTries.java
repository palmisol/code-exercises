package Algorithms;

import java.util.*;

import static java.util.stream.Collectors.joining;

class Contacts {

    /*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     */

    public static class Node{
        private static int NUMBER_OF_CHARACTERS = 26;
        Node[] children = new Node[NUMBER_OF_CHARACTERS];
        int size = 0;
        char character;

        private static int getCharIndex(char c){
            return c - 'a';
        }
        private Node getNode(char c) {
            return children[getCharIndex(c)];
        }
        private void setNode(char c, Node node){
            character = c;
            children[getCharIndex(c)] = node;
        }
        public void add(String s) {
            add(s, 0);
        }
        private void add(String s, int index){
            size++;
           if(index == s.length()) return;

           char current = s.charAt(index);
           Node child = getNode(current);

           if(child == null){
               child = new Node();
               setNode(current, child);
           }
           child.add(s, index + 1);
        }
        public int findCount(String s, int index) {
            if(index == s.length()){
                return size;
            }
            Node child = getNode(s.charAt(index));
            if(child == null){
                return 0;
            }
            return child.findCount(s, index + 1);
        }
    }
    public static class NodeMap{
        //private static int NUMBER_OF_CHARACTERS = 26;
        //Node[] children = new Node[NUMBER_OF_CHARACTERS];
        HashMap<Character, NodeMap> children = new HashMap<>();
        int size = 0;

        private NodeMap getNode(char c) {
            return children.get(c);
        }
        private void setNode(char c, NodeMap nodeMap){
            children.put(c, nodeMap);
        }
        public void add(String s) {
            add(s, 0);
        }
        private void add(String s, int index){
            size++;
            if(index == s.length()) return; // this means it has scanned the whole word

            char current = s.charAt(index);
            NodeMap child = getNode(current);

            if(child == null){
                child = new NodeMap();
                setNode(current, child);
            }
            child.add(s, index + 1);
        }
        public int findCount(String s, int index) {
            if(index == s.length()){
                return size;
            }
            NodeMap child = getNode(s.charAt(index));
            if(child == null){
                return 0;
            }
            return child.findCount(s, index + 1);
        }
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        // Write your code here
        //Node node = new Node();
        NodeMap nodeMap = new NodeMap();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < queries.size(); i++) {
            if(queries.get(i).get(0).equals("add")){
                //node.add(queries.get(i).get(1));
                nodeMap.add(queries.get(i).get(1));
            }
            if(queries.get(i).get(0).equals("find")){
                //result.add(node.findCount(queries.get(i).get(1), 0));
                result.add(nodeMap.findCount(queries.get(i).get(1), 0));
            }

        }
        return result;
    }
}
public class ContactsTries {
    public static void main(String[] args) {

        List<List<String>> queries = new ArrayList<>();

        queries.add(Arrays.asList("add", "hack"));
        queries.add(Arrays.asList("add", "hackerrank"));
        queries.add(Arrays.asList("add", "mario"));
        queries.add(Arrays.asList("find", "hac"));
        queries.add(Arrays.asList("find", "hak"));
        queries.add(Arrays.asList("add", "mar"));

        List<Integer> result = Contacts.contacts(queries);

        System.out.println(result.toString());

    }
}