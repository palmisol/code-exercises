package OOD;

public class InterfacesClass {

    interface myInterface {

    }

    public static void main(String[] args) {
        new Thread(() -> {System.out.println("New Thread created");
        }).start();
    }

}
