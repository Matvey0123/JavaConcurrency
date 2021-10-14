import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {

    String name;
    Fork left, right;
    int thinkingTime;
    int eatingTime;
    boolean hasEaten = false;

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

                Fork.forks.lock();
                while (!hasEaten) {
                    if (left.tryPickUp()) {

                        System.out.println("Philosopher " + name + " picked up " + left.getId() + " fork.");

                        if (right.tryPickUp()) {

                            System.out.println("Philosopher " + name + " picked up " + right.getId() + " fork.");

                            System.out.println("Philosopher " + name + " is eating.");
                            Thread.sleep(this.eatingTime);

                            hasEaten = true;

                            right.putDown();
                            System.out.println("Philosopher " + name + " putting down " + right.getId() + " fork.");
                        }
                        left.putDown();
                        System.out.println("Philosopher " + name + " putting down " + left.getId() + " fork.");
                    }

                    if (hasEaten) {
                        Fork.forks.lock();
                        Fork.tryLockFork.signalAll();
                        Fork.forks.unlock();
                        break;
                    } else {
                        Fork.tryLockFork.await();
                    }
                }
                hasEaten = false;


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
