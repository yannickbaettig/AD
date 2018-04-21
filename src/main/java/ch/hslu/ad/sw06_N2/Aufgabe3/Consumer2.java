package ch.hslu.ad.sw06_N2.Aufgabe3;

public class Consumer2 implements Runnable {
    private BoundedBuffer<Integer> boundedBuffer;
    private long sum;

    public Consumer2(BoundedBuffer<Integer> boundedBuffer) {
        this.boundedBuffer = boundedBuffer;
        this.sum = 0;
    }

    @Override
    public void run() {
        while (true){
            try {
                sum += boundedBuffer.pop();
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public long getSum() {
        return sum;
    }
}
