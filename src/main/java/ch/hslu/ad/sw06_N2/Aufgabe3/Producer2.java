package ch.hslu.ad.sw06_N2.Aufgabe3;

public class Producer2 implements Runnable {
    private BoundedBuffer<Integer> boundedBuffer;
    private int range;
    private long sum;

    public Producer2(BoundedBuffer<Integer> boundedBuffer, int range) {
        this.boundedBuffer = boundedBuffer;
        this.range = range;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < range; i++) {
            try {
            sum += i;
            boundedBuffer.push(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getSum() {
        return sum;
    }
}
