public class Main {
    public static void main(String[] args) {
        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);
        Fork fork4 = new Fork(4);
        Fork fork5 = new Fork(5);

        Philosopher p1 = new Philosopher("first", fork1, fork5);
        Philosopher p2 = new Philosopher("second", fork2, fork1);
        Philosopher p3 = new Philosopher("third", fork3, fork2);
        Philosopher p4 = new Philosopher("fourth", fork4, fork3);
        Philosopher p5 = new Philosopher("fifth", fork5, fork4);

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
        new Thread(p4).start();
        new Thread(p5).start();
    }
}
