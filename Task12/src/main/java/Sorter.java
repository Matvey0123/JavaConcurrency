public class Sorter implements Runnable {

    ListOperator listOperator;

    public Sorter(ListOperator listOperator) {
        this.listOperator = listOperator;
    }

    @Override
    public void run() {
        while (!listOperator.isReady) {
            listOperator.sort();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted sorter!");
            }
        }
    }
}
