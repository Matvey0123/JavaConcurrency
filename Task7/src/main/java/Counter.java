public class Counter {

    private static final int countIterations = 999999999;
    int position;
    int shift;
    double partialSum = 0.0d;

    public Counter(int position, int shift) {
        this.position = position;
        this.shift = shift;
    }

    public double getPartialSum() {
        return partialSum;
    }

    public void count() {
        while (position <= countIterations) {
            partialSum += 4.0d * Math.pow(-1.0d, position) / (2.0d * position + 1.0d);
            position += shift;
        }
    }
}
