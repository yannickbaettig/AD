package ch.hslu.ad.sw08_N3.Aufgabe1;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private LinkedBlockingDeque<Integer> boundedBuffer;
    private long sum;

    public Consumer(LinkedBlockingDeque<Integer> boundedBuffer) {
        this.boundedBuffer = boundedBuffer;
        this.sum = 0;
    }

    @Override
    public void run() {
        while (true){
            try {
                sum += boundedBuffer.poll(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public long getSum() {
        return sum;
    }
}
