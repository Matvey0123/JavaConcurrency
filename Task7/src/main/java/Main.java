import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final int countThreads = Integer.parseInt(args[0]);
        List<Counter> threads = new ArrayList<>(countThreads);
        for (int i = 0; i < countThreads; i++) {
            threads.add(i, new Counter(i, countThreads));
        }
        for (Counter counter : threads) {
            new Thread(counter).start();
        }
        double totalSum = threads.stream().map(Counter::getPartialSum).reduce(Double::sum).orElse(0.0);
        System.out.println("Total sum: " + (totalSum * 4.0));
    }
}
