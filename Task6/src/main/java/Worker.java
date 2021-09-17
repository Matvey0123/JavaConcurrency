import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable {

    CyclicBarrier cyclicBarrier;
    Department department;

    public Worker(CyclicBarrier cyclicBarrier, Department department) {
        this.cyclicBarrier = cyclicBarrier;
        this.department = department;
    }

    @Override
    public void run() {
        department.performCalculations();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Exception in run method");
        }
        System.out.println("Department " + department.getIdentifier() + " has completed its work! It worked " + department.getWorkingSeconds() + " seconds.");
    }
}
