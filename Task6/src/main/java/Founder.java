import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public final class Founder {
    private final List<Worker> workers;
    CyclicBarrier cyclicBarrier;

    public Founder(final Company company) {
        this.workers = new ArrayList<>(company.getDepartmentsCount());
        this.cyclicBarrier = new CyclicBarrier(company.getDepartmentsCount(), new BarAction(company));
        for (int i = 0; i < company.getDepartmentsCount(); i++) {
            workers.add(i, new Worker(cyclicBarrier, company.getFreeDepartment(i)));
        }
    }

    public void start() {
        for (final Runnable worker : workers) {
            new Thread(worker).start();
        }

    }
}