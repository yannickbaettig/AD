package ch.hslu.ad.sw06_N2.Aufgabe4;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Semaphore {
    private static final Logger LOG = LogManager.getLogger(Semaphore.class);
    private int sema; // Semaphor Zähler
    private int limit;

/*    public Semaphore(final int init) {
        sema = init;
    }*/

    /**
     * Erzeugt ein nach oben begrenztes Semaphor.
     * @param permits Anzahl Passiersignale zur Initialisierung.
     * @param limit maximale Anzahl der Passiersignale.
     * @throws IllegalArgumentException wenn Argumente ungültige
     * Werte besitzen.
     */
    public Semaphore(final int permits, final int limit) throws IllegalArgumentException {
        if (permits <= limit) {
            this.sema = permits;
            this.limit = limit;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public synchronized void acquire() throws InterruptedException {
        while (sema == 0) {
            LOG.info("aquire waiting " + sema);
            this.wait();
        }
        LOG.info("aquire continued " + sema);
        this.notifyAll();
        sema--;
    }

    public synchronized void release() throws InterruptedException {
        while (sema == limit){
            LOG.info("release waiting " + sema);
            this.wait();
        }
        LOG.info("release continued " + sema);
        this.notifyAll();
        sema++;
    }

    public synchronized void  acquire(int permits) throws InterruptedException {
        while (sema == 0) {
            LOG.info("aquire waiting " + sema);
            this.wait();
        }
        LOG.info("aquire continued " + sema);
        this.notifyAll();

        sema -= permits;
    }

    public synchronized void release(int permits) throws InterruptedException {
        while (sema == limit){
            LOG.info("release waiting " + sema);
            this.wait();
        }
        LOG.info("release continued " + sema);
        this.notifyAll();
        sema += permits;
    }
}