import java.util.List;

public class BarAction extends Thread {

    List<Counter> counters;

    public BarAction(List<Counter> counters) {
        this.counters = counters;
    }

    @Override
    public void run() {
        double totalSum = counters.stream().map(Counter::getPartialSum).reduce(Double::sum).orElse(0.0);
        System.out.println("Total sum: " + totalSum);
    }
}
