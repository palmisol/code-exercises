package HackerRankInterviewPrep;

import DataStructures.LinkedLists;
import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class ArrayManipulation {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] computation = new long[n];


        for (List<Integer> abk : queries) {
            Integer a = abk.get(0) - 1;
            Integer b = abk.get(1) - 1;
            Integer k = abk.get(2);

            computation[a] += k;
            if (b + 1 < n ) {
                computation[b + 1] -= k;
            }
        }

        long max = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += computation[i];
            max = Math.max(max, sum);
        }

        return max;
    }

}
