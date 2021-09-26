import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final int countThreads = Integer.parseInt(args[0]);
        List<Counter> counters = new ArrayList<>(countThreads);
        for (int i = 0; i < countThreads; i++) {
            counters.add(i, new Counter(i, countThreads));
        }
        Runtime.getRuntime().addShutdownHook(new BarAction(counters));
        for (Counter counter : counters) {
            new Thread(new MyThread(counter)).start();
        }
    }
}
