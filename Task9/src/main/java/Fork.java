public class Fork {

    int id;
    boolean isPickedUp;

    public Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public synchronized void pickUp() throws InterruptedException {
        while (isPickedUp) {
            wait();
        }
        isPickedUp = true;
    }

    public synchronized void putDown() throws InterruptedException{
        isPickedUp = false;
    }
}
