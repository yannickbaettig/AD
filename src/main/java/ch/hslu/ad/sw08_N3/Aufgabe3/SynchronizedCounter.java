package ch.hslu.ad.sw08_N3.Aufgabe3;

public final class SynchronizedCounter implements Count {

    private int counter = 0;

    @Override
    public synchronized void increment() {
        counter++;
    }

    @Override
    public synchronized void decrement() {
        counter--;
    }

    @Override
    public synchronized int get() {
        return counter;
    }
}
