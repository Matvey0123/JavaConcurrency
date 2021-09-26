public class MyThread implements Runnable {

    Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.count();
    }
}
