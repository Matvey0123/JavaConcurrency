import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable {

    Counter counter;
    CyclicBarrier cyclicBarrier;

    public MyThread(Counter counter, CyclicBarrier cyclicBarrier) {
        this.counter = counter;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        counter.count();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
