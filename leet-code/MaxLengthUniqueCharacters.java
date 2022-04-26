package LeetCode;

import java.lang.reflect.Array;
import java.util.*;
//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
public class MaxLengthUniqueCharacters {

    public static void main(String[] args) {

        maxLengthEdit(Arrays.asList("a", "b", "c", "d", "e"));

    }
    public static boolean isUnique (String s){

        HashSet<Character> chars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(chars.contains(s.charAt(i))){
                return false;
            }
            chars.add(s.charAt(i));
        }
        return true;
    }
    private static int maxLengthEdit(List<String> arr){

        Queue<String> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();


        int i = 0, j = 0;
        String s = "";
        String checkStr = "";

        while (i < arr.size()){
            if(s.isEmpty()){
                s = arr.get(i);
                visited.add(i);
            }
            if(j < arr.size()){
                if(!visited.contains(j)){
                    String temp = s + arr.get(j);
                    visited.add(j);
                    if(isUnique(temp)){
                        if(checkStr.isEmpty()){
                           checkStr = temp;
                        } else {
                          if( temp.length() > checkStr.length() ){
                              checkStr = temp;
                          }
                        }
                    }
                }
                j++;
            } else {
                s = checkStr;
                i++;
                j = 0;
            }
        }

        return 0;
    }
    private static int maxLength(List<String> arr){

        String s = "";
        int result = 0;

        int i = 0;
        int j = 0;

        if(arr.size() == 1){
            if(isUnique(arr.get(0))) return arr.get(0).length();
        }

        while(i < arr.size()){
           if(s == ""){
               s = arr.get(i);
               if(isUnique(s)){
                   System.out.println(s);
                   if(s.length() > result){
                       result = s.length();
                   }
               }
           }
           if (j < arr.size()){
               if(i != j){
                   if(isUnique(s + arr.get(j))){
                       s = s + arr.get(j);
                       if(s.length() > result){
                           result = s.length();
                       }
                   }
               }
               j++;
           } else {
               i++;
               j = 0;
               s = "";
           }
        }
        return result;
    }
}

class CFG {
    static ArrayList<String> helper( ArrayList<String> arr, int ind){
        ArrayList<String> fin = new ArrayList<>();
        fin.add("");

        if(ind == arr.size()) return fin;

        ArrayList<String> tmp = helper(arr,ind + 1);

        ArrayList<String> ret = new ArrayList<>(tmp);

        String longestStr = "";

        for (String s : tmp) {
            String test = s + tmp.get(ind);
            if (MaxLengthUniqueCharacters.isUnique(test)) {
                if (longestStr.isEmpty()) {
                    longestStr = test;
                } else {
                    if(test.length() > longestStr.length()){
                        longestStr = test;
                    }
                }
            }
        }
        return ret;
    }
}

