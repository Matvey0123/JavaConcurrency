public class ChildThread implements Runnable {

    Printer printer;

    ChildThread(Printer printer) {
        this.printer = printer;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            printer.printChild();
        }
    }
}
