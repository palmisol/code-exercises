package LeetCode;

import java.util.*;
//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {
        minDeletionsEdit("bbcebab");
    }
    public static int minDeletionsEdit2(String s ){


        return 0;
    }
    public static int minDeletionsEdit(String s){

        Set<Character> visitedCharacters = new HashSet<>();
        Set<Integer> frequencies = new HashSet<>();
        HashMap<Integer, Queue<Character>> frequencyCharacters = new HashMap<>();

        int i = 0;
        int j = 0;
        char visiting = ' ';
        int frequency = 1;
        int count = 0;

        boolean checkFrequency = true;

        while(i < s.length()){
            if(checkFrequency){
                visiting = s.charAt(i);
                if(!visitedCharacters.contains(visiting)){
                    if(j < s.length()){
                        if(visiting == s.charAt(j) && j != i){
                            frequency++;
                        }
                        j++;
                    }
                    else {
                        visitedCharacters.add(visiting);
                        checkFrequency = false;
                    }
                } else {
                    i++;
                }
            } else {
                if(frequencies.contains(frequency) && frequency != 0){
                    frequency--;
                    count++;
                } else {
                    frequencies.add(frequency);
                    frequency = 1;
                    checkFrequency = true;
                    j = 0;
                    i++;
                }
            }
        }

        /*while(i < s.length()){
            visiting = s.charAt(i);
            if(!visitedCharacters.contains(visiting)){
                if(i != j){
                    if(j < s.length()){
                        if(visiting == s.charAt(j)){
                            frequency++;
                        }
                        j++;
                    } else {
                        Queue<Character> characterQueue;
                        if(!frequencyCharacters.containsKey(frequency)){
                            characterQueue = new LinkedList<>();
                        } else {
                            characterQueue = frequencyCharacters.get(frequency);
                        }
                        characterQueue.add(visiting);
                        frequencyCharacters.put(frequency, characterQueue);

                        visitedCharacters.add(visiting);

                        j = 0;
                        frequency = 1;
                        i++;
                    }
                } else {
                    j++;
                }
            } else {
                i++;
            }
        }*/

        /*
        while(i < s.length()){
            visiting = s.charAt(i);
            if(!visitedCharacters.contains(visiting)){
                if(i != j){
                    if(j < s.length()){
                        if(visiting == s.charAt(j)){
                            frequency++;
                        }
                        j++;
                    }
                    else {
                        visitedCharacters.add(visiting);
                        System.out.println(visiting +" "+ frequency);

                        while(frequencies.contains(frequency) && frequency != 0){
                            frequency--;
                            count++;

                        }
                        frequencies.add(frequency);

                        j = 0;
                        frequency = 1;
                        i++;
                    }
                } else {
                    j++;
                }
            } else {
                i++;
            }
        }
*/

        return count;

    }
    public static int minDeletions(String s) {

        HashMap<Character, Integer> charOccurrences = new HashMap<>();

        for (int i = 0; i < s.length(); i ++) {
            if (!charOccurrences.containsKey(s.charAt(i))) {
                charOccurrences.put(s.charAt(i), 1);
            } else {
                int occ = charOccurrences.get(s.charAt(i));
                charOccurrences.put(s.charAt(i), ++occ);
            }
        }
        System.out.println(charOccurrences.toString());

        HashMap<Integer, Queue<Character>> occCharacters = new HashMap<>();
        for (Map.Entry<Character, Integer> charOccurrence : charOccurrences.entrySet()){
            Queue<Character> queueChars;

            if(!occCharacters.containsKey(charOccurrence.getValue())){
                queueChars = new LinkedList<>();
            } else {
                queueChars = occCharacters.get(charOccurrence.getValue());
            }
            queueChars.add(charOccurrence.getKey());
            occCharacters.put(charOccurrence.getValue(), queueChars);

        }
        System.out.println(occCharacters.toString());

        int count = 0;
        for(Map.Entry<Integer, Queue<Character>> charOccurrence : occCharacters.entrySet()){
            if(charOccurrence.getValue().size() > 1){
                int frequency = charOccurrence.getKey();

            }
        }
        System.out.println(count);
        return count;

    }

}