public class Main {

    public static void startNewThread(int id, String[] text) {
        String[] cloned = text.clone();
        Thread thread = new Thread(new MyThread(id, cloned));
        thread.start();
    }

    public static void main(String[] args) {
        String[] text = new String[]{"1", "2", "3", "4", "5"};
        startNewThread(1, text);
        text[0] = "A";
        startNewThread(2, text);
        text[1] = "B";
        startNewThread(3, text);
        text = new String[]{"ab", "abcd", "abcde"};
        startNewThread(4, text);
    }
}