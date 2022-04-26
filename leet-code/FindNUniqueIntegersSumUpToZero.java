package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
public class FindNUniqueIntegersSumUpToZero {

    public static void main(String[] args) {
        sumZero(100);
    }
    private static int[] sumZero(int n){

        int[] result = new int[n];
        int v = 0;

        for (int i = 0; i < n; i++) {
            if(i < n/2){
                result[i] = ++v;
            } else {
                if(n / 2 == i){
                    v = 0;
                    result[i] = n % 2 != 0 ? v : ++v * -1;
                } else {
                    result[i] = ++v * -1;
                }
            }
        }

        System.out.println(Arrays.toString(result));
        return null;
    }
}
