package ch.hslu.ad.sw05_N2.Aufgabe4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private static final Logger LOG = LogManager.getLogger(Counter.class);
    private static final Semaphore SEMA = new Semaphore(1, 10);
    private static long sum = 0;

    public static void main(final String[] args) throws InterruptedException {
        for (int j = 0; j <= 11; j++){
            Thread t = new Thread(() -> {
                for (int i=1;i<=10000;i++){
                    sum += i;
                }
                //LOG.info("calc finished, notifing...");
                try {
                    SEMA.release();
                } catch (InterruptedException e) {
                    return;
                }
            });
            t.start();
        }

        Thread.sleep(1000);

            Thread t2 = new Thread(() -> {
                //LOG.info("wait for result... ");
                try {
                    SEMA.acquire(3);
                } catch (InterruptedException e) {
                    return;
                }
                LOG.info("sum = " + sum);
            });

            t2.start();
        }
}
