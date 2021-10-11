import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore ASemaphore = new Semaphore(0);
        Semaphore BSemaphore = new Semaphore(0);
        Semaphore CSemaphore = new Semaphore(0);

        new Thread(new Producer(ASemaphore, 1000, "A")).start();
        new Thread(new Producer(BSemaphore, 2000, "B")).start();
        new Thread(new Producer(CSemaphore, 3000, "C")).start();

        while (true) {
            ASemaphore.acquire();
            BSemaphore.acquire();
            System.out.println("A and B were combined in one module!");

            CSemaphore.acquire();
            System.out.println("Product received from Module and C!");
        }
    }
}
