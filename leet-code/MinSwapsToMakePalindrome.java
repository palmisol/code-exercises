package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
//https://jaydeepwise.medium.com/count-minimum-swap-to-make-string-palindrome-2e2f19db2533
public class MinSwapsToMakePalindrome {

    public static void main(String[] args) {

        System.out.println(countSwapEdit("ntiin"));

    }
    private static char[] swapToRight(char[] chars, int j ){

        char temp = chars[j];
        chars[j] = chars[j + 1];
        chars[j + 1] = temp;

        return chars;

    }
    private static int countSwap(String s){

        int start = 0;
        int end = s.length() - 1;

        String l = "";
        String r = "";

        int count = - 1;

        char[] chars = s.toCharArray(); // O(n)

        while(end > start){

            char left = chars[start];
            char right = chars[end];
            if(end == start){
                return - 1;
            }
            if ( left == right) {
                int temp = end;
                while(chars[start] != chars[chars.length - 1 - start]){
                    chars = swapToRight(chars, temp);
                    temp++;
                    count++;
                }
                end = temp--;
                start++;
            } else {
                end--;
            }

        }

        return count;
    }
    private static int countSwapEdit(String s){

        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        int count = 0;

        while(start < s.length() / 2){

            char l = chars[start];
            char r = chars[end];

            if(start == end && s.length() % 2 == 0){
                return - 1;
            } else {
               //
            }
            if(l == r){
                int p = end;
                while(chars[start] != chars[chars.length - 1 - start]){
                    swapToRight(chars, p);
                    count++;
                    p++;
                }
                start++;
                end = chars.length - 1 -start;
            } else {
                end--;
            }
        }

        return count;
    }


}
