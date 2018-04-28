package ch.hslu.ad.sw06_N2.Aufgabe1;

/**
 * Demonstration eines Wait-Pools.
 */
public final class DemoWaitPool {
    private static final Object lock = new Object();
    public static void main(final String args[]) throws InterruptedException {
        final MyTask waiter = new MyTask(lock);
        waiter.run();
        new Thread(waiter).start();
        Thread.sleep(1000);
        synchronized (lock){
            lock.notify();
        }
    }


}