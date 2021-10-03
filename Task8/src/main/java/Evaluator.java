import java.util.concurrent.*;

public class Evaluator implements Callable {

    private final int threadNumber;
    private final int totalThreadCount;

    volatile static boolean isRunning = true;
    private volatile static long maxIteration = 0;

    static CountDownLatch latch;
    private static final Object obj = new Object();

    public Evaluator(int threadNumber, int totalThreadCount) {
        this.threadNumber = threadNumber;
        this.totalThreadCount = totalThreadCount;
    }

    @Override
    public Double call() throws InterruptedException {
        double result = 0;

        long iteration = (threadNumber) * 2L + 1;
        while (isRunning) {
            result += (1.0 / iteration * (1 - ((double) (iteration / 2) % 2) * 2));
            iteration += totalThreadCount * 2L;
        }

        synchronized (obj) {
            if (maxIteration < iteration) {
                maxIteration = iteration;
            }
        }

        latch.countDown();
        latch.await();

        while (iteration < maxIteration) {
            result += (1.0 / iteration * (1 - ((double) (iteration / 2) % 2) * 2));
            iteration += totalThreadCount * 2L;
        }
        return result;
    }
}
