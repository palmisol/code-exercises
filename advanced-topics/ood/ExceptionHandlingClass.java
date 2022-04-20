package OOD;

import java.io.IOException;

public class ExceptionHandlingClass {

    public static void main(String[] args) {

    }
}

class UserDefined extends Exception {

}

class CheckedExceptions {

    private void ExceptionExample(){
         try {
             throw new IOException();
         } catch (IOException exception){
             System.out.println(exception);
         }
    }

}
