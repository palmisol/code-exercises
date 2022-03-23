package OOD;

public class MultiThreadClass {

    public static void main(String[] args) {
        MyThreadRunnable instance = new MyThreadRunnable();
        Thread thread = new Thread(instance);
        thread.start();
    }
}

class MyThreadRunnable implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
    }
}
