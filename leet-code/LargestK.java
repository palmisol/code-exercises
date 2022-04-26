package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LargestK {

    public static void main(String[] args) {

        largestK(new int[] {3, 2, -2, 5, -3}, 2, 3);

    }
    private static int largestK(int[] numbers , int L, int R){

        Set<Integer> set = new HashSet<>();
        int k = Integer.MIN_VALUE;
        for ( int number : numbers) {
            int absoluteValue = Math.abs(number);
            if (absoluteValue >= L && absoluteValue <= R) {
                set.add(number);
            }
            if(set.contains(number) && set.contains(-1 * number)){
                if(absoluteValue > k){
                    k = absoluteValue;
                }
            }
        }
        return k;
    }
}
