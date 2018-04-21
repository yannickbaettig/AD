package ch.hslu.ad.sw08_N3.Aufgabe1;

import org.apache.logging.log4j.LogManager;

import java.util.NoSuchElementException;
import java.util.concurrent.LinkedBlockingDeque;

public class Consumer2 implements Runnable {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(Consumer2.class);
    private LinkedBlockingDeque<Integer> boundedBuffer;
    private long sum;

    public Consumer2(LinkedBlockingDeque<Integer> boundedBuffer) {
        this.boundedBuffer = boundedBuffer;
        this.sum = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sum += boundedBuffer.pop();
            } catch (NoSuchElementException e) {
                Thread.currentThread().interrupt();
            }

        }
    }

    public long getSum() {
        return sum;
    }
}
