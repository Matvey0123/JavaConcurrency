import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    Semaphore semaphore;
    int duration;
    String detailName;

    public Producer(Semaphore semaphore, int duration, String detailName) {
        this.semaphore = semaphore;
        this.duration = duration;
        this.detailName = detailName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            semaphore.release();
            System.out.println("Detail " + detailName + " is produced!");
        }
    }
}
