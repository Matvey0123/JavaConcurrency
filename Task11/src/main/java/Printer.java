import java.util.concurrent.Semaphore;

public class Printer {

    static Semaphore semChild = new Semaphore(0);
    static Semaphore semParent = new Semaphore(1);
    int count;

    void printChild() {
        try {
            semChild.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Child: line " + count + "!");
        semParent.release();
    }

    void printMain(int count) {
        try {
            semParent.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count = count;
        System.out.println("Main: line " + count + "!");
        semChild.release();
    }
}
