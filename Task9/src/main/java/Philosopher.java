import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {

    String name;
    Fork left, right;
    int thinkingTime;
    int eatingTime;

    public Philosopher(String name, Fork left, Fork right) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.thinkingTime = ThreadLocalRandom.current().nextInt(1, 6) * 1000;
        this.eatingTime = ThreadLocalRandom.current().nextInt(1, 3) * 1000;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Philosopher " + name + " is thinking.");
                Thread.sleep(this.thinkingTime);

                System.out.println("Philosopher " + name + " is hungry.");

                if (left.getId() < right.getId()) {
                    left.pickUp();
                    System.out.println("Philosopher " + name + " picked up " + left.getId() + " fork.");
                } else {
                    right.pickUp();
                    System.out.println("Philosopher " + name + " picked up " + right.getId() + " fork.");
                }
                if (left.getId() < right.getId()) {
                    right.pickUp();
                    System.out.println("Philosopher " + name + " picked up " + right.getId() + " fork.");
                } else {
                    left.pickUp();
                    System.out.println("Philosopher " + name + " picked up " + left.getId() + " fork.");
                }

                System.out.println("Philosopher " + name + " is eating.");
                Thread.sleep(this.eatingTime);

                left.putDown();
                System.out.println("Philosopher " + name + " putting down " + left.getId() + " fork.");
                right.putDown();
                System.out.println("Philosopher " + name + " putting down " + right.getId() + " fork.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
