package AdvancedTopics;

public class MultithreadingClass {
    public static void main(String[] args) {

        int n = 10;

        Thread1 thread1 = new Thread1();

        for (int i = 0; i < n; i++) {
            thread1.run();
        }

    }
}

class Thread1 implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Thread1 running");
        } catch (Exception e){
            System.out.println("Exception " + e);
        }

    }
}
