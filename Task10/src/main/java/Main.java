public class Main {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        new ChildThread(printer);
        printer.printMain();

    }
}
