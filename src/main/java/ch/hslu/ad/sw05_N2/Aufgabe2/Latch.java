package ch.hslu.ad.sw05_N2.Aufgabe2;

import java.util.ArrayList;

public class Latch implements Synch {
    private final Object synchObj = new Object();
    private ArrayList<Thread> threadsList = new ArrayList<>();

    @Override
    public void acquire() throws InterruptedException {
        synchronized (synchObj) {
            threadsList.add(Thread.currentThread());
            synchObj.wait(1000);
            }

    }

    @Override
    public void release() {
        synchronized (synchObj) {
            synchObj.notifyAll();
        }
    }

    @Override
    public void cancel() {
        threadsList.forEach(Thread::interrupt);
    }
}
