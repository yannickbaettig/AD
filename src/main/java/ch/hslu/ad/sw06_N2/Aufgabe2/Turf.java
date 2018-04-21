package ch.hslu.ad.sw06_N2.Aufgabe2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Turf {
    private static final Logger LOG = LogManager.getLogger(Turf.class);

    public static void main(final String[] args) throws InterruptedException {
        Synch starterBox = new Latch();
        for (int i = 1; i < 6; i++) {
            new Thread(new RaceHorse(starterBox),"Horse "+i).start();
        }
        // Thread.sleep(5000);

        starterBox.release();
        starterBox.cancel();
        LOG.info("Start...");
    }

}
