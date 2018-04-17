package ch.hslu.ad.sw05_N2.Aufgabe1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Einfacher Task für die Demonstration eines Wait-Pools.
 */
public final class MyTask implements Runnable {
    private static final Logger LOG = LogManager.getLogger(MyTask.class);
    private final Object lock;
    private boolean unlock = false;

    public MyTask(final Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        LOG.info("warten...");
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException ex) {
                return;
            }

        }
        LOG.info("...aufgewacht");
    }

    public boolean isUnlock() {
        return unlock;
    }

    public void setUnlock(boolean unlock) {
        this.unlock = unlock;
    }
}