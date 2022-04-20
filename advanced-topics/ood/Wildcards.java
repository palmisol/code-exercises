package OOD;

import java.util.List;

public class Wildcards {

    public static void main(String[] args) {

    }

    private static void upperBoundedMethod(List<? extends Number> list){

    }
    private static void lowerBoundedMethod(List<? super Number> list){

    }
    private static void unboundedMethod(List<?> list){

    }

}
