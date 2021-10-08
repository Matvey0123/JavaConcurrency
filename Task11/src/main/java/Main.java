public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        new ChildThread(printer);

        for (int i = 1; i <= 10; i++) {
            printer.printMain(i);
        }
    }
}
