package OOD;

import java.util.Arrays;
import java.util.function.Function;

class Recursive<I> {
    public I func;
}

public class RecursiveClass {

    public static void main(String[] args) {

        String[] y = {"1", "2", "15", "-7", "300"};

        System.out.println(Arrays.toString(y));
    }

    private static void func(int a){
        a++;
    }

}
