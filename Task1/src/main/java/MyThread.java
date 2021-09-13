public class MyThread extends Thread {
    public void run() {
        System.out.print("Thread:  Line 1!\n");
        System.out.print("Thread:  Line 2!\n");
        System.out.print("Thread:  Line 3!\n");
        System.out.print("Thread:  Line 4!\n");
        System.out.print("Thread:  Line 5!\n");
        System.out.print("Thread:  Line 6!\n");
        System.out.print("Thread:  Line 7!\n");
        System.out.print("Thread:  Line 8!\n");
        System.out.print("Thread:  Line 9!\n");
        System.out.print("Thread:  Line 10!\n");
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        //thread.join();
        for (int i = 1; i < 11; i++) {
            System.out.println("Main: Line " + i + "!");
        }
    }
}
