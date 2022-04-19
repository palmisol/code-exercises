package HackerRankInterviewPrep.HashTable;

import java.util.*;

public class RansomNote {

    public static void main(String[] args) {

        checkMagazineEdit(Arrays.asList("Attack", "at", "dawn", "paco", "josefa"), Arrays.asList("josefa","Attack", "at", "dawn"));

    }

    public static void checkMagazineEdit(List<String> magazine, List<String> note){
        HashMap<String, Integer> dictionary = new HashMap<>();

        if(magazine.size() >= note.size()){
            if(magazine.equals(note)){
                System.out.println("Yes");
            } else {
                for (String word : magazine) {
                    if(!dictionary.containsKey(word)){
                        dictionary.put(word, 1);
                    } else {
                        dictionary.put(word, dictionary.get(word) + 1);
                    }
                }
                for (String word : note) {
                    if(dictionary.containsKey(word)){
                        int occ = dictionary.get(word) - 1;
                        if(occ == 0){
                            dictionary.remove(word);
                        }
                    } else {
                        System.out.println("No");
                        break;
                    }
                }
            }
        } else {
            System.out.println("No");
        }
    }

    public static void checkMagazine(List<String> magazine, List<String> note) {

        Queue<String> visitedWords = new LinkedList<>();
        int i = 0, j = 0;

        if(magazine.equals(note)){
            System.out.println("Yes");
        } else {
            while(i < note.size()){
                String word = note.get(i);
                if(word.equals(magazine.get(j))){
                    visitedWords.add(word);
                    magazine.set(j, null);
                    j = 0;
                    i++;
                } else {
                    if(j + 1 < magazine.size()){
                        j++;
                    } else {
                        j = 0;
                        i++;
                    }
                }
            }
            System.out.println(visitedWords.equals(note) ? "Yes" : "No");
        }

    }

}


