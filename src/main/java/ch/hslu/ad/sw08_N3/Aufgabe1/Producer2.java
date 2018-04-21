package ch.hslu.ad.sw08_N3.Aufgabe1;

import java.util.concurrent.LinkedBlockingDeque;

public class Producer2 implements Runnable {
    private LinkedBlockingDeque<Integer> boundedBuffer;
    private int range;
    private long sum;

    public Producer2(LinkedBlockingDeque<Integer> boundedBuffer, int range) {
        this.boundedBuffer = boundedBuffer;
        this.range = range;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < range; i++) {
            sum += i;
            boundedBuffer.push(i);
        }
    }

    public long getSum() {
        return sum;
    }
}
