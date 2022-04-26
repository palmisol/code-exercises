package LeetCode;

import java.util.*;

public class PartitionArrayIntoNSubsetsWithBalancedSum {

    public static void main(String[] args) {

        partition(new int[]{1, 2, 3, 4, 5}, 3);

    }
    private static List<List<Integer>> partition(int[] input, int n){

        int[] sum = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> sum[o1] - sum[o2.intValue()]);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
            pq.add(i);
        }

        for (int i = input.length - 1; i >= 0; i--) {
            int c = pq.poll();
            result.get(c).add(input[i]);
            sum[c] += input[i];
            pq.add(c);
        }

        System.out.println(result.toString());
        return result;
    }

}
