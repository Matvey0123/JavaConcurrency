import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        int totalThreadCount = Integer.parseInt(args[0]);
        Evaluator.latch = new CountDownLatch(totalThreadCount);

        ExecutorService es = Executors.newFixedThreadPool(totalThreadCount);

        List<Future<Double>> futuresValues = new ArrayList<>();

        for (int i = 0; i < totalThreadCount; i++) {
            Callable callable = new Evaluator(i, totalThreadCount);
            Future future = es.submit(callable);
            futuresValues.add(future);
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            double result = 0;
            Evaluator.isRunning = false;
            for (Future<Double> futureValue : futuresValues) {
                try {
                    result += futureValue.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(4 * result);
        }));
    }
}
