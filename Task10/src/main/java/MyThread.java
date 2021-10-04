public class MyThread extends Thread {

    private static boolean isParentQueue = true;

    public void run() {
        for (int i = 1; i < 11; i++) {
            if (!isParentQueue) {
                System.out.println("Child: Line " + i + "!");
                isParentQueue = true;
            } else {
                i--;
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        for (int i = 1; i < 11; i++) {
            if (isParentQueue) {
                System.out.println("Main: Line " + i + "!");
                isParentQueue = false;
            } else {
                i--;
            }
        }
    }
}
