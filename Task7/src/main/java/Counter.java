public class Counter implements Runnable {

    private static final int countIterations = 99999;
    int position;
    int shift;
    double partialSum = 0.0;

    public Counter(int position, int shift) {
        this.position = position;
        this.shift = shift;
    }

    public double getPartialSum() {
        return partialSum;
    }

    @Override
    public void run() {
        while (position <= countIterations) {
            partialSum += Math.pow(-1.0, position) / (2.0 * position + 1.0);
            position += shift;
        }
    }
}
