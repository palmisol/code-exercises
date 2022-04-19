import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        }); //3 2 1
        PriorityQueue<Integer> highers = new PriorityQueue<>(); // 4 5 6

        lowers.add(1);
        lowers.add(2);
        lowers.add(3);

        System.out.println(lowers.toString());



    }
}
