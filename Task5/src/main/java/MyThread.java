public class MyThread extends Thread {
    public void run() {
        System.out.println("Second thread started...");
        while (!isInterrupted()) {
            System.out.println("Working...");
        }
        System.out.println("Thread has been interrupted!");
    }
}
