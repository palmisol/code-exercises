package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/discuss/interview-question/364618/
public class MinStepsToMakePilesEqualHeight {

    public static void main(String[] args) {

        //makePilesEqual(new int[]{1,2,2,2,3,3,3,4,4});

    }
    private static void makePilesEqual(int[] piles){

        Arrays.sort(piles);

        Map<Integer, Integer> mapPiles = new TreeMap<>(Collections.reverseOrder());

        for(int number : piles){
            if(!mapPiles.containsKey(number)){
                mapPiles.put(number, 1);
            } else {
                int occ = mapPiles.get(number);
                mapPiles.put(number, ++occ);
            }
        }

        System.out.println(mapPiles.toString());

        int i = 0;
        int newSum = 0;
        int lastSum = -1;

        for(Map.Entry<Integer, Integer> entry: mapPiles.entrySet()){
            if(i < mapPiles.size() - 1){
                if(lastSum == -1){
                    lastSum = entry.getValue();
                    newSum = entry.getValue();
                } else {
                    newSum = entry.getValue() + lastSum + newSum;
                    lastSum = entry.getValue() + lastSum;
                }
               i++;
            }
        }

    }

}
