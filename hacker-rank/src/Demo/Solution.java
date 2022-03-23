package Demo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    static int sumHigher = 0;
    static int sumLower = 0;

    static PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -1 * o1.compareTo(o2);
        }
    }); //3 2 1
    static PriorityQueue<Integer> highers = new PriorityQueue<>(); // 4 5 6

    static List<Integer> result = new ArrayList<>();
    /*
     * Complete the 'minimalHeaviestSetA' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void main(String[] args) {
        String result = minimalHeaviestSetAEdit(Arrays.asList(3, 7, 5, 6, 2)).toString();
        System.out.print(result);
    }

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        // Write your code here

        Collections.sort(arr, Collections.reverseOrder());

        Queue<Integer> B = new LinkedList<>(arr);
        LinkedList<Integer> A = new LinkedList<>();

        Integer sumA = 0;
        //Integer sumB = B.stream().mapToInt(Integer::intValue).sum();

        Integer sumB = 0;

        for (Integer number: B) {
            sumB = sumB + number;
        }

        while(sumA < sumB){
            Integer currentValue = B.poll();

            sumA = sumA + currentValue;
            sumB = sumB - currentValue;

            A.addFirst(currentValue);

        }

        return A;
    }
    public static List<Integer> minimalHeaviestSetAEdit(List<Integer> arr) {

        for (int i = 0; i < arr.size(); i++) {
            int number = arr.get(i);
            addNumber(number);
            reBalance(lowers, highers);

        }
        return result;
    }
    private static void addNumber(int number) {

        if(lowers.isEmpty() || number < lowers.peek()){
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }
    private static void reBalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size() - smallerHeap.size() >= 2){
            smallerHeap.add(biggerHeap.poll());
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.minimalHeaviestSetA(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
