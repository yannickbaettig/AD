package ch.hslu.ad.sw05_N2.Aufgabe3;

public class Producer implements Runnable {
    private BoundedBuffer<Integer> boundedBuffer;
    private int range;
    private long sum;

    public Producer(BoundedBuffer<Integer> boundedBuffer, int range) {
        this.boundedBuffer = boundedBuffer;
        this.range = range;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < range; i++) {
            try {
            sum += i;
            boundedBuffer.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getSum() {
        return sum;
    }
}
