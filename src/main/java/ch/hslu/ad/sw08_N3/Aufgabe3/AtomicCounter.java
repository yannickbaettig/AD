package ch.hslu.ad.sw08_N3.Aufgabe3;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Count {

    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void increment() {
        counter.incrementAndGet();
    }

    @Override
    public void decrement() {
        counter.decrementAndGet();
    }

    @Override
    public int get() {
        return counter.get();
    }

}
