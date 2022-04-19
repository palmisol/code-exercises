package Algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here

        Stack<Character> stack = new Stack<>(); //LIFO
        String result = "NO";

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()){
                    return "NO";
                } else {
                    char pop_value = stack.pop();
                    if (s.charAt(i) == '}' && pop_value != '{'){
                        return "NO";
                    } else if (s.charAt(i) == ')' && pop_value != '('){
                        return "NO";
                    } else if (s.charAt(i) == ']' && pop_value != '['){
                        return "NO";
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return "YES";
        } else {
            return "NO";
        }

    }
    public static String isBalanced2(String s){
        Stack<Character> stack = new Stack<>();
        String result = "YES";
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('{','}');
        hashMap.put('[',']');
        hashMap.put('(',')');


            for (Character character : s.toCharArray()) {
                if(hashMap.containsKey(character)){
                    stack.push(hashMap.get(character));
                } else {
                    if(stack.isEmpty() || stack.pop() != character){
                        result = "NO";
                        break;
                    }
                }
            }

        return result;

    }

}

public class SolutionBalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
