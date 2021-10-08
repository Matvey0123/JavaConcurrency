public class ChildThread implements Runnable {
    Printer printer;

    public ChildThread(Printer printer) {
        this.printer = printer;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            printer.printChild();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
